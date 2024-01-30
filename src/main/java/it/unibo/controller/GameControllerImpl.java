package it.unibo.controller;

import java.net.URL;
import java.util.List;

import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.tiles.Tile;
import it.unibo.model.tiles.TileManager;
import it.unibo.model.tiles.TileManagerImpl;

public class GameControllerImpl implements GameController {

    private final TileManager tileManager;
    private final URL urlMap;

    public GameControllerImpl(final URL urlMap) {
        this.tileManager = new TileManagerImpl(urlMap);
        this.urlMap = urlMap;
    }

    @Override
    public List<List<Tile>> getStationary() {
        return tileManager.getStationary();
    }

    @Override
    public List<CircularSaw> getSaws() {
        return tileManager.getSaws();
    }

    @Override
    public List<Platform> getPlatforms() {
        return tileManager.getPlatforms();
    }

    @Override
    public String getTmxURL() {
        return this.urlMap.getPath();
    }

    @Override
    public int getNumRows() {
        return this.tileManager.getNumRows();
    }

    @Override
    public int getNumCols() {
        return this.tileManager.getNumCols();
    }

}
