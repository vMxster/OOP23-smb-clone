package it.unibo.smb.model.level;

import java.util.List;
import java.util.Optional;

import it.unibo.smb.commons.Point2D;
import it.unibo.smb.model.entity.obstacles.CircularSaw;
import it.unibo.smb.model.entity.obstacles.LaserBarrier;
import it.unibo.smb.model.entity.obstacles.LavaPool;
import it.unibo.smb.model.entity.obstacles.Platform;
import it.unibo.smb.model.entity.player.MeatBoy;
import it.unibo.smb.model.entity.target.BandageGirl;
import it.unibo.smb.model.tiles.Tile;

/**
 * Interface that reads a tmx file and creates a level from it.
 */
public interface Level {

    /**
     * Retrieves a two-dimensional list representing stationary tiles in the game.
     *
     * @return A two-dimensional list of stationary tiles.
     */
    List<List<Optional<Tile>>> getStationary();

    /**
     * Retrieves a list of platforms available.
     *
     * @return A List of Platform objects representing the available platforms.
     */
    List<Platform> getPlatforms();

    /**
     * Retrieves a list of saws.
     *
     * @return A List of Saws.
     */
    List<CircularSaw> getSaws();

    /**
     * Retrieves a list of LaserBarriers.
     *
     * @return A List of LaserBarriers.
     */
    List<LaserBarrier> getLaserBarriers();

    /**
     * Retrieves the bandage girl.
     *
     * @return The bandage girl.
     */
    BandageGirl getBandageGirl();

    /**
     * Gets the width level of the platform.
     *
     * @return An integer representing the width level of the platform.
     */
    int getNumCols();

    /**
     * Gets the height level of the platform.
     *
     * @return An integer representing the height level of the platform.
     */
    int getNumRows();

    /**
     * Retrieves the meat boy.
     *
     * @return The meat boy.
     */
    MeatBoy getMeatBoy();

    /**
     * Retrieves the Starting Coordinates of MeatBoy.
     *
     * @return The Starting Coordinates of MeatBoy.
     */
    Point2D<Double, Double> getMeatBoyStartCoord();

    /**
     * Retrieves a list of LavaPools.
     *
     * @return A List of LavaPools.
     */
    List<LavaPool> getLavaPools();
}
