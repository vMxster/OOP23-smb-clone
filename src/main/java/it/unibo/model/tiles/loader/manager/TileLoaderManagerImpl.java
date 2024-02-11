package it.unibo.model.tiles.loader.manager;

import java.util.List;
import java.util.Optional;

import it.unibo.model.documentextractor.DocumentExtractor;
import it.unibo.model.documentextractor.DocumentExtractorImpl;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.tiles.Tile;
import it.unibo.model.tiles.loader.gameobjects.TileLoaderGameObjects;
import it.unibo.model.tiles.loader.gameobjects.TileLoaderGameObjectsImpl;
import it.unibo.model.tiles.loader.stationary.TileLoaderStationary;
import it.unibo.model.tiles.loader.stationary.TileLoaderStationaryImpl;
import it.unibo.model.tiles.manager.TileManager;


/**
 * The implementation of the TileLoaderManager interface is responsible for managing the loading 
 * of StationaryTiles and GameObjects from a TMX file.
*/
public class TileLoaderManagerImpl implements TileLoaderManager {

    private final TileManager tileManager;
    private final TileLoaderGameObjects tileLoaderGameObjects;
    private final TileLoaderStationary tileLoaderStationary;

    /**
     * Constructs a TileLoaderManagerImpl with the specified TileManager and TMX file.
     *
     * @param tileManager The tile manager responsible for managing tiles in the game.
     * @param tmx         The path to the TMX file containing tile information.
     */
    public TileLoaderManagerImpl(final TileManager tileManager, final String tmx) {
        this.tileManager = tileManager;
        final DocumentExtractor documentExtractor = new DocumentExtractorImpl(tmx);
        this.tileLoaderGameObjects = new TileLoaderGameObjectsImpl(this, documentExtractor);
        this.tileLoaderStationary = new TileLoaderStationaryImpl(this, documentExtractor);
    }

    /**
     * Loads stationary tiles and objects from the TMX file.
     */
    @Override
    public void load() {
        this.tileLoaderStationary.load();
        this.tileLoaderGameObjects.load();
    }

    /**
     * Trims any extraneous space after a period in the given string.
     *
     * @param s The String to trim
     * @return The trimmed String
     */
    @Override
    public String trim(final String s) {
        return s.contains(".") ? s.replaceAll("\\s+", "") : s;
    }

    /**
     * Returns the List of Platforms parsed from the TMX file.
     *
     * @return The List of Platforms parsed from the TMX file.
     */
    @Override
    public List<Platform> getPlatforms() {
        return this.tileManager.getPlatforms();
    }

    /**
     * Returns the List of CircularSaws parsed from the TMX file.
     *
     * @return The List of CircularSaws parsed from the TMX file.
     */
    @Override
    public List<CircularSaw> getSaws() {
        return this.tileManager.getSaws();
    }

    /**
     * Returns the MeatBoy object parsed from the TMX file.
     *
     * @return The MeatBoy object parsed from the TMX file.
     */
    @Override
    public MeatBoy getMeatBoy() {
        return this.tileManager.getMeatBoy();
    }

    /**
     * Returns the BandageGirl object parsed from the TMX file.
     *
     * @return The BandageGirl object parsed from the TMX file.
     */
    @Override
    public BandageGirl getBandageGirl() {
        return this.tileManager.getBandageGirl();
    }

    /**
     * Retrieves a two-dimensional list representing stationary tiles in the game.
     * Each inner list corresponds to a row of stationary tiles in the game level.
     *
     * @return A two-dimensional list of stationary tiles.
     */
    @Override
    public List<List<Optional<Tile>>> getStationary() {
        return this.tileManager.getStationary();
    }

    /**
     * Retrieves a list of all tiles in the game.
     *
     * @return A list containing all tiles in the game.
     */
    @Override
    public List<Tile> getTiles() {
        return this.tileManager.getTiles();
    }

}
