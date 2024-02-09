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

public class TileSetImpl implements TileSet {

	private final String tmx;
	private final List<Tile> tiles;

	/**
	 * Constructs a new TileSet object by parsing a tmx file.
	 * @param tmx The tmx file to parse
	 */
	public TileSetImpl(String tmx) {
		this.tmx = tmx;
		this.tiles = new ArrayList<>();
		try {
            read();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
	}

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
						Integer.parseInt(Objects.requireNonNull(tilesetElement.getElementsByTagName("image").item(0)).getAttributes().getNamedItem("width").getTextContent()),
						Integer.parseInt(Objects.requireNonNull(tilesetElement.getElementsByTagName("image").item(0)).getAttributes().getNamedItem("height").getTextContent()),
						Objects.requireNonNull(tilesetElement.getElementsByTagName("image").item(0)).getAttributes().getNamedItem("source").getTextContent());
				} catch (IOException e) {
					e.printStackTrace();
				}
            });
	}


	@Override
	public List<Tile> getTiles() {
		return this.tiles;
	}

	/**
	 * Splits the SpriteSheet into tiles of the appropriate size.
	 * @param w The width of the TileSet image
	 * @param h The height of the TileSet image
	 * @throws IOException
	 */
	private void divideSpriteSheet(final int width, final int height, final String srcImage) throws IOException {
		IntStream.range(0, height / 20)
				.boxed()
				.flatMap(row -> IntStream.range(0, width / Constants.TILE_SIZE)
				.mapToObj(column -> new TileImpl(column * Constants.TILE_SIZE, row * Constants.TILE_SIZE, srcImage)))
				.forEach(tiles::add);
	}
	
}
