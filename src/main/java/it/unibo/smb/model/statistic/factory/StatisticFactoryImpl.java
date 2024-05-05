package it.unibo.smb.model.statistic.factory;

import it.unibo.smb.controller.LevelType;
import it.unibo.smb.model.statistic.Statistic;
import it.unibo.smb.model.statistic.StatisticImpl;

/**
 * An implementation of the StatisticFactory interface.
 */
public class StatisticFactoryImpl implements StatisticFactory {
    @Override
    public final Statistic createStatistic(final LevelType level) {
        return new StatisticImpl(level);
    }
}
