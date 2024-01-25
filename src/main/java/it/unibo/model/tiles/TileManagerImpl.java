package it.unibo.model.tiles;

import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;

import it.unibo.commons.Point2D;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.target.BandageGirl;

public class TileManagerImpl implements TileManager{
    
	private final List<List<Tile>> background;
	private final List<List<Tile>> foreground;
	private final List<List<Tile>> stationary;
	private final List<Platform> platforms;
	private final List<CircularSaw> circularSaws;
	private final URL tmxfile;
	private final TileLoader tileLoader;
	private TileSet tileSet;
	private List<Tile> tiles;
	private DocumentBuilder builder;
	private Document document;
	private int numRows;
	private int numColumns;
    private BandageGirl bandageGirl;
	private Point2D<Integer,Integer> playerCoordStart;

	/**
 	 * Constructs a new TileManager object by parsing a specified tmx file.
 	 *
 	 * @param urlMap The URL of the tmx file to read and create the TileManager from.
 	 */
	public TileManagerImpl(final URL urlMap) {
		this.platforms = new ArrayList<Platform>();
		this.circularSaws = new ArrayList<CircularSaw>();
		this.background = new ArrayList<>();
		this.stationary = new ArrayList<>();
		this.foreground = new ArrayList<>();
		this.tileLoader = new TileLoaderImpl(this);
		this.tmxfile = urlMap;
		init();
	
		try {
			this.builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			this.document = builder.parse(this.tmxfile.getPath());
	
			NodeList mapAttributes = document.getElementsByTagName("map");
			if (mapAttributes.getLength() > 0) {
				Element mapElement = (Element) mapAttributes.item(0);
				this.numRows = Integer.parseInt(mapElement.getAttribute("height"));
				this.numColumns = Integer.parseInt(mapElement.getAttribute("width"));
			}
	
			this.tileSet = new TileSetImpl(this.tmxfile);
			this.tiles = tileSet.getTiles();
			loadMap();
		} catch (SAXException | ParserConfigurationException | IOException exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void loadMap() throws SAXException, ParserConfigurationException, IOException {
		NodeList layers = document.getElementsByTagName("layer");
		int numLayers = layers.getLength();
	
		for (int i = 0; i < numLayers; i++) {
			Element layerElement = (Element) layers.item(i);
			String layerName = layerElement.getAttribute("name");
	
			switch (layerName) {
				case "background" -> tileLoader.loadTiles(this.background);
				case "foreground" -> tileLoader.loadTiles(this.foreground);
				case "stationary" -> tileLoader.loadStationaryTiles();
				default -> throw new IllegalArgumentException("You entered an unrecognizable layer. Known layers: \nStationary\nForeground\nBackground");
			}
		}
	
		tileLoader.loadPlatforms();
		tileLoader.loadCircularSaws();
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
	public Point2D<Integer,Integer> getPlayerCoordStart() {
		return this.playerCoordStart;
	}

	@Override
	public BandageGirl getBandageGirl() {
		return this.bandageGirl;
	}

	@Override
	public Document getDocument() {
		return this.document;
	}

	@Override
	public List<List<Tile>> getStationary() {
		return this.stationary;
	}

	@Override
	public List<Tile> getTiles() {
		return this.tiles;
	}

	@Override
	public void setBandageGirl(BandageGirl bandageGirl) {
		this.bandageGirl = bandageGirl;
	}

	/**
 	 * Initializes the background, stationary, and foreground lists.
 	 * This method is called during the construction of the TileManagerImpl object.
 	 * Each list corresponds to a layer in the Tiled Map (background, stationary, and foreground).
 	 */
	  private void init() {
		for (int i = 0 ; i<this.numRows ; i++) {
			background.add(new ArrayList<>());
			stationary.add(new ArrayList<>());
			foreground.add(new ArrayList<>());
		}
	}

}
