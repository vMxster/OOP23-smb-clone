package it.unibo.model.entity.player;

import it.unibo.model.entity.Entity;
import it.unibo.model.hitbox.RectangleHitbox;

public interface MeatBoy extends Entity<RectangleHitbox> {


    double getSpeedMul();

    

    void setSpeedMul(double speedMul);
}
