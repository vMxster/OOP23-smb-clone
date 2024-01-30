package it.unibo.model.tiles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestTileLoader {

    private TileManager tileManager;
    private URL urlMap;
    private TileLoaderImpl tileLoader;

    @BeforeEach
    public void init() throws MalformedURLException {
        this.urlMap = new URL("file:./src/main/resources/factory1.tmx");
        assertNotNull(this.urlMap);
        this.tileManager = new TileManagerImpl(urlMap);
        assertNotNull(this.tileManager);
        this.tileLoader = new TileLoaderImpl(tileManager);
    }

    @Test
    public void testLoadStationaryTiles() {
        tileLoader.loadStationaryTiles();
        assertNotNull(this.tileManager.getStationary());
    }

    @Test
    public void testLoadPlatforms() {
        tileLoader.loadPlatforms();
        assertNotNull(this.tileManager.getPlatforms());
    }

    @Test
    public void testLoadCircularSaws() {
        tileLoader.loadCircularSaws();
        assertNotNull(this.tileManager.getSaws());
    }

}
