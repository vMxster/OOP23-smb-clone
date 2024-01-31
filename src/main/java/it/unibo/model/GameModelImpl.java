package it.unibo.model;

import java.net.URL;
import java.util.List;

import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.level.Level;
import it.unibo.model.level.LevelImpl;
import it.unibo.model.tiles.Tile;

public class GameModelImpl implements GameModel {

    private final Level level;

    /**
     * Constructs a new instance of the GameModel.
     * This constructor initializes the game model with the specified URL to the game map.
     *
     * @param urlMap The URL to the game map that serves as the basis for the game model.
     */
    public GameModelImpl(final URL urlMap) {
        this.level = new LevelImpl(urlMap);
    }

    @Override
    public List<List<Tile>> getStationary() {
        return this.level.getStationary();
    }

    @Override
    public List<CircularSaw> getSaws() {
        return this.level.getSaws();
    }

    @Override
    public List<Platform> getPlatforms() {
        return this.level.getPlatforms();
    }

    @Override
    public int getNumRows() {
        return this.level.getNumRows();
    }

    @Override
    public int getNumCols() {
        return this.level.getNumCols();
    }
    
}
