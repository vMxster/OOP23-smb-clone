package it.unibo.model.tiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.unibo.commons.Point2D;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.tiles.Tile;

public class TestTileManager {

    private final TileManagerImpl tileManager;
    private final URL urlMap;

    @BeforeEach
    public void init() {
        this.urlMap = getClass().getResource("/testMap.xml");
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
        } catch (SAXException | IllegalArgumentException | NullPointerException exception) {
            fail("Exception not expected: " + exception.getMessage());
        }
    }

    @Test
    public void testGetNumCols() {
        assertEquals(36, tileManager.getNumCols());
    }

    @Test
    public void testGetNumRows() {
        assertEquals(30, tileManager.getNumRows());
    }

    @Test
    public void testGetPlayerCoordStart() {
        assertNotNull(tileManager.getPlayerCoordStart());
    }

    @Test
    public void testGetBandageGirl() {
        assertNull(tileManager.getBandageGirl());
    }

    @Test
    public void testGetDocument() {
        assertNotNull(tileManager.getDocument());
    }

    @Test
    public void testGetTiles() {
        assertNotNull(tileManager.getTiles());
    }

    @Test
    public void testSetBandageGirl() {
        BandageGirl bandageGirl = mock(BandageGirl.class);
        tileManager.setBandageGirl(bandageGirl);
        assertEquals(bandageGirl, tileManager.getBandageGirl());
    }
}

