package it.unibo.smb.model.statistic.factory.manager;

import it.unibo.smb.model.statistic.StatisticManager;

/**
 * An interface for factories that create statistic managers.
 */
public interface StatisticManagerFactory {
    /**
     * Creates a statistic manager.
     *
     * @return A new instance of StatisticManager.
     */
    StatisticManager createStatisticManager();
}
