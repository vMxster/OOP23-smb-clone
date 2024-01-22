package it.unibo.model.entity.player;

import it.unibo.model.entity.Entity;

public interface MeatBoy extends Entity {

    /**
     * 
     * @return true if the player is touching ground, false otherwise.
     */
    boolean isOnGround();

    /**
     * 
     * @return true if the player is touching something on his side, false otherwise.
     */
    boolean isTouchingSide();

    /**
     * Moves meat boy
     * 
     * @param i the integer code for an actual key on the keyboard.
     */
    void move(int i);

    /**
     * Stop moving meat boy
     * 
     * @param i the integer code for an actual key on the keyboard.
     */
    void stopMoving(int i);
}
