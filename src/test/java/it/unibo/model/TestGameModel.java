package it.unibo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import it.unibo.model.tiles.Tile;

public class TestGameModel {

    private URL urlMap;
    private GameModel gameModel;

    @BeforeEach
    public void init() throws MalformedURLException {
        this.urlMap = new URL("file:./src/main/resources/factory1.tmx");
        assertNotNull(this.urlMap);
        //this.gameModel = new GameModelImpl(urlMap);
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

