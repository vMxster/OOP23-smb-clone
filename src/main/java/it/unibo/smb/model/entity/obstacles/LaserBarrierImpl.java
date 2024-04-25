package it.unibo.smb.model.entity.obstacles;

import it.unibo.smb.model.entity.EntityImpl;
import it.unibo.smb.model.hitbox.RectangleHitbox;

/**
 * The LaserBarrier class represents a barrier made of laser in the game level.
 * It extends EntityImpl<RectangleHitbox> and provides the implementation for a Laser Barrier entity.
 */
public class LaserBarrierImpl extends EntityImpl<RectangleHitbox> implements LaserBarrier {

    /**
     * Constructs a new instance of LaserBarrierImpl.
     *
     * @param x      the x coordinate of the top-left corner of the laser barrier.
     * @param y      the y coordinate of the top-left corner of the laser barrier.
     * @param width  the width of the laser barrier.
     * @param height the height of the laser barrier.
     */
    public LaserBarrierImpl(final double x, final double y, final int width, final int height) {
        super(x, y, new RectangleHitbox(x, y, width, height));
    }
}
