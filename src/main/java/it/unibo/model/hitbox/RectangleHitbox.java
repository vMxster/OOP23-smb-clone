package it.unibo.model.hitbox;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import it.unibo.commons.Point2D;

public abstract class RectangleHitbox implements Hitbox{

    private final Rectangle hitbox;

    public RectangleHitbox(final double x, final double y, final double width, final double height) {
        super();
        this.hitbox = new Rectangle((int) x, (int) y, (int) width, (int) height);
    }

    @Override
    public void updatePosition(Point2D<Double, Double> newPosition) {
        this.hitbox.setLocation(newPosition.getX().intValue(), newPosition.getY().intValue());
    }

    @Override
    public Rectangle getHitbox() {
        return this.hitbox;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.PINK);
        g.draw(hitbox);
    }
}
