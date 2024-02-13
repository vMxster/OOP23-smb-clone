package it.unibo.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import it.unibo.commons.Constants;
import it.unibo.model.collision.CollisionHandler;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.tiles.Tile;
import it.unibo.commons.Point2D;
import it.unibo.controller.GameControllerImpl;

/**
 * JUnit tests for the GameModel class.
 */
public class TestGameModel {

    private static final int MAP_ROWS = 30;
    private static final int MAP_COLUMNS = 36;
    private GameModel gameModel;

    /**
     * Initializes the test environment before each test method is executed.
     */
    @BeforeEach
    public void init() {
        this.gameModel = new GameModelImpl(Constants.SOURCE_MAP, new GameControllerImpl());
        assertNotNull(this.gameModel);
    }

    /**
     * Tests the {@link GameModel#getStationary()} method.
     */
    @Test
    public void testGetStationary() {
        List<List<Optional<Tile>>> stationary = gameModel.getStationary();
        assertNotNull(stationary);
        assertFalse(stationary.isEmpty());
    }

    /**
     * Tests the {@link GameModel#getSaws()} method.
     */
    @Test
    public void testGetSaws() {
        List<CircularSaw> saws = gameModel.getSaws();
        assertNotNull(saws);
        assertFalse(saws.isEmpty());
    }

    /**
     * Tests the {@link GameModel#getPlatforms()} method.
     */
    @Test
    public void testGetPlatforms() {
        List<Platform> platforms = gameModel.getPlatforms();
        assertNotNull(platforms);
        assertFalse(platforms.isEmpty());
    }

    /**
     * Tests the {@link GameModel#getBandageGirl()} method.
     */
    @Test
    public void testGetBandageGirl() {
        BandageGirl bandageGirl = gameModel.getBandageGirl();
        assertNotNull(bandageGirl);
    }

    /**
     * Tests the {@link GameModel#getMeatBoy()} method.
     */
    @Test
    public void testGetMeatBoy() {
        MeatBoy meatBoy = gameModel.getMeatBoy();
        assertNotNull(meatBoy);
    }

    /**
     * Tests the {@link GameModel#getMeatBoyStartCoord()} method.
     */
    @Test
    public void testGetMeatBoyStartCoord() {
        Point2D<Double, Double> startCoord = gameModel.getMeatBoyStartCoord();
        assertNotNull(startCoord);
    }

    /**
     * Tests the {@link GameModel#getNumRows()} method.
     */
    @Test
    public void testGetNumRows() {
        int numRows = gameModel.getNumRows();
        assertEquals(MAP_ROWS, numRows);
    }

    /**
     * Tests the {@link GameModel#getNumCols()} method.
     */
    @Test
    public void testGetNumCols() {
        int numCols = gameModel.getNumCols();
        assertEquals(MAP_COLUMNS, numCols);
    }

    /**
     * Tests the {@link GameModel#getCollisionHandler()} method.
     */
    @Test
    public void testGetCollisionHandler() {
        CollisionHandler collisionHandler = gameModel.getCollisionHandler();
        assertNotNull(collisionHandler);
    }

}
