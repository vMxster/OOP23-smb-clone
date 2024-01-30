package it.unibo.model.tiles;

import java.util.List;
import org.w3c.dom.Document;

import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;

/**
 * The TileManager interface represents a manager for handling tiles in a game.
 * It provides methods to load and manage a tile map from a specified TMX file.
 */
public interface TileManager {

    /**
     * Parses the TMX file and populates the tile map with stationary objects,
     * and additional game elements such as platforms, circular saws, and player starting coordinates.
     * This method is responsible for initializing the internal state of the loading map based on the
     * contents of the TMX file delegated to the TileLoader.
     */
    void loadMap();

    /**
     * Returns the List of Platforms parsed from the TMX file.
     *
     * @return The List of Platforms parsed from the TMX file.
     */
    List<Platform> getPlatforms();

    /**
     * Returns the List of CircularSaws parsed from the TMX file.
     *
     * @return The List of CircularSaws parsed from the TMX file.
     */
    List<CircularSaw> getSaws();

    /**
     * Returns the number of columns in the TileMap.
     *
     * @return The number of columns in the TileMap.
     */
    int getNumCols();

    /**
     * Returns the number of rows in the TileMap.
     *
     * @return The number of rows in the TileMap.
     */
    int getNumRows();

    /**
     * Returns the MeatBoy object parsed from the TMX file.
     *
     * @return The MeatBoy object parsed from the TMX file.
     */
    MeatBoy getMeatBoy();

    /**
     * Returns the BandageGirl object parsed from the TMX file.
     *
     * @return The BandageGirl object parsed from the TMX file.
     */
    BandageGirl getBandageGirl();

    /**
     * Returns the Document object linked to the TMX file.
     *
     * @return The Document object linked to the TMX file.
     */
    Document getDocument();

    /**
     * Retrieves a two-dimensional list representing stationary tiles in the game.
     * Each inner list corresponds to a row of stationary tiles in the game level.
     *
     * @return A two-dimensional list of stationary tiles.
     */
    List<List<Tile>> getStationary();

    /**
     * Retrieves a list of all tiles in the game.
     *
     * @return A list containing all tiles in the game.
     */
    List<Tile> getTiles();

}
