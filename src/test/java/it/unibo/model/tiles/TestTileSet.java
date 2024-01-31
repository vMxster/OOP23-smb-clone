package it.unibo.model.tiles;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

public class TestTileSet {

    private TileSetImpl tileSet;
    private URL urlMap;

    @BeforeEach
    public void init() throws MalformedURLException {
        this.urlMap = new URL("file:./src/main/resources/factory1.tmx");
        assertNotNull(this.urlMap);
        this.tileSet = new TileSetImpl(this.urlMap);
        assertNotNull(this.tileSet);
    }

    @Test
    public void testRead() {
        try {
            tileSet.read();
            assertNotNull(tileSet.getTiles());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

}
