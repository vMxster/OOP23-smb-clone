package it.unibo.model.tiles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.commons.Constants;

import java.net.MalformedURLException;

public class TestTileLoader {

    private TileManager tileManager;
    private TileLoaderImpl tileLoader;

    @BeforeEach
    public void init() throws MalformedURLException {
        this.tileManager = new TileManagerImpl(Constants.SOURCE_MAP);
        assertNotNull(this.tileManager);
        this.tileLoader = new TileLoaderImpl(tileManager);
        assertNotNull(this.tileManager);
    }

    @Test
    public void testLoadStationaryTiles() {
        this.tileLoader.loadStationaryTiles();
        assertNotNull(this.tileManager.getStationary());
        assertFalse(this.tileManager.getStationary().isEmpty());
        assertNotNull(this.tileManager.getBandageGirl());
        assertNotNull(this.tileManager.getMeatBoy());
    }

    @Test
    public void testLoadPlatforms() {
        this.tileLoader.loadPlatforms();
        assertNotNull(this.tileManager.getPlatforms());
        assertFalse(this.tileManager.getPlatforms().isEmpty());
    }

    @Test
    public void testLoadCircularSaws() {
        tileLoader.loadCircularSaws();
        assertNotNull(this.tileManager.getSaws());
        assertFalse(this.tileManager.getSaws().isEmpty());
    }

}

