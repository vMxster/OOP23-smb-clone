package it.unibo.model.tiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.mockito.MockedStatic;
import org.mockito.Mockito;

import it.unibo.model.tiles.TileManager;

public class TestTileLoader {

    private final TileManager tileManager;
    private final URL urlMap;

    @BeforeEach
    public void init() {
        URL urlMap = getClass().getResource("/testMap.xml");
        assertNotNull(this.urlMap);
        this.tileManager = new TileManagerImpl(urlMap);
        assertNotNull(this.tileManager);
    }

    @Test
    public void testLoadStationaryTiles() {
        try (MockedStatic<DocumentLoader> documentLoaderMockedStatic = Mockito.mockStatic(DocumentLoader.class)) {
            DocumentLoader documentLoader = mock(DocumentLoader.class);
            documentLoaderMockedStatic.when(() -> DocumentLoader.loadDocument(any(URL.class))).thenReturn(documentLoader);
            tileLoader.loadStationaryTiles();
            assertNotNull(this.tileManager.getStationary());
        } catch (IOException e) {
            fail("Exception not expected: " + e.getMessage());
        }
    }

    @Test
    public void testLoadPlatforms() {
        try (MockedStatic<DocumentLoader> documentLoaderMockedStatic = Mockito.mockStatic(DocumentLoader.class)) {
            DocumentLoader documentLoader = mock(DocumentLoader.class);
            documentLoaderMockedStatic.when(() -> DocumentLoader.loadDocument(any(URL.class))).thenReturn(documentLoader);
            tileLoader.loadPlatforms();
            assertNotNull(this.tileManager.getPlatforms());
        } catch (IOException e) {
            fail("Exception not expected: " + e.getMessage());
        }
    }

    @Test
    public void testLoadCircularSaws() {
        try (MockedStatic<DocumentLoader> documentLoaderMockedStatic = Mockito.mockStatic(DocumentLoader.class)) {
            DocumentLoader documentLoader = mock(DocumentLoader.class);
            documentLoaderMockedStatic.when(() -> DocumentLoader.loadDocument(any(URL.class))).thenReturn(documentLoader);
            tileLoader.loadCircularSaws();
            assertNotNull(this.tileManager.getSaws());
        } catch (IOException e) {
            fail("Exception not expected: " + e.getMessage());
        }
    }

    @Test
    public void testTrim() {
        String trimmed = tileLoader.trim("  abc.def  ");
        assertEquals("abc.def", trimmed);
    }
}

