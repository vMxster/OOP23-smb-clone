package it.unibo.model.tiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        List<Tile> list = tileSet.read();
        assertNotNull(list);
        assertFalse(list.isEmpty());
    }

}

