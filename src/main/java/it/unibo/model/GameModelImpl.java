package it.unibo.model;

import java.util.List;

import it.unibo.model.collision.CollisionChecker;
import it.unibo.model.collision.CollisionCheckerImpl;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.level.Level;
import it.unibo.model.level.LevelImpl;
import it.unibo.model.tiles.Tile;

public class GameModelImpl implements GameModel {

    private final Level level;
    private final CollisionChecker collisionChecker;

    /**
     * Constructs a new instance of the GameModel.
     * This constructor initializes the game model with the specified URL to the game map.
     *
     * @param urlMap The URL to the game map that serves as the basis for the game model.
     */
    public GameModelImpl(final String tmx) {
        this.level = new LevelImpl(tmx);
        this.collisionChecker = new CollisionCheckerImpl(this);
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
    public BandageGirl getBandageGirl() {
        return this.level.getBandageGirl();
    }

    @Override
    public MeatBoy getMeatBoy() {
        return this.level.getMeatBoy();
    }

    @Override
    public int getNumRows() {
        return this.level.getNumRows();
    }

    @Override
    public int getNumCols() {
        return this.level.getNumCols();
    }

    @Override
    public CollisionChecker getCollisionChecker() {
        return this.collisionChecker;
    }


    
}
