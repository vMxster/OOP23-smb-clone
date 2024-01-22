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
	 * Splits the SpriteSheet into tiles of the appropriate size.
	 * @param w The width of the TileSet image
	 * @param h The height of the TileSet image
	 * @throws IOException
	 */
    void divideSpriteSheet(int width, int height, String src) throws IOException;

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
