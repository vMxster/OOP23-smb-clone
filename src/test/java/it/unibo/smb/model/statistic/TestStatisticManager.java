package it.unibo.smb.model.statistic;

import it.unibo.smb.controller.LevelType;
import it.unibo.smb.model.statistic.factory.manager.StatisticManagerFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit test class for {@link StatisticManagerImpl}.
 */
class TestStatisticManager {

    private StatisticManager statisticManager;

    /**
     * Sets up the test fixture.
     */
    @BeforeEach
    void init() {
        statisticManager = new StatisticManagerFactoryImpl()
                .createStatisticManager();
        assertNotNull(statisticManager);
    }

    /**
     * Tests the {@link StatisticManager#whichLevel(LevelType)} method.
     */
    @Test
    void testWhichLevel() {
        final Statistic statistic = statisticManager.whichLevel(LevelType.FACTORY_LEVEL_1);
        assertEquals(LevelType.FACTORY_LEVEL_1, statistic.getLevelName());
    }

    /**
     * Tests the {@link StatisticManager#addDeaths(LevelType)} method.
     */
    @Test
    void testAddDeaths() {
        statisticManager.addDeaths(LevelType.FACTORY_LEVEL_2);
        final Statistic statistic = statisticManager.whichLevel(LevelType.FACTORY_LEVEL_2);
        assertEquals(1, statistic.getDeaths());
    }

    /**
     * Tests the {@link StatisticManager#updateRecord(int, LevelType)} method.
     */
    @Test
    void testUpdateRecord() {
        final int time = 500;
        statisticManager.updateRecord(time, LevelType.FOREST_LEVEL_1);
        final Statistic statistic = statisticManager.whichLevel(LevelType.FOREST_LEVEL_1);
        assertEquals(time, statistic.getRecordTime());
    }
}

