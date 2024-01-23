package it.unibo.model.level;

/**
 *  Interface that reads a tmx file and creates a level from it
 */
public interface Level {

    /**
     *  Updates the status of all current entities and obstacles in the level.
     */
    void update();

}
