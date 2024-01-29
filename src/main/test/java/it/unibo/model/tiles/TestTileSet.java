package it.unibo.model.tiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.xml.sax.SAXException;

import it.unibo.model.tiles.Tile;

public class TestTileSet {

    private final TileSetImpl tileSet;
    private final URL urlMap;

    @BeforeEach
    public void init() {
        this.urlMap = getClass().getResource("/testTileSet.tmx");
        assertNotNull(this.urlMap);
        this.tileSet = new TileSetImpl(this.urlMap);
        assertNotNull(this.tileSet);
    }

    @Test
    public void testRead() {
        try (MockedStatic<DocumentBuilderFactory> documentBuilderFactoryMockedStatic = Mockito.mockStatic(DocumentBuilderFactory.class)) {
            DocumentBuilderFactory documentBuilderFactory = mock(DocumentBuilderFactory.class);
            documentBuilderFactoryMockedStatic.when(DocumentBuilderFactory::newInstance).thenReturn(documentBuilderFactory);

            DocumentBuilder documentBuilder = mock(DocumentBuilder.class);
            when(documentBuilderFactory.newDocumentBuilder()).thenReturn(documentBuilder);

            Document document = mock(Document.class);
            when(documentBuilder.parse(any(URL.class))).thenReturn(document);

            NodeList tileSetNodeList = mock(NodeList.class);
            when(document.getElementsByTagName("tileset")).thenReturn(tileSetNodeList);
            when(tileSetNodeList.getLength()).thenReturn(1);

            Element tilesetElement = mock(Element.class);
            when(tileSetNodeList.item(0)).thenReturn(tilesetElement);

            NodeList imageNodeList = mock(NodeList.class);
            when(tilesetElement.getElementsByTagName("image")).thenReturn(imageNodeList);
            when(imageNodeList.item(0)).thenReturn(tilesetElement);

            when(tilesetElement.getAttributes().getNamedItem("width").getTextContent()).thenReturn("100");
            when(tilesetElement.getAttributes().getNamedItem("height").getTextContent()).thenReturn("80");
            when(tilesetElement.getAttributes().getNamedItem("source").getTextContent()).thenReturn("/testImage.png");

            tileSet.read();

        } catch (ParserConfigurationException | SAXException | IOException exception) {
            fail("Exception not expected: " + exception.getMessage());
        }
    }

    @Test
    public void testDivideSpriteSheet() {
        try {
            tileSet.divideSpriteSheet(100, 80, "/testImage.png");
            List<Tile> tiles = tileSet.getTiles();

            assertNotNull(tiles);
            assertEquals(20, tiles.size());
        } catch (IOException exception) {
            fail("Exception not expected: " + exception.getMessage());
        }
    }

    @Test
    public void testGetTiles() {
        assertNotNull(tileSet.getTiles());
    }
}

