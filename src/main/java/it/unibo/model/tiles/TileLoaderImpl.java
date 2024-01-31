package it.unibo.model.tiles;

import java.util.Objects;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.unibo.commons.Constants;
import it.unibo.model.entity.obstacles.CircularSawImpl;
import it.unibo.model.entity.obstacles.PlatformImpl;

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

	@Override
	public void loadStationaryTiles() {
		NodeList tileNodeList = document.getElementsByTagName("tile");
		int gidNumber = 0;
		for (int row = 0; row < this.numRows; row++) {
			for (int column = 0; column < this.numColumns; column++) {
				Element tilesetElement = (Element) Objects.requireNonNull(tileNodeList.item(gidNumber));
				int idTile = Integer.parseInt(tilesetElement.getAttributes().getNamedItem("gid").getTextContent());
				if (idTile > Constants.ID_TILE_NULL) {
					if (idTile == Constants.ID_TILE_BANDAGEGIRL) {
						this.tileManager.getBandageGirl().setX(Double.valueOf(column * Constants.TILE_SIZE));
						this.tileManager.getBandageGirl().setY(Double.valueOf(row * Constants.TILE_SIZE));
						this.tileManager.getStationary().get(row).add(column, this.tileManager.getTiles().get(idTile - 1));
					} else if (idTile == Constants.ID_TILE_MEATBOY) {
						this.tileManager.getMeatBoy().setX(Double.valueOf(column * Constants.TILE_SIZE));
						this.tileManager.getMeatBoy().setY(Double.valueOf(row * Constants.TILE_SIZE));
					} else {
						this.tileManager.getStationary().get(row).add(column, this.tileManager.getTiles().get(idTile - 1));
					}
				}
				gidNumber++;
			}
		}
	}
	
	@Override
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

	@Override
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

            		int radius = Integer.parseInt(trim(sawElement.getAttribute("width")));

					this.tileManager.getSaws().add(
						new CircularSawImpl(
							Integer.parseInt(trim(sawElement.getAttribute("x"))),
							Integer.parseInt(trim(sawElement.getAttribute("y"))),
							radius));
            		
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
