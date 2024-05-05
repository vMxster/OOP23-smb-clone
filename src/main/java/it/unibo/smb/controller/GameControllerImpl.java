package it.unibo.smb.controller;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.smb.commons.Point2D;
import it.unibo.smb.model.GameModel;
import it.unibo.smb.model.GameModelImpl;
import it.unibo.smb.model.entity.obstacles.CircularSaw;
import it.unibo.smb.model.entity.obstacles.Platform;
import it.unibo.smb.model.entity.player.MeatBoy;
import it.unibo.smb.model.entity.target.BandageGirl;
import it.unibo.smb.model.statistic.StatisticManager;
import it.unibo.smb.model.statistic.factory.manager.StatisticManagerFactoryImpl;
import it.unibo.smb.model.tiles.Tile;
import it.unibo.smb.view.window.GameWindow;
import it.unibo.smb.view.window.GameWindow.PanelType;
import it.unibo.smb.view.window.factory.GameWindowFactoryImpl;

/**
 * The GameControllerImpl class implements the GameController interface and
 * provides control logic for the game.
 */
public class GameControllerImpl implements GameController {

    private static final int INITIAL_DELAY = 0;
    private static final int FRAME_RATE = 17;
    private final GameWindow gameWindow;
    private final Timer timer;
    private final StatisticManager statisticManager;
    private GameModel gameModel;
    private TimerTask gameLoop;
    private TimerTask gameTimer;
    private int centiSeconds;
    private int currentDeaths;

    /**
     * Constructs a new GameControllerImpl instance.
     * Initializes the game model and the game window.
     */
    public GameControllerImpl() {
        this.timer = new Timer();
        this.statisticManager = new StatisticManagerFactoryImpl()
                .createStatisticManager();
        this.gameWindow = new GameWindowFactoryImpl()
                .createSwingGameWindow(this);
    }

    @Override
    public final void startWindow() {
        this.gameWindow.setPanelVisible();
    }

    @Override
    public final void start(final String sectionName, final int levelNumber) {
        this.gameModel = selectLevel(sectionName, levelNumber);
        this.gameModel.initializeCoords();
        this.gameWindow.start(
                switch (EnvironmentType.valueOf(sectionName.toUpperCase(Locale.US))) {
                    case FOREST -> EnvironmentType.FOREST;
                    case FACTORY -> EnvironmentType.FACTORY;
                    }, this);
        this.gameLoop = createGameLoopTask();
        this.gameTimer = createGameTimerTask();
        timer.schedule(gameLoop, INITIAL_DELAY, FRAME_RATE);
        timer.schedule(gameTimer, INITIAL_DELAY, 10);
        this.newDeathsSession();
    }

    private GameModel selectLevel(final String sectionName, final int levelNumber) {
        final LevelType level = switch (
                EnvironmentType.valueOf(sectionName.toUpperCase(Locale.US))) {
            case FOREST -> switch (levelNumber) {
                case 1 -> LevelType.FOREST_LEVEL_1;
                case 2 -> LevelType.FOREST_LEVEL_2;
                default -> throw new IllegalArgumentException("Invalid level number for Forest environment: " + levelNumber);
            };
            case FACTORY -> switch (levelNumber) {
                case 1 -> LevelType.FACTORY_LEVEL_1;
                case 2 -> LevelType.FACTORY_LEVEL_2;
                default -> throw new IllegalArgumentException("Invalid level number for Factory environment: " + levelNumber);
            };
        };
        return new GameModelImpl(level.getSourceMap(), this);
    }

    private TimerTask createGameLoopTask() {
        return new TimerTask() {
            @Override
            public void run() {
                gameModel.getCollisionHandler().updateMeatBoy();
                gameModel.getCollisionHandler().check();
                gameWindow.paint(centiSeconds, currentDeaths);
            }
        };
    }

    private TimerTask createGameTimerTask() {
        this.centiSeconds = 0;
        return new TimerTask() {
            @Override
            public void run() {
                centiSeconds++;
            }
        };
    }

    private void newDeathsSession() {
        this.currentDeaths = 0;
    }

    @Override
    public final List<List<Optional<Tile>>> getStationary() {
        return this.gameModel.getStationary();
    }

    @Override
    public final List<CircularSaw> getSaws() {
        return this.gameModel.getSaws();
    }

    @Override
    public final List<Platform> getPlatforms() {
        return this.gameModel.getPlatforms();
    }

    @Override
    public final int getNumRows() {
        return this.gameModel.getNumRows();
    }

    @Override
    public final int getNumCols() {
        return this.gameModel.getNumCols();
    }

    @Override
    public final BandageGirl getBandageGirl() {
        return this.gameModel.getBandageGirl();
    }

    @Override
    public final MeatBoy getMeatBoy() {
        return this.gameModel.getMeatBoy();
    }

    @Override
    public final GameModel getGameModel() {
        return gameModel;
    }

    @SuppressFBWarnings(
        value = "UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR", 
        justification = "The victory method is never called before start, "
                + "so gameloop and gametimer will always be initialized correctly")
    @Override
    public final void victory() {
        this.statisticManager.updateRecord(centiSeconds, this.getGameModel().getLevelName());
        this.gameWindow.updateStats();
        this.gameLoop.cancel();
        this.gameTimer.cancel();
        this.gameWindow.displayVictoryMessage();
        this.gameWindow.switchPanel(PanelType.MENU);
    }

    @Override
    public final void isDead() {
        this.currentDeaths++;
        this.statisticManager.addDeaths(this.getGameModel().getLevelName());
    }

    @Override
    public final int getDeaths(final LevelType level) {
        return this.statisticManager.whichLevel(level).getDeaths();
    }

    @Override
    public final int getTimeRecord(final LevelType level) {
        return this.statisticManager.whichLevel(level).getRecordTime();
    }

    @Override
    public final Point2D<Double, Double> getMeatBoyStartCoord() {
        return this.gameModel.getMeatBoyStartCoord();
    }

    @SuppressFBWarnings(
        value = "UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR", 
        justification = "The esc method is never called before start, "
                + "so gameloop and gametimer will always be initialized correctly")
    @Override
    public final void esc() {
        this.gameLoop.cancel();
        this.gameTimer.cancel();
        this.gameWindow.switchPanel(PanelType.MENU);
    }

    @SuppressFBWarnings("EI_EXPOSE_REP")
    @Override
    public final GameWindow getGameWindow() {
        return gameWindow;
    }

    @Override
    public final void stopMovingMeatBoy(final int keyCode) {
        this.getGameModel().getCollisionHandler().stopMovingMeatBoy(keyCode);
    }

    @Override
    public final void moveMeatBoy(final int keyCode) {
        this.getGameModel().getCollisionHandler().moveMeatBoy(keyCode);
    }
}
