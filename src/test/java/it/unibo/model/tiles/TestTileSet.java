package it.unibo.model.tiles;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import it.unibo.commons.Constants;

public class TestTileSet {

    private TileSet tileSet;

    @BeforeEach
    public void init() {
        this.tileSet = new TileSetImpl(Constants.SOURCE_MAP);
        assertNotNull(this.tileSet);
    }

    @Test
    public void testRead() {
        try {
            tileSet.read();
            assertNotNull(tileSet.getTiles());
            assertFalse(tileSet.getTiles().isEmpty());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
    
}

