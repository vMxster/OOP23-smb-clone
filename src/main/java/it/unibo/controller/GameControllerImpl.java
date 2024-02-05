package it.unibo.controller;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import it.unibo.commons.Constants;
import it.unibo.model.GameModel;
import it.unibo.model.GameModelImpl;
import it.unibo.model.collision.CollisionChecker;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.tiles.Tile;
import it.unibo.view.window.GameWindow;
import it.unibo.view.window.factory.GameWindowFactoryImpl;

public class GameControllerImpl implements GameController {

    private final GameWindow gameWindow;
    private final GameModel gameModel;
    

    public GameControllerImpl() {
        this.gameModel = new GameModelImpl(Constants.SOURCE_MAP);
        this.gameWindow = new GameWindowFactoryImpl().createSwingGameWindow(this);
        this.start();
    }

    private void start() {
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                gameModel.getCollisionChecker().updateMeatBoy();
                gameWindow.paint();
                if (gameModel.getCollisionChecker().isInWindow() == CollisionChecker.CollisionState.FALL) {
                    gameModel.getMeatBoy().setX(gameModel.getMeatBoyStartCoord().getX());
                    gameModel.getMeatBoy().setY(gameModel.getMeatBoyStartCoord().getY());
                } else {
                    if (gameModel.getCollisionChecker().getState() == (CollisionChecker.CollisionState.SAW)) {
                        gameModel.getMeatBoy().setX(gameModel.getMeatBoyStartCoord().getX());
                        gameModel.getMeatBoy().setY(gameModel.getMeatBoyStartCoord().getY());
                    } else if (gameModel.getCollisionChecker().getState() == (CollisionChecker.CollisionState.BANDAGE_GIRL)) {
                        gameWindow.displayVictoryMessage();
                    }
                }
            }
            
        }, 0, 17);
    }

    @Override
    public List<List<Tile>> getStationary() {
        return this.gameModel.getStationary();
    }

    @Override
    public List<CircularSaw> getSaws() {
        return this.gameModel.getSaws();
    }

    @Override
    public List<Platform> getPlatforms() {
        return this.gameModel.getPlatforms();
    }

    @Override
    public int getNumRows() {
        return this.gameModel.getNumRows();
    }

    @Override
    public int getNumCols() {
        return this.gameModel.getNumCols();
    }

    @Override
    public BandageGirl getBandageGirl() {
        return this.gameModel.getBandageGirl();
    }

    @Override
    public MeatBoy getMeatBoy() {
        return this.gameModel.getMeatBoy();
    }
    
    @Override
    public GameModel getGameModel() {
        return gameModel;
    }
}
