package it.unibo.model.level;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.level.factory.LevelFactoryImpl;
import it.unibo.model.tiles.Tile;
import it.unibo.commons.Constants;
import it.unibo.commons.Point2D;

/**
 * JUnit test class for LevelImpl.
 */
public class TestLevel {

    private static final int NUM_ROWS = 30;
    private static final int NUM_COLUMNS = 36;
    private Level level;

    /**
     * Initialize the LevelImpl instance before each test.
     */
    @BeforeEach
    public void setUp() {
        level = new LevelFactoryImpl().createLevel(Constants.SOURCE_MAP);
        assertNotNull(level);
    }

    /**
     * Test the {@link LevelImpl#getMeatBoy()} method.
     */
    @Test
    public void testGetMeatBoy() {
        MeatBoy meatBoy = level.getMeatBoy();
        assertNotNull(meatBoy);
        assertNotEquals(0, meatBoy.getX());
        assertNotEquals(0, meatBoy.getY());
    }

    /**
     * Test the {@link LevelImpl#getMeatBoyStartCoord()} method.
     */
    @Test
    public void testGetMeatBoyStartCoord() {
        Point2D<Double, Double> startCoord = level.getMeatBoyStartCoord();
        assertNotNull(startCoord);
        assertNotEquals(0, startCoord.getX());
        assertNotEquals(0, startCoord.getY());
    }

    /**
     * Test the {@link LevelImpl#getBandageGirl()} method.
     */
    @Test
    public void testGetBandageGirl() {
        BandageGirl bandageGirl = level.getBandageGirl();
        assertNotNull(bandageGirl);
        assertNotEquals(0, bandageGirl.getX());
        assertNotEquals(0, bandageGirl.getY());
    }

    /**
     * Test the {@link LevelImpl#getStationary()} method.
     */
    @Test
    public void testGetStationary() {
        List<List<Optional<Tile>>> stationary = level.getStationary();
        assertNotNull(stationary);
        assertTrue(stationary.size()==NUM_ROWS);
        assertTrue(stationary.get(0).size()==NUM_COLUMNS);
    }

    /**
     * Test the {@link LevelImpl#getPlatforms()} method.
     */
    @Test
    public void testGetPlatforms() {
        List<Platform> platforms = level.getPlatforms();
        assertNotNull(platforms);
        assertEquals(6, platforms.size());
    }

    /**
     * Test the {@link LevelImpl#getSaws()} method.
     */
    @Test
    public void testGetSaws() {
        List<CircularSaw> saws = level.getSaws();
        assertNotNull(saws);
        assertEquals(2, saws.size());
    }

    /**
     * Test the {@link LevelImpl#getNumCols()} method.
     */
    @Test
    public void testGetNumCols() {
        assertEquals(NUM_COLUMNS, level.getNumCols());
    }

    /**
     * Test the {@link LevelImpl#getNumRows()} method.
     */
    @Test
    public void testGetNumRows() {
        assertEquals(NUM_ROWS, level.getNumRows());
    }

}
