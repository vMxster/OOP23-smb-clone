package it.unibo.smb.model.entity.obstacles;

import it.unibo.smb.model.entity.Entity;
import it.unibo.smb.model.hitbox.RectangleHitbox;

/**
 * The LavaPool interface represents a pool filled with lava in the game level.
 * It extends the Entity interface with a RectangleHitbox specific to lava pools.
 */
public interface LavaPool extends Entity<RectangleHitbox> {
}
