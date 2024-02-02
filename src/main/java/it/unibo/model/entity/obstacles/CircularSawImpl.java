package it.unibo.model.entity.obstacles;

import java.awt.Color;
import java.awt.Graphics2D;

import it.unibo.model.hitbox.CircularHitbox;
import it.unibo.model.entity.AbstractEntityImpl;

public class CircularSawImpl extends AbstractEntityImpl<CircularHitbox> implements CircularSaw{

    public CircularSawImpl(final double x, final double y, final double radius) {
        super(x, y, radius, radius, new CircularHitbox(x, y, radius));
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillOval((int)this.x, (int)this.y, (int)this.width, (int)this.height);
        this.hitbox.draw(g);
    }

    @Override
    public double getRadius() {
        return this.hitbox.getHitbox().getWidth();
    }
}
