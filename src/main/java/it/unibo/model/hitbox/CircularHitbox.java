package it.unibo.model.hitbox;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public interface CircularHitbox {
    void updatePosition(double x, double y);

    Ellipse2D getHitbox();

    void draw(Graphics2D g);
}