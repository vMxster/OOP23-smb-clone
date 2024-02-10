package it.unibo.model.tiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.commons.Constants;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.tiles.manager.TileManager;
import it.unibo.model.tiles.manager.TileManagerImpl;

/**
 * JUnit tests for the TileManager class.
 */
public class TestTileManager {

    private static final int MAP_ROWS = 30;
    private static final int MAP_COLUMNS = 36;
    private TileManager tileManager;

    /**
     * Initializes the test environment before each test method is executed.
     */
    @BeforeEach
    public void init() {
        this.tileManager = new TileManagerImpl(Constants.SOURCE_MAP);
        assertNotNull(this.tileManager);
    }

    /**
     * Tests the initialization of the TileManager.
     */
    @Test
    void testInitialization() {
        assertNotNull(tileManager.getPlatforms());
        assertNotNull(tileManager.getSaws());
        assertNotNull(tileManager.getStationary());
        assertNotNull(tileManager.getTiles());
        assertFalse(tileManager.getTiles().isEmpty());
    }

    /**
     * Tests the {@link TileManagerImpl#getNumCols()} and {@link TileManagerImpl#getNumRows()} methods.
     */
    @Test
    public void testGetNumColsAndRows() {
        assertEquals(MAP_COLUMNS, tileManager.getNumCols());
        assertEquals(MAP_ROWS, tileManager.getNumRows());
    }

    /**
     * Tests the {@link TileManagerImpl#getTiles()} method.
     */
    @Test
    public void testTiles() {
        assertNotNull(tileManager.getTiles());
    }

    /**
     * Tests the {@link TileManagerImpl#getMeatBoy()} method.
     */
    @Test
    public void testMeatBoy() {
        assertNotNull(tileManager.getMeatBoy());
        MeatBoy meatBoy = tileManager.getMeatBoy();
        meatBoy.setX(1);
        assertEquals(1, meatBoy.getX());
        meatBoy.setY(2);
        assertEquals(2, meatBoy.getY());
    }

    /**
     * Tests the {@link TileManagerImpl#getBandageGirl()} method.
     */
    @Test
    public void testBandageGirl() {
        assertNotNull(tileManager.getBandageGirl());
        BandageGirl bandageGirl = tileManager.getBandageGirl();
        bandageGirl.setX(1);
        assertEquals(1, bandageGirl.getX());
        bandageGirl.setY(2);
        assertEquals(2, bandageGirl.getY());
    }

}
