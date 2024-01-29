package it.unibo.model.tiles;

import java.util.Objects;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.unibo.commons.Constants;
import it.unibo.model.entity.obstacles.CircularSawImpl;
import it.unibo.model.entity.obstacles.PlatformImpl;
import it.unibo.model.entity.target.BandageGirlImpl;

public class TileLoaderImpl implements TileLoader {

	private final TileManager tileManager;
    private final int numRows;
    private final int numColumns;
	private final Document document;

	/**
 	 * Constructs a TileLoaderImpl instance with the specified TileManager.
 	 * Initializes the TileLoaderImpl with the necessary information from the provided TileManager,
 	 * including the number of rows, number of columns, and the XML document containing tile data.
 	 *
 	 * @param tileManager The TileManager providing information about the game level's tiles.
 	 */
    public TileLoaderImpl(final TileManager tileManager) {
		this.tileManager = tileManager;
        this.numRows = tileManager.getNumRows();
        this.numColumns = tileManager.getNumCols();
		this.document = tileManager.getDocument();
    }

	public void loadStationaryTiles() {
		NodeList tileNodeList = document.getElementsByTagName("tile");
		int gidNumber = 0;
		for (int row = 0; row < this.numRows; row++) {
			for (int column = 0; column < this.numColumns; column++) {
				Element tilesetElement = (Element) Objects.requireNonNull(tileNodeList.item(gidNumber));
				int whichTile = Integer.parseInt(tilesetElement.getAttributes().getNamedItem("gid").getTextContent());
				if (whichTile > 0) {
					if (whichTile == 2) {
						this.tileManager.setBandageGirl(
							new BandageGirlImpl(
								Double.valueOf(column * Constants.TILE_SIZE),
								Double.valueOf(row * Constants.TILE_SIZE),
								Double.valueOf(Constants.TILE_SIZE),
								Double.valueOf(Constants.TILE_SIZE)));
						this.tileManager.getStationary().get(row).add(column, this.tileManager.getTiles().get(whichTile - 1));
					} else if (whichTile == 1) {
						this.tileManager.getPlayerCoordStart().set(column * Constants.TILE_SIZE, row * Constants.TILE_SIZE);
					} else {
						this.tileManager.getStationary().get(row).add(column, this.tileManager.getTiles().get(whichTile - 1));
					}
				}
				gidNumber++;
			}
		}
	}
	
	public void loadPlatforms() {
		NodeList rectangleObjects = this.document.getElementsByTagName("objectgroup");
		int numPlatforms = 0;

		for (int i = 0; i < rectangleObjects.getLength(); i++) {
    		Element objectGroupElement = (Element) Objects.requireNonNull(rectangleObjects.item(i));

    		if ("rectangle".equals(objectGroupElement.getAttribute("name"))) {
        		NodeList objectsInGroup = objectGroupElement.getElementsByTagName("object");
        		numPlatforms = objectsInGroup.getLength();

        		for (int j = 0; j < numPlatforms; j++) {
            		Element platformElement = (Element) Objects.requireNonNull(objectsInGroup.item(j));

            		this.tileManager.getPlatforms().add(
						new PlatformImpl(
							Integer.parseInt(trim(platformElement.getAttribute("x"))),
							Integer.parseInt(trim(platformElement.getAttribute("y"))),
							Integer.parseInt(trim(platformElement.getAttribute("width"))),
							Integer.parseInt(trim(platformElement.getAttribute("height")))));
        		}
				return;
    		}
		}
	}

	public void loadCircularSaws() {
		NodeList sawObjects = this.document.getElementsByTagName("objectgroup");
		int numsaws = 0;

		for (int i = 0; i < sawObjects.getLength(); i++) {
    		Element objectGroupElement = (Element) Objects.requireNonNull(sawObjects.item(i));

    		if ("saws".equals(objectGroupElement.getAttribute("name"))) {
        		NodeList objectsInGroup = objectGroupElement.getElementsByTagName("object");
        		numsaws = objectsInGroup.getLength();

        		for (int j = 0; j < numsaws; j++) {
            		Element sawElement = (Element) Objects.requireNonNull(objectsInGroup.item(j));

            		int width = Integer.parseInt(trim(sawElement.getAttribute("width")));
            		int height = Integer.parseInt(trim(sawElement.getAttribute("height")));
					int radius = width/2;

            		if (width != height) {
                		System.out.println("You entered a lopsided saw. Failure.");
            		} else {
                		this.tileManager.getSaws().add(
							new CircularSawImpl(
								Integer.parseInt(trim(sawElement.getAttribute("x"))),
								Integer.parseInt(trim(sawElement.getAttribute("y"))),
								width,
								height,
								radius));
        			}
				}
				return;
			}
		}
	}

    /**
 	 * Trims any extraneous space after a period in the given string.
 	 *
 	 * @param s The String to trim
 	 * @return The trimmed String
 	 */
	private String trim(String s) {
    	return s.contains(".") ? s.replaceAll("\\s+", "") : s;
	}

}
