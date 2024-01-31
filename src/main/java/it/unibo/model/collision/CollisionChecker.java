package it.unibo.model.collision;

import it.unibo.model.hitbox.RectangleHitbox;


public interface CollisionChecker {

    static enum CollisionState {GROUND, WALL, SAW, BANDAGE_GIRL}

    CollisionState isColliding(RectangleHitbox mbHitbox);
}
