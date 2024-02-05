package it.unibo.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import it.unibo.commons.Constants;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.tiles.Tile;
import it.unibo.commons.Point2D;

public class TestGameModel {

    private GameModel gameModel;

    @BeforeEach
    public void init() {
        this.gameModel = new GameModelImpl(Constants.SOURCE_MAP);
        assertNotNull(this.gameModel);
    }

    @Test
    public void testGetStationary() {
        List<List<Tile>> stationary = gameModel.getStationary();
        assertNotNull(stationary);
        assertFalse(stationary.isEmpty());
    }

    @Test
    public void testGetSaws() {
        List<CircularSaw> saws = gameModel.getSaws();
        assertNotNull(saws);
        assertFalse(saws.isEmpty());
    }

    @Test
    public void testGetPlatforms() {
        List<Platform> platforms = gameModel.getPlatforms();
        assertNotNull(platforms);
        assertFalse(platforms.isEmpty());
    }

    @Test
    public void testGetBandageGirl() {
        BandageGirl bandageGirl = gameModel.getBandageGirl();
        assertNotNull(bandageGirl);
    }

    @Test
    public void testGetMeatBoy() {
        MeatBoy meatBoy = gameModel.getMeatBoy();
        assertNotNull(meatBoy);
    }

    @Test
    public void testGetMeatBoyStartCoord() {
        Point2D<Double, Double> startCoord = gameModel.getMeatBoyStartCoord();
        assertNotNull(startCoord);
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