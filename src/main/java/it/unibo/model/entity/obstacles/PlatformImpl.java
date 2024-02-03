package it.unibo.model.entity.obstacles;

import it.unibo.model.entity.EntityImpl;
import it.unibo.model.hitbox.RectangleHitbox;

public class PlatformImpl extends EntityImpl<RectangleHitbox> implements Platform{

    public PlatformImpl(final double x, final double y, final int width, final int height){
        super(x, y, new RectangleHitbox(x, y, width, height));
    }
}
