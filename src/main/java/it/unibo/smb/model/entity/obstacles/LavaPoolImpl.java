package it.unibo.smb.model.entity.obstacles;

import it.unibo.smb.model.entity.EntityImpl;
import it.unibo.smb.model.hitbox.RectangleHitbox;

/**
 * The LavaPoolImpl class represents a pool filled with lava in the game level.
 * It extends EntityImpl<RectangleHitbox> and provides the implementation for a lava pool entity.
 */
public class LavaPoolImpl extends EntityImpl<RectangleHitbox> implements LavaPool {

    /**
     * Constructs a new instance of LavaPoolImpl.
     *
     * @param x      the x coordinate of the top-left corner of the lava pool.
     * @param y      the y coordinate of the top-left corner of the lava pool.
     * @param width  the width of the lava pool.
     * @param height the height of the lava pool.
     */
    public LavaPoolImpl(final double x, final double y, final int width, final int height) {
        super(x, y, new RectangleHitbox(x, y, width, height));
    }
}
