package it.unibo.model.level;

import java.util.List;
import java.util.Optional;

import it.unibo.model.tiles.Tile;
import it.unibo.model.tiles.manager.TileManager;
import it.unibo.model.tiles.manager.TileManagerImpl;
import it.unibo.commons.Point2D;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;

/**
 * Implementation of the Level interface that reads a tmx file and creates a level from it.
 */
public class LevelImpl implements Level {

    private final TileManager tileManager;
    private final MeatBoy meatBoy;
    private final BandageGirl bandageGirl;
    private final Point2D<Double, Double> meatBoyStartCoord;

    /**
     * Constructs a new instance of LevelImpl with the specified tmx file.
     *
     * @param tmx The URL to the tmx file representing the level.
     */
    public LevelImpl(final String tmx) {
        this.tileManager = new TileManagerImpl(tmx);
        this.meatBoy = tileManager.getMeatBoy();
        this.bandageGirl = tileManager.getBandageGirl();
        this.meatBoyStartCoord = new Point2D<>(meatBoy.getX(), meatBoy.getY());
    }

    /**
     * Retrieves the meat boy.
     *
     * @return The meat boy.
     */
    @Override
    public MeatBoy getMeatBoy() {
        return this.meatBoy;
    }

    /**
     * Retrieves the Starting Coordinates of MeatBoy.
     *
     * @return The Starting Coordinates of MeatBoy.
     */
    @Override
    public Point2D<Double, Double> getMeatBoyStartCoord() {
        return this.meatBoyStartCoord;
    }

    /**
     * Retrieves the bandage girl.
     *
     * @return The bandage girl.
     */
    @Override
    public BandageGirl getBandageGirl() {
        return this.bandageGirl;
    }

    /**
     * Retrieves a two-dimensional list representing stationary tiles in the game.
     *
     * @return A two-dimensional list of stationary tiles.
     */
    @Override
    public List<List<Optional<Tile>>> getStationary() {
        return this.tileManager.getStationary();
    }

    /**
     * Retrieves a list of platforms available.
     *
     * @return A List of Platform objects representing the available platforms.
     */
    @Override
    public List<Platform> getPlatforms() {
        return this.tileManager.getPlatforms();
    }

    /**
     * Retrieves a list of saws.
     *
     * @return A List of Saws.
     */
    @Override
    public List<CircularSaw> getSaws() {
        return this.tileManager.getSaws();
    }

    /**
     * Gets the width level of the platform.
     *
     * @return An integer representing the width level of the platform.
     */
    @Override
    public int getNumCols() {
        return this.tileManager.getNumCols();
    }

    /**
     * Gets the height level of the platform.
     *
     * @return An integer representing the height level of the platform.
     */
    @Override
    public int getNumRows() {
        return this.tileManager.getNumRows();
    }

}
