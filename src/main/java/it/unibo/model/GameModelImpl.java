package it.unibo.model;

import java.util.List;
import java.util.Optional;

import it.unibo.commons.Point2D;
import it.unibo.model.collision.CollisionHandler;
import it.unibo.model.collision.CollisionHandlerImpl;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.level.Level;
import it.unibo.model.level.LevelImpl;
import it.unibo.model.tiles.Tile;

public class GameModelImpl implements GameModel {

    private final Level level;
    private final CollisionHandlerImpl collisionHandler;

    /**
     * Constructs a new instance of the GameModel.
     * This constructor initializes the game model with the specified URL to the game map.
     *
     * @param urlMap The URL to the game map that serves as the basis for the game model.
     */
    public GameModelImpl(final String tmx) {
        this.level = new LevelImpl(tmx);
        this.collisionHandler = new CollisionHandlerImpl(this);
    }

    @Override
    public List<List<Optional<Tile>>> getStationary() {
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
	public Point2D<Double,Double> getMeatBoyStartCoord() {
		return this.level.getMeatBoyStartCoord();
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
    public CollisionHandler getCollisionHandler() {
        return this.collisionHandler;
    }
    
}
