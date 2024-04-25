package it.unibo.smb.model.entity.obstacles;

import it.unibo.smb.model.entity.Entity;
import it.unibo.smb.model.hitbox.RectangleHitbox;

/**
 * The LaserBarrier interface represents a barrier made of laser in the game level.
 * It extends the Entity interface with a RectangleHitbox specific to LaserBarriers.
 */
public interface LaserBarrier extends Entity<RectangleHitbox> {
}
