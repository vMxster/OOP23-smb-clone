package it.unibo.smb.model.statistic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import it.unibo.smb.controller.LevelType;
import it.unibo.smb.model.statistic.factory.StatisticFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for the Statistic class.
 */
class TestStatistic {

    private static final int TIME = 30;
    private Statistic statistic;

    /**
     * Initializes the statistic before each test.
     */
    @BeforeEach
    void init() {
        this.statistic = new StatisticFactoryImpl()
                .createStatistic(LevelType.FACTORY_LEVEL_1);
        assertNotNull(this.statistic);
    }

    /**
     * Test the Deaths counter update.
     */
    @Test
    void testDeathCounter() {
        assertEquals(0, statistic.getDeaths());
        this.statistic.addDeaths();
        assertEquals(1, statistic.getDeaths());
        this.statistic.addDeaths();
        this.statistic.addDeaths();
        assertEquals(3, statistic.getDeaths());
    }

    /**
     * Test the Record update.
     */
    @Test
    void testRecordUpdate() {
        assertEquals(0, statistic.getRecordTime());
        this.statistic.updateRecord(TIME);
        this.statistic.updateRecord(TIME * 2);
        assertEquals(TIME, statistic.getRecordTime());
        this.statistic.updateRecord(TIME / 2);
        assertEquals(TIME / 2, statistic.getRecordTime());
    }
}
