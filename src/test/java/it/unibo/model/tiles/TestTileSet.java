package it.unibo.model.tiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import it.unibo.commons.Constants;

/**
 * JUnit tests for the TileSet class.
 */
public class TestTileSet {

    private TileSet tileSet;

    /**
     * Initializes the test environment before each test method is executed.
     */
    @BeforeEach
    public void init() {
        this.tileSet = new TileSetImpl(Constants.SOURCE_MAP);
        assertNotNull(this.tileSet);
    }

    /**
     * Tests the {@link TileSetImpl#read()} method.
     */
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

