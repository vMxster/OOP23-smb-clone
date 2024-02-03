package it.unibo.model.entity.player;

import it.unibo.commons.Constants;
import it.unibo.model.entity.EntityImpl;
import it.unibo.model.hitbox.RectangleHitbox;

public class MeatBoyImpl extends EntityImpl<RectangleHitbox> implements MeatBoy {

    private double speedMul;

    public MeatBoyImpl(final double x, final double y) {
        super(x, y, new RectangleHitbox(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE)); 
        this.speedMul = 1;
    }

    @Override
    public RectangleHitbox getHitbox() {
        return this.hitbox;
    }

    @Override
    public double getSpeedMul() {
        return this.speedMul;
    }

    @Override
    public void setSpeedMul(final double speedMul) {
        this.speedMul = speedMul;
    }
}
