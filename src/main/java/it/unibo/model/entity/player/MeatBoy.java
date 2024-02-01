package it.unibo.model.entity.player;

import it.unibo.model.entity.Entity;
import it.unibo.model.hitbox.RectangleHitbox;


public interface MeatBoy extends Entity {

    static final double SPEED = 4;

    RectangleHitbox getHitbox();

    double getSpeedMul();

    void setSpeedMul(double speedMul);
}
