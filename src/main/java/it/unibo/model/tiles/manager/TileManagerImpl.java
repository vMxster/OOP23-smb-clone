package it.unibo.model.tiles.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import it.unibo.model.documentextractor.DocumentExtractor;
import it.unibo.model.documentextractor.DocumentExtractorImpl;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.player.MeatBoyImpl;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.entity.target.BandageGirlImpl;
import it.unibo.model.tiles.Tile;
import it.unibo.model.tiles.TileSetImpl;
import it.unibo.model.tiles.loader.TileLoaderImpl;

/**
 * The TileManagerImpl class implements the TileManager interface and provides
 * functionality to manage tiles, platforms, circular saws, and player entities.
 */
public class TileManagerImpl implements TileManager {

    private final List<List<Optional<Tile>>> stationary;
    private final List<Platform> platforms;
    private final List<CircularSaw> circularSaws;
    private final List<Tile> tiles;
    private final MeatBoy meatBoy;
    private final BandageGirl bandageGirl;
    private final int numRows;
    private final int numColumns;

    /**
     * Constructs a new TileManager object by parsing a specified TMX file.
     *
     * @param tmx The path to the TMX file.
     */
    public TileManagerImpl(final String tmx) {
        this.platforms = new ArrayList<>();
        this.circularSaws = new ArrayList<>();
        this.stationary = new ArrayList<>();
        this.tiles = new TileSetImpl(tmx).getTiles();
        this.meatBoy = new MeatBoyImpl(0, 0);
        this.bandageGirl = new BandageGirlImpl(0, 0);
        final DocumentExtractor documentExtractor = new DocumentExtractorImpl(tmx);
        this.numRows = documentExtractor.getNumRows();
        this.numColumns = documentExtractor.getNumColumns();
        init();
        new TileLoaderImpl(this, tmx).load();
    }

    /**
     * Returns the list of platforms.
     *
     * @return The list of platforms.
     */
    @Override
    public List<Platform> getPlatforms() {
        return this.platforms;
    }

    /**
     * Returns the list of circular saws.
     *
     * @return The list of circular saws.
     */
    @Override
    public List<CircularSaw> getSaws() {
        return this.circularSaws;
    }

    /**
     * Returns the number of columns in the tile map.
     *
     * @return The number of columns.
     */
    @Override
    public int getNumCols() {
        return this.numColumns;
    }

    /**
     * Returns the number of rows in the tile map.
     *
     * @return The number of rows.
     */
    @Override
    public int getNumRows() {
        return this.numRows;
    }

    /**
     * Returns the MeatBoy entity.
     *
     * @return The MeatBoy entity.
     */
    @Override
    public MeatBoy getMeatBoy() {
        return this.meatBoy;
    }

    /**
     * Returns the BandageGirl entity.
     *
     * @return The BandageGirl entity.
     */
    @Override
    public BandageGirl getBandageGirl() {
        return this.bandageGirl;
    }

    /**
     * Returns the list of stationary tiles.
     *
     * @return The list of stationary tiles.
     */
    @Override
    public List<List<Optional<Tile>>> getStationary() {
        return this.stationary;
    }

    /**
     * Returns the list of all tiles.
     *
     * @return The list of all tiles.
     */
    @Override
    public List<Tile> getTiles() {
        return this.tiles;
    }

    /**
     * Initializes the stationary list.
     * This method is called during the construction of the TileManager object.
     */
    private void init() {
        for (int i = 0; i < this.numRows; i++) {
            stationary.add(new ArrayList<>(Collections.nCopies(this.numColumns, Optional.empty())));
        }
    }

}
