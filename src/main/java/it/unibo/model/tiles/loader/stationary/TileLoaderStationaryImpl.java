package it.unibo.model.tiles.loader.stationary;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.unibo.commons.Constants;
import it.unibo.commons.Point2D;
import it.unibo.model.documentextractor.DocumentExtractor;
import it.unibo.model.tiles.loader.manager.TileLoaderManager;

/**
 * The TileLoaderStationary class is responsible for loading stationary tiles
 * from an XML document and populating the TileLoaderManager.
 */
public class TileLoaderStationaryImpl implements TileLoaderStationary {

    private static final int ID_TILE_BANDAGEGIRL = 902;
    private static final int ID_TILE_MEATBOY = 901;
    private static final int ID_TILE_NULL = 0;
    private final TileLoaderManager tileLoaderManager;
    private final DocumentExtractor documentExtractor;
    private final int numRows;
    private final int numColumns;

    /**
     * Constructs a TileLoaderStationaryImpl with the specified TileLoaderManager
     * and DocumentExtractor.
     *
     * @param tileLoaderManager  The tile loader manager.
     * @param documentExtractor The document extractor.
     */
    public TileLoaderStationaryImpl(final TileLoaderManager tileLoaderManager, final DocumentExtractor documentExtractor) {
        this.tileLoaderManager = tileLoaderManager;
        this.documentExtractor = documentExtractor;
        this.numRows = this.documentExtractor.getNumRows();
        this.numColumns = this.documentExtractor.getNumColumns();
    }

    /**
     * Loads stationary tiles from an XML document.
     */
    @Override
    public void load() {
        this.loadStationaryTiles();
    }

    /**
     * Loads stationary tiles from the TMX file and populates the TileManager.
     */
    private void loadStationaryTiles() {
        final NodeList tileNodeList = documentExtractor.getElements("tile");

        IntStream.range(0, this.numRows)
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
                                        this.tileLoaderManager.setBandageGirlCoord(
                                            new Point2D<Double, Double>(
                                                Double.valueOf(column * Constants.TILE_SIZE),
                                                Double.valueOf(row * Constants.TILE_SIZE))
                                        );
                                        this.tileLoaderManager.getStationary().get(row)
                                            .set(column,
                                                Optional.of(this.tileLoaderManager.getTiles().get(idTile - 1)));
                                    } else if (idTile == ID_TILE_MEATBOY) {
                                        this.tileLoaderManager.setMeatBoyCoord(
                                            new Point2D<Double, Double>(
                                                Double.valueOf(column * Constants.TILE_SIZE),
                                                Double.valueOf(row * Constants.TILE_SIZE))
                                            );
                                    } else {
                                        this.tileLoaderManager.getStationary().get(row)
                                            .set(column,
                                                Optional.of(this.tileLoaderManager.getTiles().get(idTile - 1)));
                                    }
                                }
                            }
                        }));
    }

}
