package it.unibo.model.tiles.loader;

import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.Optional;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.unibo.commons.Constants;
import it.unibo.model.documentextractor.DocumentExtractor;
import it.unibo.model.documentextractor.DocumentExtractorImpl;
import it.unibo.model.entity.obstacles.CircularSawImpl;
import it.unibo.model.entity.obstacles.PlatformImpl;
import it.unibo.model.tiles.manager.TileManager;

/**
 * The TileLoaderImpl class is responsible for loading tiles and objects from a TMX file
 * and populating the TileManager with the loaded data.
 */
public class TileLoaderImpl implements TileLoader {

    private static final int ID_TILE_BANDAGEGIRL = 902;
    private static final int ID_TILE_MEATBOY = 901;
    private static final int ID_TILE_NULL = 0;
    private final TileManager tileManager;
    private final DocumentExtractor documentExtractor;
    private final int numColumns;
    private final int numRows;

    /**
     * Constructs a TileLoaderImpl instance with the specified TileManager.
     * Initializes the TileLoaderImpl with the necessary information from the provided TileManager,
     * including the number of rows, number of columns, and the XML document containing tile data.
     *
     * @param tileManager The TileManager providing information about the game level's tiles.
     * @param tmx The path to the TMX file containing tile data.
     */
    public TileLoaderImpl(final TileManager tileManager, final String tmx) {
        this.tileManager = tileManager;
        this.documentExtractor = new DocumentExtractorImpl(tmx);
        this.numRows = documentExtractor.getNumRows();
        this.numColumns = documentExtractor.getNumColumns();
    }

    /**
     * Loads stationary tiles and objects from the TMX file.
     */
    @Override
    public void load() {
        loadStationaryTiles();
        loadObjects("rectangle");
        loadObjects("saws");
    }

    /**
     * Loads stationary tiles from the TMX file and populates the TileManager.
     */
    private void loadStationaryTiles() {
        final NodeList tileNodeList = documentExtractor.getElements("tile");

        IntStream.range(0, numRows)
                .forEach(
                    row -> IntStream.range(0, numColumns)
                        .forEach(column -> {
                            final int gidNumber = row * numColumns + column;
                            if (gidNumber < tileNodeList.getLength()) {
                                final Element tilesetElement = (Element) Objects.requireNonNull(tileNodeList.item(gidNumber));
                                final int idTile = Integer.parseInt(
                                    tilesetElement.getAttributes().getNamedItem("gid").getTextContent());

                                if (idTile > ID_TILE_NULL) {
                                    if (idTile == ID_TILE_BANDAGEGIRL) {
                                        tileManager.getBandageGirl().setX(
                                            Double.valueOf(column * Constants.TILE_SIZE));
                                        tileManager.getBandageGirl().setY(
                                            Double.valueOf(row * Constants.TILE_SIZE));
                                        tileManager.getStationary().get(row)
                                            .set(column, Optional.of(tileManager.getTiles().get(idTile - 1)));
                                    } else if (idTile == ID_TILE_MEATBOY) {
                                        tileManager.getMeatBoy().setX(
                                            Double.valueOf(column * Constants.TILE_SIZE));
                                        tileManager.getMeatBoy().setY(
                                            Double.valueOf(row * Constants.TILE_SIZE));
                                    } else {
                                        tileManager.getStationary().get(row)
                                            .set(column, Optional.of(tileManager.getTiles().get(idTile - 1)));
                                    }
                                }
                            }
                        }));
    }

    /**
     * Loads objects from the TMX file and populates the TileManager.
     *
     * @param nameObjects The name of the objects to load ( "rectangle" , "saws" ).
     */
    private void loadObjects(final String nameObjects) {
        final NodeList objects = documentExtractor.getElements("objectgroup");
        IntStream.range(0, objects.getLength())
            .mapToObj(i -> (Element) objects.item(i))
            .collect(Collectors.toList()).stream()
                .filter(node -> nameObjects.equals(((Element) node).getAttribute("name")))
                .findFirst()
                .ifPresent(objectGroupElement -> {
                    final NodeList objectsInGroup = ((Element) objectGroupElement).getElementsByTagName("object");
                    IntStream.range(0, objectsInGroup.getLength())
                        .mapToObj(i -> (Element) objectsInGroup.item(i))
                        .collect(Collectors.toList()).stream()
                            .map(objectNode -> (Element) objectNode)
                            .forEach(objectElement -> {
                                if ("saws".equals(nameObjects)) {
                                    this.tileManager.getSaws().add(
                                    new CircularSawImpl(
                                        Integer.parseInt(trim(objectElement.getAttribute("x"))),
                                        Integer.parseInt(trim(objectElement.getAttribute("y"))),
                                        Integer.parseInt(trim(objectElement.getAttribute("width")))));
                                } else {
                                    this.tileManager.getPlatforms().add(
                                    new PlatformImpl(
                                        Integer.parseInt(trim(objectElement.getAttribute("x"))),
                                        Integer.parseInt(trim(objectElement.getAttribute("y"))),
                                        Integer.parseInt(trim(objectElement.getAttribute("width"))),
                                        Integer.parseInt(trim(objectElement.getAttribute("height")))));
                                }
                            });
                });
    }

    /**
     * Trims any extraneous space after a period in the given string.
     *
     * @param s The String to trim
     * @return The trimmed String
     */
    private String trim(final String s) {
        return s.contains(".") ? s.replaceAll("\\s+", "") : s;
    }

}
