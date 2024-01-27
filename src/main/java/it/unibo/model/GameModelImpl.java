package it.unibo.model;

import java.net.URL;
import java.util.List;

import it.unibo.model.level.Level;
import it.unibo.model.level.LevelImpl;
import it.unibo.model.tiles.Tile;
import it.unibo.model.tiles.TileManager;

public class GameModelImpl implements GameModel {

    private final Level level;
    private final TileManager tileManager;

    /**
     * Constructs a new instance of the GameModel.
     * This constructor initializes the game model with the specified URL to the game map.
     *
     * @param urlMap The URL to the game map that serves as the basis for the game model.
     */
    public GameModelImpl(final URL urlMap) {
        this.level = new LevelImpl(this, urlMap);
        this.tileManager = level.getTileManager();
    }

    @Override
    public List<List<Tile>> getBackground() {
        return tileManager.getBackground();
    }

    @Override
    public List<List<Tile>> getStationary() {
        return tileManager.getStationary();
    }

    @Override
    public int getNumRows() {
        return tileManager.getNumRows();
    }

    @Override
    public int getNumCols() {
        return tileManager.getNumCols();
    }

    @Override
    public List<List<Tile>> getForeground() {
        return tileManager.getForeground();
    }
    
}
