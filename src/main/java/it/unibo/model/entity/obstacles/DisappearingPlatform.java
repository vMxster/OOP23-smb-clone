package it.unibo.model.entity.obstacles;

import it.unibo.model.entity.Entity;

public interface DisappearingPlatform extends Entity{

    /**
     * @return a boolean if the platform is hit by the player.
     */
    boolean isTouched();

    /**
     * The platform is hit by the player.
     */
    void hit();

    /**
     * Updates the status of the platform.
     */
    void update();
}
