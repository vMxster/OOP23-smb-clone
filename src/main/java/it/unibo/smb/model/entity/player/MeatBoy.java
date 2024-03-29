package it.unibo.smb.model.entity.player;

import it.unibo.smb.model.entity.Entity;
import it.unibo.smb.model.hitbox.RectangleHitbox;

/**
 * Represents a specific type of entity in a game or simulation context, specifically a MeatBoy.
 * It extends the {@link Entity} interface, specifying a hitbox of type {@link RectangleHitbox}.
 */
public interface MeatBoy extends Entity<RectangleHitbox> {

    /**
     * Retrieves the speed multiplier associated with this entity.
     *
     * @return The speed multiplier value.
     */
    double getSpeedMul();

    /**
     * Sets the speed multiplier associated with this entity to the specified value.
     *
     * @param speedMul The new value for the speed multiplier.
     */
    void setSpeedMul(double speedMul);
}
