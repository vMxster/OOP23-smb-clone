package it.unibo.model.tiles;

import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.Optional;
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

    IntStream.range(0, numRows)
            .forEach(row -> IntStream.range(0, numColumns)
                    .forEach(column -> {
                        int gidNumber = row * numColumns + column;
                        if (gidNumber < tileNodeList.getLength()) {
                            Element tilesetElement = (Element) Objects.requireNonNull(tileNodeList.item(gidNumber));
                            int idTile = Integer.parseInt(tilesetElement.getAttributes().getNamedItem("gid").getTextContent());

                            if (idTile > Constants.ID_TILE_NULL) {
                                if (idTile == Constants.ID_TILE_BANDAGEGIRL) {
                                    tileManager.getBandageGirl().setX(Double.valueOf(column * Constants.TILE_SIZE));
                                    tileManager.getBandageGirl().setY(Double.valueOf(row * Constants.TILE_SIZE));
                                    tileManager.getStationary().get(row).set(column, Optional.of(tileManager.getTiles().get(idTile - 1)));
                                } else if (idTile == Constants.ID_TILE_MEATBOY) {
                                    tileManager.getMeatBoy().setX(Double.valueOf(column * Constants.TILE_SIZE));
                                    tileManager.getMeatBoy().setY(Double.valueOf(row * Constants.TILE_SIZE));
                                } else {
                                    tileManager.getStationary().get(row).set(column, Optional.of(tileManager.getTiles().get(idTile - 1)));
                                }
                            }
                        }
                    }));
	}

	
	@Override
	public void loadPlatforms() {
    NodeList rectangleObjects = this.document.getElementsByTagName("objectgroup");
	IntStream.range(0, rectangleObjects.getLength())
    	.mapToObj(i -> (Element) rectangleObjects.item(i))
    	.collect(Collectors.toList()).stream()
            .filter(node -> "rectangle".equals(((Element) node).getAttribute("name")))
            .findFirst()
            .ifPresent(objectGroupElement -> {
                NodeList objectsInGroup = ((Element) objectGroupElement).getElementsByTagName("object");
				IntStream.range(0, objectsInGroup.getLength())
    				.mapToObj(i -> (Element) objectsInGroup.item(i))
    				.collect(Collectors.toList()).stream()
                        .map(objectNode -> (Element) objectNode)
                        .forEach(platformElement -> {
                            this.tileManager.getPlatforms().add(
								new PlatformImpl(
									Integer.parseInt(trim(platformElement.getAttribute("x"))),
									Integer.parseInt(trim(platformElement.getAttribute("y"))),
									Integer.parseInt(trim(platformElement.getAttribute("width"))),
									Integer.parseInt(trim(platformElement.getAttribute("height")))));
                        });
            });
	}

	@Override
	public void loadCircularSaws() {
    NodeList sawObjects = this.document.getElementsByTagName("objectgroup");
	IntStream.range(0, sawObjects.getLength())
    	.mapToObj(i -> (Element) sawObjects.item(i))
    	.collect(Collectors.toList()).stream()
            .filter(node -> "saws".equals(((Element) node).getAttribute("name")))
            .findFirst()
            .ifPresent(objectGroupElement -> {
                NodeList objectsInGroup = ((Element) objectGroupElement).getElementsByTagName("object");
				IntStream.range(0, objectsInGroup.getLength())
    				.mapToObj(i -> (Element) objectsInGroup.item(i))
    				.collect(Collectors.toList()).stream()
                        .map(objectNode -> (Element) objectNode)
                        .forEach(sawElement -> {
                            this.tileManager.getSaws().add(
								new CircularSawImpl(
									Integer.parseInt(trim(sawElement.getAttribute("x"))),
									Integer.parseInt(trim(sawElement.getAttribute("y"))),
									Integer.parseInt(trim(sawElement.getAttribute("width")))));
                        });
            });
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
