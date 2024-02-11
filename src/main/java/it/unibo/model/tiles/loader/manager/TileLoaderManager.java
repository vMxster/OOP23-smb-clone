package it.unibo.model.tiles.loader.manager;

import java.util.List;
import java.util.Optional;

import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.tiles.Tile;

/**
 * The TileLoaderManager interface is responsible for managing the loading 
 * of StationaryTiles and GameObjects from a TMX file.
 */
public interface TileLoaderManager {

    /**
     * Loads stationary tiles, platforms and circular saws from an XML document.
     * This method delegates to specific loading methods based on the type of tiles to be loaded.
     */
    void load();

    /**
     * Trims any extraneous space after a period in the given string.
     *
     * @param s The String to trim
     * @return The trimmed String
     */
    String trim(String s);

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
     * Retrieves a two-dimensional list representing stationary tiles in the game.
     * Each inner list corresponds to a row of stationary tiles in the game level.
     *
     * @return A two-dimensional list of stationary tiles.
     */
    List<List<Optional<Tile>>> getStationary();

    /**
     * Retrieves a list of all tiles in the game.
     *
     * @return A list containing all tiles in the game.
     */
    List<Tile> getTiles();

}
