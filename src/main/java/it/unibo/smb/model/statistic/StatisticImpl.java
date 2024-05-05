package it.unibo.smb.model.statistic;

import it.unibo.smb.controller.LevelType;

/**
 * Implementation of the Statistic representing game statistics for a specific level.
 */
public class StatisticImpl implements Statistic {
    private final LevelType level;
    private int deaths;
    private int recordTime;

    /**
     * Constructs a new StatisticImpl object for the specified level.
     *
     * @param level The level type associated with the statistics.
     */
    public StatisticImpl(final LevelType level) {
        this.level = level;
    }

    @Override
    public final void addDeaths() {
        this.deaths++;
    }

    @Override
    public final void updateRecord(final int time) {
        if (recordTime == 0 || time < this.recordTime) {
            this.recordTime = time;
        }
    }

    @Override
    public final int getDeaths() {
        return this.deaths;
    }

    @Override
    public final int getRecordTime() {
        return this.recordTime;
    }

    @Override
    public final LevelType getLevelName() {
        return this.level;
    }
}
