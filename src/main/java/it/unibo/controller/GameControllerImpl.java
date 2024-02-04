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

public class GameControllerImpl implements GameController {

    private final GameModel gameModel;
    private final GameWindow gameWindow;
    private final Timer gameTimer;

    public GameControllerImpl() {
        this.gameModel = new GameModelImpl(Constants.SOURCE_MAP);
        this.gameWindow = new GameWindow(this);
        this.gameTimer = new Timer();
        this.start();
    }

    private void start() {
        this.gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                gameModel.getCollisionChecker().updateMeatBoy();
                gameWindow.repaint();
                if (gameModel.getCollisionChecker().isInWindow() == CollisionChecker.CollisionState.FALL) {
                    try {
                        Thread.sleep(500);
                        System.exit(0);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    if (gameModel.getCollisionChecker().getState() == (CollisionChecker.CollisionState.SAW)) {
                        System.out.println("HAI PERSO");
                    } else if (gameModel.getCollisionChecker().getState() == (CollisionChecker.CollisionState.BANDAGE_GIRL)) {
                        System.out.println("HAI VINTO");
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
