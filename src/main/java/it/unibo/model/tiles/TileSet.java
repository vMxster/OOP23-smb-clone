package it.unibo.model.tiles;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.List;

/**
 * An interface representing a collection of tiles obtained from a tmx file.
 * Implementing classes should provide methods to access and manipulate the TileSet.
 */
public interface TileSet {

    /**
	 * Analyzes the tmx file to identify the appropriate SpriteSheets.
	 * @throws XPathExpressionException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws IOException
	 */
    void read() throws ParserConfigurationException, SAXException, IOException;

	/**
	 * @return a list of Tiles.
	 */
	List<Tile> getTiles();

}
