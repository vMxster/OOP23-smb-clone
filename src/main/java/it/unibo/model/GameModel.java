package it.unibo.model;

import java.util.List;

import it.unibo.model.tiles.Tile;

/**
 * The GameModel interface represents the ModelManager of the Game SuperMeatBoy, providing methods to retrieve
 * information about the tiles in the game grid.
 * The game grid consists of foreground, background, and stationary tiles, organized in a
 * two-dimensional structure where each inner list corresponds to a row, and the elements
 * within the inner lists represent tiles in that specific row.
 */
public interface GameModel {

     /**
     * Retrieves the stationary tiles represented as a two-dimensional list.
     *
     * The stationary tiles are organized in a grid structure, where each inner list
     * corresponds to a row, and the elements within the inner lists represent tiles
     * in that specific row.
     *
     * @return A two-dimensional list containing stationary tiles.
     */
    List<List<Tile>> getStationary();

     /**
     * Retrieves the total number of rows in the grid of tiles.
     *
     * @return The number of rows in the grid.
     */
    int getNumRows();

     /**
     * Retrieves the total number of columns in the grid of tiles.
     *
     * @return The number of columns in the grid.
     */
    int getNumCols();
    
}
