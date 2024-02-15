package it.unibo.model.tiles.tileset;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import it.unibo.commons.Constants;
import it.unibo.model.tiles.Tile;
import it.unibo.model.tiles.TileImpl;

/**
 * Implementation of the TileSet interface for parsing TMX file and extracting tiles.
 */
public class TileSetImpl implements TileSet {

    private final String tmx;
    private final List<Tile> tiles;

    /**
     * Constructs a new TileSetImpl object by specifying the TMX file to parse.
     *
     * @param tmx The path to the TMX file to parse.
     */
    public TileSetImpl(final String tmx) {
        this.tmx = tmx;
        this.tiles = new ArrayList<>();
    }

    /**
     * Reads the TMX file, parses it, and extracts tiles.
     * 
     * @return A list of Tile objects extracted from the TMX file.
     */
    @Override
    public List<Tile> read() {
        try {
            parseTMXFile();
        } catch (SAXException | IOException | ParserConfigurationException e) {
            Logger.getLogger(TileSetImpl.class.getName())
                        .severe("An error occurred: " + e.getMessage());
        }
        return Collections.unmodifiableList(this.tiles);
    }

    /**
     * Parses the TMX file to identify sprite sheets and divide them into tiles.
     * 
     * @throws ParserConfigurationException If a DocumentBuilder cannot be created which satisfies the configuration requested.
     * @throws SAXException                 If any parse errors occur.
     * @throws IOException                  If an I/O error occurs while reading the XML file.
     */
    private void parseTMXFile() throws SAXException, IOException, ParserConfigurationException {
        final Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(tmx);
        final NodeList tileSetNodeList = document.getElementsByTagName("tileset");

        IntStream.range(0, tileSetNodeList.getLength())
            .mapToObj(i -> (Element) tileSetNodeList.item(i))
            .forEach(tilesetElement -> {
                try {
                    divideSpriteSheet(
                        Integer.parseInt(Objects.requireNonNull(
                            tilesetElement.getElementsByTagName("image").item(0))
                                .getAttributes().getNamedItem("width").getTextContent()),
                        Integer.parseInt(Objects.requireNonNull(
                            tilesetElement.getElementsByTagName("image").item(0))
                                .getAttributes().getNamedItem("height").getTextContent()),
                        Objects.requireNonNull(
                            tilesetElement.getElementsByTagName("image").item(0))
                                .getAttributes().getNamedItem("source").getTextContent());
                } catch (IOException e) {
                    Logger.getLogger(TileSetImpl.class.getName())
                        .severe("An error occurred: " + e.getMessage());
                }
            });
    }

    /**
     * Splits the sprite sheet into tiles of the appropriate size.
     *
     * @param width    The width of the tileset image.
     * @param height   The height of the tileset image.
     * @param srcImage The source image of the tileset.
     * @throws IOException If an I/O error occurs.
     */
    private void divideSpriteSheet(final int width, final int height, final String srcImage) throws IOException {
        IntStream.range(0, height / Constants.TILE_SIZE)
                .boxed()
                .flatMap(
                    row -> IntStream.range(0, width / Constants.TILE_SIZE)
                .mapToObj(
                    column -> new TileImpl(column * Constants.TILE_SIZE, row * Constants.TILE_SIZE, srcImage)))
                .forEach(tiles::add);
    }

}
