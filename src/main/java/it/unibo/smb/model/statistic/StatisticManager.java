package it.unibo.smb.model.statistic;

import it.unibo.smb.controller.LevelType;

/**
 * The StatisticManager interface provides methods to manage statistics related to game levels.
 */
public interface StatisticManager {

    /**
     * Retrieves the statistics for the specified level.
     *
     * @param levelName The type of level for which statistics are requested.
     * @return The statistics for the specified level.
     */
    Statistic whichLevel(LevelType levelName);

    /**
     * Increments the death count for the specified level.
     *
     * @param levelName The type of level for which the death count will be incremented.
     */
    void addDeaths(LevelType levelName);

    /**
     * Updates the record for the specified level if the provided time is better.
     *
     * @param centiSeconds The time in centiseconds to be compared with the current record.
     * @param levelName    The type of level for which the record will be updated.
     */
    void updateRecord(int centiSeconds, LevelType levelName);
}

