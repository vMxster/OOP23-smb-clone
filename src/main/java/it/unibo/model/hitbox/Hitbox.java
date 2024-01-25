package it.unibo.model.hitbox;

import java.awt.Graphics2D;

public interface Hitbox<T> {
    void updatePosition(double x, double y);

    T getHitbox();

    void draw(Graphics2D g);
}
