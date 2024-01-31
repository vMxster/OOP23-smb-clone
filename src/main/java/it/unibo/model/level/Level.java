package it.unibo.model.level;

import java.util.List;

import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.tiles.Tile;

/**
 *  Interface that reads a tmx file and creates a level from it
 */
public interface Level {

    /**
     *  Updates the status of all current entities and obstacles in the level.
     */
    void update();

    /**
     * Retrieves a two-dimensional list representing stationary tiles in the game.
     *
     * @return A two-dimensional list of stationary tiles.
     */
    List<List<Tile>> getStationary();

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

}
