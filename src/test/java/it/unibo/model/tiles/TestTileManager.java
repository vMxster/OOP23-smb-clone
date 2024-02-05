package it.unibo.model.tiles;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.commons.Constants;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.entity.target.BandageGirlImpl;

public class TestTileManager {

    private TileManager tileManager;

    @BeforeEach
    public void init() {
        this.tileManager = new TileManagerImpl(Constants.SOURCE_MAP);
        assertNotNull(this.tileManager);
    }

    @Test
    public void testLoadMap() {
        try {
            tileManager.loadMap();
            assertNotNull(tileManager.getStationary());
            assertNotNull(tileManager.getPlatforms());
            assertNotNull(tileManager.getSaws());
            assertFalse(tileManager.getStationary().isEmpty());
            assertFalse(tileManager.getPlatforms().isEmpty());
            assertFalse(tileManager.getSaws().isEmpty());
        } catch (IllegalArgumentException | NullPointerException exception) {
            fail("Exception not expected: " + exception.getMessage());
        }
    }

    @Test
    public void testGetNumColsAndRows() {
        assertEquals(36, tileManager.getNumCols());
        assertEquals(30, tileManager.getNumRows());
    }

    @Test
    public void testMeatBoy() {
        assertNotNull(tileManager.getMeatBoy());
    }

    @Test
    public void testDocument() {
        assertNotNull(tileManager.getDocument());
    }

    @Test
    public void testTiles() {
        assertNotNull(tileManager.getTiles());
    }

    @Test
    public void testBandageGirl() {
        BandageGirl bandageGirl = new BandageGirlImpl(0, 0);
        bandageGirl.setX(1);
        assertEquals(1, bandageGirl.getX());
        bandageGirl.setY(2);
        assertEquals(2, bandageGirl.getY());
    }
}