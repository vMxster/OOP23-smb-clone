package it.unibo.controller;

import java.util.List;

import it.unibo.model.tiles.Tile;

/**
 * Interface representing a Controller for Managing the SuperMeatBoy Game.
 */
public interface GameController {

    /**
     * Retrieves the grid of tiles representing the stationary object.
     *
     * @return A list of lists of tiles, where each list represents a row of tiles.
     */
    List<List<Tile>> getStationary();

    /**
     * Retrieves the URL of the TMX file associated with the Game Map.
     *
     * @return The URL of the TMX file.
     */
    String getTmxURL();

    /**
     * Retrieves the number of Map rows.
     *
     * @return The number of rows.
     */
    int getNumRows();

    /**
     * Retrieves the number of Map columns.
     *
     * @return The number of columns.
     */
    int getNumCols();
}

