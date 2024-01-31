package it.unibo.model.hitbox;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class CircularHitbox implements Hitbox<Ellipse2D> {

    private final Ellipse2D hitbox;
    
    public CircularHitbox(final double x, final double y, final double radius) {
        this.hitbox = new Ellipse2D.Double(x, y, radius, radius);
    }

    @Override
    public void updatePosition(double x, double y) {
        this.hitbox.setFrame(x, y, hitbox.getWidth(), hitbox.getHeight());
    }

    @Override
    public Ellipse2D getHitbox() {
        return this.hitbox;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.MAGENTA);
        g.draw(hitbox);
    }

    
}
