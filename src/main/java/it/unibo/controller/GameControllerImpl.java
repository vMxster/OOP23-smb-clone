package it.unibo.controller;

import java.net.URL;
import java.util.List;

import it.unibo.model.GameModel;
import it.unibo.model.GameModelImpl;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.tiles.Tile;

public class GameControllerImpl implements GameController {

    private final GameModel gameModel;

    //private final GameView gameView;
    private final URL urlMap;

    public GameControllerImpl(final URL urlMap) {
        this.gameModel = new GameModelImpl(urlMap);
        //this.gameView = new GameView(this);
        this.urlMap = urlMap;
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
    public String getTmxURL() {
        return this.urlMap.getPath();
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
