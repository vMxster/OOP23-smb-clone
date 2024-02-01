package it.unibo.model.entity.player;

import it.unibo.model.entity.Entity;
import it.unibo.model.hitbox.RectangleHitbox;

public interface MeatBoy extends Entity<RectangleHitbox> {

    /**
     * @return true if the player is touching ground, false otherwise.
     */
    boolean isOnGround();

    /**
     * @return true if the player is touching something on his side, false otherwise.
     */
    boolean isTouchingSide();

    /**
     * Updates the status.
     */
    void update();

    /**
     * Moves meat boy.
     * @param i the integer code for an actual key on the keyboard.
     */
    void move(int i);

    /**
     * Stop moving meat boy.
     * @param i the integer code for an actual key on the keyboard.
     */
    void stopMoving(int i);

    RectangleHitbox getHitbox();
}
