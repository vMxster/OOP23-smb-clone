package it.unibo.model.tiles;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.List;

/**
 * An interface representing a collection of tiles obtained from a TMX file.
 * Implementing classes should provide methods to access and manipulate the TileSet.
 */
public interface TileSet {

    /**
     * Analyzes the TMX file to identify the appropriate sprite sheets.
     *
     * @throws ParserConfigurationException If a DocumentBuilder cannot be created which satisfies the configuration requested.
     * @throws SAXException                 If any parse errors occur.
     * @throws IOException                  If an I/O error occurs while reading the XML file.
     */
    void read() throws ParserConfigurationException, SAXException, IOException;

    /**
     * Retrieves a list of tiles contained in the TileSet.
     *
     * @return A list of Tile objects representing the tiles in the TileSet.
     */
    List<Tile> getTiles();

}
