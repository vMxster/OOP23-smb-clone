package it.unibo.smb.model.statistic.factory.manager;

import it.unibo.smb.model.statistic.StatisticManager;
import it.unibo.smb.model.statistic.StatisticManagerImpl;

/**
 * An implementation of the StatisticManagerFactory interface.
 */
public class StatisticManagerFactoryImpl implements StatisticManagerFactory {
    @Override
    public final StatisticManager createStatisticManager() {
        return new StatisticManagerImpl();
    }
}
