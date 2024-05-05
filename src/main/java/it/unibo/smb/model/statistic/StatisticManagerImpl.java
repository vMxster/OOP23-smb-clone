package it.unibo.smb.model.statistic;

import it.unibo.smb.controller.LevelType;
import it.unibo.smb.model.statistic.factory.StatisticFactoryImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the StatisticManager providing methods to manage game statistics.
 */
public class StatisticManagerImpl implements StatisticManager {

    private final List<Statistic> levelStatistics;

    /**
     * Constructs a new StatisticManagerImpl instance.
     * Initializes the list of level statistics and loads statistics for all levels.
     */
    public StatisticManagerImpl() {
        this.levelStatistics = new ArrayList<>();
        loadStats();
    }

    @Override
    public final Statistic whichLevel(final LevelType levelName) {
        for (final Statistic statistic : this.levelStatistics) {
            if (levelName.equals(statistic.getLevelName())) {
                return statistic;
            }
        }
        throw new IllegalArgumentException("Level's Statistics don't Exist");
    }

    @Override
    public final void addDeaths(final LevelType levelName) {
        for (final Statistic statistic : this.levelStatistics) {
            if (levelName.equals(statistic.getLevelName())) {
                statistic.addDeaths();
                return;
            }
        }
        throw new IllegalArgumentException("Level's Statistics don't Exist");
    }

    @Override
    public final void updateRecord(final int centiSeconds, final LevelType levelName) {
        for (final Statistic statistic : this.levelStatistics) {
            if (levelName.equals(statistic.getLevelName())) {
                statistic.updateRecord(centiSeconds);
                return;
            }
        }
        throw new IllegalArgumentException("Level's Statistics don't Exist");
    }

    /**
     * Loads statistics for all levels defined in the LevelType enumeration.
     * For each level, creates an instance of StatisticImpl and adds it to the game's statistics list.
     */
    private void loadStats() {
        for (final LevelType level : LevelType.values()) {
            this.levelStatistics.add(
                    new StatisticFactoryImpl()
                            .createStatistic(level));
        }
    }
}
