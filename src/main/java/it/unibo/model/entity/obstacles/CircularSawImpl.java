package it.unibo.model.entity.obstacles;

import it.unibo.model.hitbox.CircularHitbox;
import it.unibo.model.entity.EntityImpl;

public class CircularSawImpl extends EntityImpl<CircularHitbox> implements CircularSaw{

    public CircularSawImpl(final double x, final double y, final int radius) {
        super(x, y, new CircularHitbox(x, y, radius));
    }
}
