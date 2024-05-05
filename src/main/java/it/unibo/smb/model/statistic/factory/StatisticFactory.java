package it.unibo.smb.model.statistic.factory;

import it.unibo.smb.controller.LevelType;
import it.unibo.smb.model.statistic.Statistic;

/**
 * An interface for factories that create statistics objects.
 */
public interface StatisticFactory {
    /**
     * Creates a statistic object for the specified level type.
     *
     * @param level The level type for which the statistic is being created.
     * @return A new instance of Statistic.
     */
    Statistic createStatistic(LevelType level);
}
