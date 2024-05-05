package it.unibo.smb.model.statistic;

import it.unibo.smb.controller.LevelType;

/**
 * The Statistic represents the total number of death
 * and the time record of the player.
 */
public interface Statistic {

    /**
     * Add a death every time the player die.
     */
    void addDeaths();

    /**
     * Update the time record every time the player 
     * makes a better time. 
     * @param time the new time made by the player.
     */
    void updateRecord(int time);

    /**
     * Returns the total number of deaths.
     * 
     * @return total number of deaths.
     */
    int getDeaths();

    /**
     * Returns the best time record.
     * 
     * @return the best time record.
     */
    int getRecordTime();

    /**
     * Retrieves the level type associated with the current statistic.
     *
     * @return The level type of the statistic, indicating the environment and level number.
     */
    LevelType getLevelName();
}
