package it.unibo.model.statistic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for the Statistic class.
 */
class TestStatistic {
    
    private Statistic statistic;

    /** assertEquals(30, statistic.getRecordTime());
     * Initializes the statistic before each test.
     */
    @BeforeEach
    void init() {
        this.statistic = new StatisticImpl();
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
        this.statistic.updateRecord(30);
        this.statistic.updateRecord(60);
        assertEquals(30, statistic.getRecordTime());
        this.statistic.updateRecord(15);
        assertEquals(15, statistic.getRecordTime());
    }
}
