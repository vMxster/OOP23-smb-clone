package it.unibo.model.hitbox;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import it.unibo.commons.Point2D;

public interface Hitbox {
    void updatePosition(Point2D<Double, Double> newPosition);

    Rectangle getHitbox();

    void draw(Graphics2D g);
}
