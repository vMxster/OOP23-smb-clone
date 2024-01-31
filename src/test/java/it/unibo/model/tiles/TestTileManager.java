package it.unibo.model.tiles;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.commons.Constants;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.entity.target.BandageGirlImpl;

public class TestTileManager {

    private TileManagerImpl tileManager;
    private URL urlMap;

    @BeforeEach
    public void init() throws MalformedURLException {
        this.urlMap = new URL("file:./src/main/resources/factory1.tmx");
        assertNotNull(this.urlMap);
        this.tileManager = new TileManagerImpl(urlMap);
        assertNotNull(this.tileManager);
    }

    @Test
    public void testLoadMap() {
        try {
            tileManager.loadMap();
            assertNotNull(tileManager.getStationary());
            assertNotNull(tileManager.getPlatforms());
            assertNotNull(tileManager.getSaws());
        } catch (IllegalArgumentException | NullPointerException exception) {
            fail("Exception not expected: " + exception.getMessage());
        }
    }

    @Test
    public void testNumCols() {
        assertEquals(36, tileManager.getNumCols());
    }

    @Test
    public void testNumRows() {
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
        BandageGirl bandageGirl = new BandageGirlImpl(0, 0, Constants.TILE_SIZE, Constants.TILE_SIZE);
        bandageGirl.setX(1);
        assertEquals(1, bandageGirl.getX());
        bandageGirl.setY(2);
        assertEquals(2, bandageGirl.getY());
    }
}

