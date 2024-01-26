package it.unibo.controller;

import java.net.URL;
import java.util.List;

import it.unibo.model.tiles.Tile;
import it.unibo.model.tiles.TileManager;
import it.unibo.model.tiles.TileManagerImpl;

public class ControllerImpl implements Controller {

    private final TileManager tileManager;
    private final URL urlMap;

    public ControllerImpl(final URL urlMap) {
        this.tileManager = new TileManagerImpl(urlMap);
        this.urlMap = urlMap;
    }

    @Override
    public List<List<Tile>> getBackground() {
        return tileManager.getBackground();
    }

    @Override
    public List<List<Tile>> getForeground() {
        return tileManager.getForeground();
    }

    @Override
    public List<List<Tile>> getStationary() {
        return tileManager.getStationary();
    }

    @Override
    public String getTmxURL() {
        return this.urlMap.getPath();
    }

    @Override
    public int getNumRow() {
        return this.tileManager.getNumRows();
    }

    @Override
    public int getNumCols() {
        return this.tileManager.getNumCols();
    }

}
