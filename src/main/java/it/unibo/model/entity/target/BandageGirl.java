package it.unibo.model.entity.target;

import it.unibo.model.entity.Entity;
import it.unibo.model.hitbox.RectangleHitbox;

public interface BandageGirl extends Entity<RectangleHitbox> {
    
    /**
     * Meat boy touch bandage girl.
     */
    void touch();

    /**
     * @return true if she has been touched.
     */
    boolean isTouched();
}
