package it.unibo.model.entity.obstacles;

import it.unibo.model.entity.Entity;
import it.unibo.model.hitbox.RectangleHitbox;

public interface Platform extends Entity{

    RectangleHitbox getHitbox();
}
