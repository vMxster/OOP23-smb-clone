package it.unibo.model.hitbox;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class CircularHitbox<T extends Ellipse2D> implements Hitbox<T> {

    private T hitbox;
    private final double radius;

    @SuppressWarnings("unchecked")
    public CircularHitbox(final double x, final double y, final double radius) {
        this.hitbox = (T) new Ellipse2D.Double(x, y, radius, radius);
        this.radius = radius;
    }

    @Override
    public void updatePosition(double x, double y) {
        this.hitbox.setFrame(x, y, radius, radius);
    }

    @Override
    public T getHitbox() {
        return this.hitbox;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.MAGENTA);
        g.draw(hitbox);
    }

    
}
