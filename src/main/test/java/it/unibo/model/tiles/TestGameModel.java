package it.unibo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.List;

import it.unibo.model.GameModel;
import it.unibo.model.GameModelImpl;
import it.unibo.model.tiles.Tile;

public class GameModelImplTest {

    private final URL urlMap;
    private final GameModel gameModel;

    @BeforeEach
    public void init() {
        this.urlMap = getClass().getResource("/testMap.txt");
        assertNotNull(this.urlMap);
        this.gameModel = new GameModelImpl(urlMap);
        assertNotNull(this.gameModel);
    }

    @Test
    public void testGetStationary() {
        List<List<Tile>> stationary = gameModel.getStationary();
        assertNotNull(stationary);
    }

    @Test
    public void testGetNumRows() {
        int numRows = gameModel.getNumRows();
        assertEquals(30, numRows);
    }

    @Test
    public void testGetNumCols() {
        int numCols = gameModel.getNumCols();
        assertEquals(36, numCols);
    }

}

