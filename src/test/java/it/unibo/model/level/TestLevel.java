package it.unibo.model.level;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.tiles.Tile;
import it.unibo.commons.Constants;
import it.unibo.commons.Point2D;

/**
 * JUnit test class for LevelImpl.
 */
public class TestLevel {

    private Level level;

    /**
     * Initialize the LevelImpl instance before each test.
     */
    @BeforeEach
    public void setUp() {
        level = new LevelImpl(Constants.SOURCE_MAP);
        assertNotNull(level);
    }

    /**
     * Test the {@link LevelImpl#getMeatBoy()} method.
     */
    @Test
    public void testGetMeatBoy() {
        MeatBoy meatBoy = level.getMeatBoy();
        assertNotNull(meatBoy);
    }

    /**
     * Test the {@link LevelImpl#getMeatBoyStartCoord()} method.
     */
    @Test
    public void testGetMeatBoyStartCoord() {
        Point2D<Double, Double> startCoord = level.getMeatBoyStartCoord();
        assertNotNull(startCoord);
    }

    /**
     * Test the {@link LevelImpl#getBandageGirl()} method.
     */
    @Test
    public void testGetBandageGirl() {
        BandageGirl bandageGirl = level.getBandageGirl();
        assertNotNull(bandageGirl);
    }

    /**
     * Test the {@link LevelImpl#getStationary()} method.
     */
    @Test
    public void testGetStationary() {
        List<List<Optional<Tile>>> stationary = level.getStationary();
        assertNotNull(stationary);
    }

    /**
     * Test the {@link LevelImpl#getPlatforms()} method.
     */
    @Test
    public void testGetPlatforms() {
        List<Platform> platforms = level.getPlatforms();
        assertNotNull(platforms);
    }

    /**
     * Test the {@link LevelImpl#getSaws()} method.
     */
    @Test
    public void testGetSaws() {
        List<CircularSaw> saws = level.getSaws();
        assertNotNull(saws);
    }

    /**
     * Test the {@link LevelImpl#getNumCols()} method.
     */
    @Test
    public void testGetNumCols() {
        int numCols = level.getNumCols();
        assertTrue(numCols > 0);
    }

    /**
     * Test the {@link LevelImpl#getNumRows()} method.
     */
    @Test
    public void testGetNumRows() {
        int numRows = level.getNumRows();
        assertTrue(numRows > 0);
    }

}
