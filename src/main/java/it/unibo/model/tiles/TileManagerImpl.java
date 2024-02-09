package it.unibo.model.tiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.player.MeatBoyImpl;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.entity.target.BandageGirlImpl;

public class TileManagerImpl implements TileManager{

	private final List<List<Optional<Tile>>> stationary;
	private final List<Platform> platforms;
	private final List<CircularSaw> circularSaws;
	private final TileSet tileSet;
	private final List<Tile> tiles;
	private final MeatBoy meatBoy;
	private final BandageGirl bandageGirl;
	private final TileLoader tileLoader;
	private final DocumentExtractor documentExtractor;
	private final int numRows;
	private final int numColumns;

	/**
 	 * Constructs a new TileManager object by parsing a specified tmx file.
 	 *
 	 * @param urlMap The URL of the tmx file to read and create the TileManager from.
 	 */
	public TileManagerImpl(final String tmx) {
		this.platforms = new ArrayList<Platform>();
		this.circularSaws = new ArrayList<CircularSaw>();
		this.stationary = new ArrayList<>();
		this.tileSet = new TileSetImpl(tmx);
		this.tiles = tileSet.getTiles();
		this.meatBoy = new MeatBoyImpl(0, 0);
		this.bandageGirl = new BandageGirlImpl(0, 0);
		this.documentExtractor = new DocumentExtractorImpl(tmx);
		this.tileLoader = new TileLoaderImpl(this, tmx);
		this.numRows = documentExtractor.getNumRows();
		this.numColumns = documentExtractor.getNumColumns();
		init();
		this.tileLoader.load();
	}

	@Override
	public List<Platform> getPlatforms(){
		return this.platforms;
	}

	@Override
	public List<CircularSaw> getSaws(){
		return this.circularSaws;
	}

	@Override
	public int getNumCols(){
		return this.numColumns;
	}

	@Override
	public int getNumRows(){
		return this.numRows;
	}

	@Override
	public MeatBoy getMeatBoy() {
		return this.meatBoy;
	}

	@Override
	public BandageGirl getBandageGirl() {
		return this.bandageGirl;
	}

	@Override
	public List<List<Optional<Tile>>> getStationary() {
		return this.stationary;
	}

	@Override
	public List<Tile> getTiles() {
		return this.tiles;
	}

	/**
 	 * Initializes the stationary list.
 	 * This method is called during the construction of the TileManager object.
 	 */
	private void init() {
		for (int i = 0 ; i<this.numRows ; i++) {
			stationary.add(new ArrayList<>(Collections.nCopies(this.numColumns, Optional.empty())));
		}
	}

}
