package it.unibo.model.tiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.commons.Constants;
import it.unibo.model.documentextractor.DocumentExtractor;
import it.unibo.model.documentextractor.DocumentExtractorImpl;

/**
 * JUnit tests for the TileLoader class.
 */
public class TestTileLoader {

    private TileManager tileManager;
    private DocumentExtractor documentExtractor;
    private TileLoaderImpl tileLoader;

    /**
     * Initializes the test environment before each test method is executed.
     */
    @BeforeEach
    public void init() {
        this.tileManager = new TileManagerImpl(Constants.SOURCE_MAP);
        assertNotNull(this.tileManager);
        this.tileLoader = new TileLoaderImpl(tileManager, Constants.SOURCE_MAP);
        assertNotNull(this.tileManager);
        this.documentExtractor = new DocumentExtractorImpl(Constants.SOURCE_MAP);
        assertNotNull(this.documentExtractor);
    }

    /**
     * Tests the {@link TileLoaderImpl#load()} method.
     */
    @Test
    public void testLoad() {
        this.tileLoader.load();
        assertNotNull(this.tileManager.getStationary());
        assertFalse(this.tileManager.getStationary().isEmpty());
        assertNotNull(this.tileManager.getSaws());
        assertFalse(this.tileManager.getSaws().isEmpty());
        assertNotNull(this.tileManager.getPlatforms());
        assertFalse(this.tileManager.getPlatforms().isEmpty());
        assertNotNull(this.tileManager.getBandageGirl());
        assertNotNull(this.tileManager.getMeatBoy());
    }

}
