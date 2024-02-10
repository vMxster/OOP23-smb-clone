package it.unibo.model.tiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import it.unibo.commons.Constants;

/**
 * Implementation of the TileSet interface for parsing TMX files and extracting tiles.
 */
public class TileSetImpl implements TileSet {

    private final String tmx;
    private final List<Tile> tiles;

    /**
     * Constructs a new TileSet object by parsing a TMX file.
     *
     * @param tmx The TMX file to parse.
     */
    public TileSetImpl(final String tmx) {
        this.tmx = tmx;
        this.tiles = new ArrayList<>();
        try {
            read();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Analyzes the TMX file to identify the appropriate sprite sheets.
     *
     * @throws ParserConfigurationException If a DocumentBuilder cannot be created which satisfies the configuration requested.
     * @throws SAXException                 If any parse errors occur.
     * @throws IOException                  If an I/O error occurs while reading the XML file.
     */
    @Override
    public void read() throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document document = documentBuilder.parse(tmx);
    NodeList tileSetNodeList = document.getElementsByTagName("tileset");

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
                    e.printStackTrace();
                }
            });
    }

    /**
     * Retrieves a list of tiles contained in the TileSet.
     *
     * @return A list of Tile objects representing the tiles in the TileSet.
     */
    @Override
    public List<Tile> getTiles() {
        return this.tiles;
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
