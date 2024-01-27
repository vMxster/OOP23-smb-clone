package it.unibo.model.level;

import java.util.List;

import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.tiles.TileManager;

/**
 *  Interface that reads a tmx file and creates a level from it
 */
public interface Level {

    /**
     *  Updates the status of all current entities and obstacles in the level.
     */
    void update();

    /**
     * Retrieves a list of platforms available.
     *
     * @return A List of Platform objects representing the available platforms.
     */
    List<Platform> getPlatforms();

    /**
     * Retrieves a list of circular saws available.
     *
     * @return A List of CircularSaw objects representing the available circular saws.
     */
    List<CircularSaw> getCircularSaws();

    /**
     * Gets the width level of the platform.
     *
     * @return An integer representing the width level of the platform.
     */
    int getWidthLevel();

    /**
     * Gets the height level of the platform.
     *
     * @return An integer representing the height level of the platform.
     */
    int getHeightLevel();

    /**
     * Retrieves the TileManager of this Level.
     *
     * @return The TileManager instance of this Level.
     */
    TileManager getTileManager();


}
