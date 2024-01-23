package it.unibo.model.hitbox;

import java.awt.Graphics2D;
import java.awt.Rectangle;


public interface RectangleHitbox {
    void updatePosition(double x, double y);

    Rectangle getHitbox();

    void draw(Graphics2D g);
}
