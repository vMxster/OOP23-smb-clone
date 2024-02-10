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

/**
 * The GameModelImpl class implements the GameModel interface and represents the model
 * component of the game, providing access to game entities and tiles.
 */
public class GameModelImpl implements GameModel {

    private final Level level;
    private final CollisionHandlerImpl collisionHandler;

    /**
     * Constructs a new instance of the GameModel.
     * This constructor initializes the game model with the specified URL to the game map.
     *
     * @param tmx The path to the TMX file representing the game map.
     */
    public GameModelImpl(final String tmx) {
        this.level = new LevelImpl(tmx);
        this.collisionHandler = new CollisionHandlerImpl(this);
    }

    /**
     * Returns the list of stationary tiles in the game.
     *
     * @return The list of stationary tiles.
     */
    @Override
    public List<List<Optional<Tile>>> getStationary() {
        return this.level.getStationary();
    }

    /**
     * Returns the list of circular saws in the game.
     *
     * @return The list of circular saws.
     */
    @Override
    public List<CircularSaw> getSaws() {
        return this.level.getSaws();
    }

    /**
     * Returns the list of platforms in the game.
     *
     * @return The list of platforms.
     */
    @Override
    public List<Platform> getPlatforms() {
        return this.level.getPlatforms();
    }

    /**
     * Returns the BandageGirl entity in the game.
     *
     * @return The BandageGirl entity.
     */
    @Override
    public BandageGirl getBandageGirl() {
        return this.level.getBandageGirl();
    }

    /**
     * Returns the MeatBoy entity in the game.
     *
     * @return The MeatBoy entity.
     */
    @Override
    public MeatBoy getMeatBoy() {
        return this.level.getMeatBoy();
    }

    /**
     * Returns the starting coordinates of the MeatBoy entity in the game.
     *
     * @return The starting coordinates of the MeatBoy entity.
     */
    @Override
    public Point2D<Double, Double> getMeatBoyStartCoord() {
        return this.level.getMeatBoyStartCoord();
    }

    /**
     * Returns the number of rows in the game map.
     *
     * @return The number of rows.
     */
    @Override
    public int getNumRows() {
        return this.level.getNumRows();
    }

    /**
     * Returns the number of columns in the game map.
     *
     * @return The number of columns.
     */
    @Override
    public int getNumCols() {
        return this.level.getNumCols();
    }

    /**
     * Returns the collision handler associated with the game model.
     *
     * @return The collision handler.
     */
    @Override
    public CollisionHandler getCollisionHandler() {
        return this.collisionHandler;
    }

}
