package it.unibo.controller;

import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import it.unibo.commons.Constants;
import it.unibo.commons.Point2D;
import it.unibo.model.GameModel;
import it.unibo.model.GameModelImpl;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.statistic.Statistic;
import it.unibo.model.statistic.StatisticImpl;
import it.unibo.model.tiles.Tile;
import it.unibo.view.window.GameWindow;
import it.unibo.view.window.GameWindow.PanelType;
import it.unibo.view.window.factory.GameWindowFactoryImpl;

/**
 * The GameControllerImpl class implements the GameController interface and
 * provides control logic for the game.
 */
public class GameControllerImpl implements GameController {

    private static final int INITIAL_DELAY = 0;
    private static final int FRAME_RATE = 17;
    private final GameModel gameModel;
    private final GameWindow gameWindow;
    private final Timer timer;
    private final Statistic statistic;
    private TimerTask gameLoop;
    private TimerTask gameTimer;
    private int centiSeconds;
    private int currentDeaths;


    /**
     * Constructs a new GameControllerImpl instance.
     * Initializes the game model and the game window.
     */
    public GameControllerImpl() {
        this.gameModel = new GameModelImpl(Constants.SOURCE_MAP, this);
        this.gameWindow = new GameWindowFactoryImpl().createSwingGameWindow(this);
        this.timer = new Timer();
        this.statistic = new StatisticImpl();
    }

    /**
     * Starts the GameWindow.
     */
    @Override
    public void startWindow() {
        this.gameWindow.setPanelVisible();
    }

    /**
     * Starts the game loop.
     */
    @Override
    public void start() {
        this.gameModel.initializeCoords();
        this.gameLoop = createGameLoopTask();
        this.gameTimer = createGameTimerTask();
        timer.schedule(gameLoop, INITIAL_DELAY, FRAME_RATE);
        timer.schedule(gameTimer, INITIAL_DELAY, 10);
        this.newDeathsSession();
    }

    /**
     * Creates a TimerTask for the game loop.
     * This method is responsible for creating a task that represents the game loop.
     *
     * @return A TimerTask representing the game loop task.
     */
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

    /**
     * Creates a TimerTask for the game timer.
     * This method is responsible for creating a task that handles game timing and updates.
     *
     * @return A TimerTask representing the game timer task.
     */
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

    /**
     * Returns the list of stationary tiles.
     *
     * @return The list of stationary tiles.
     */
    @Override
    public List<List<Optional<Tile>>> getStationary() {
        return this.gameModel.getStationary();
    }

    /**
     * Returns the list of circular saws.
     *
     * @return The list of circular saws.
     */
    @Override
    public List<CircularSaw> getSaws() {
        return this.gameModel.getSaws();
    }

    /**
     * Returns the list of platforms.
     *
     * @return The list of platforms.
     */
    @Override
    public List<Platform> getPlatforms() {
        return this.gameModel.getPlatforms();
    }

    /**
     * Returns the number of rows in the game.
     *
     * @return The number of rows.
     */
    @Override
    public int getNumRows() {
        return this.gameModel.getNumRows();
    }

    /**
     * Returns the number of columns in the game.
     *
     * @return The number of columns.
     */
    @Override
    public int getNumCols() {
        return this.gameModel.getNumCols();
    }

    /**
     * Returns the BandageGirl entity.
     *
     * @return The BandageGirl entity.
     */
    @Override
    public BandageGirl getBandageGirl() {
        return this.gameModel.getBandageGirl();
    }

    /**
     * Returns the MeatBoy entity.
     *
     * @return The MeatBoy entity.
     */
    @Override
    public MeatBoy getMeatBoy() {
        return this.gameModel.getMeatBoy();
    }

    /**
     * Returns the game model associated with this controller.
     *
     * @return The game model.
     */
    @Override
    public GameModel getGameModel() {
        return gameModel;
    }

    /**
     * Signals a victory event.
     * This method is called to indicate that the game has been won.
     */
    @Override
    public void victory() {
        this.statistic.updateRecord(centiSeconds);
        this.gameLoop.cancel();
        this.gameTimer.cancel();
        this.gameWindow.displayVictoryMessage();
        this.gameWindow.switchPanel(PanelType.MENU);
    }

    @Override
    public void isDead() {
        this.currentDeaths++;
        this.statistic.addDeaths();
    }

    @Override
    public int getDeaths() {
        return this.statistic.getDeaths();
    }

    @Override
    public int getTimeRecord() {
        return this.statistic.getRecordTime();
    }
    
    /**
     * Returns the starting coordinates of the MeatBoy entity in the game.
     *
     * @return The starting coordinates of the MeatBoy entity.
     */
    @Override
    public Point2D<Double, Double> getMeatBoyStartCoord() {
        return this.gameModel.getMeatBoyStartCoord();
    }

    @Override
    public void esc() {
        this.gameLoop.cancel();
        this.gameTimer.cancel();
        this.gameWindow.switchPanel(PanelType.MENU);
    }

    @Override
    public GameWindow getGameWindow() {
        return gameWindow;
    }

    @Override
    public void stopMovingMeatBoy(final int keyCode) {
        this.getGameModel().getCollisionHandler().stopMovingMeatBoy(keyCode);
    }

    @Override
    public void moveMeatBoy(final int keyCode) {
        this.getGameModel().getCollisionHandler().moveMeatBoy(keyCode);
    }
}
