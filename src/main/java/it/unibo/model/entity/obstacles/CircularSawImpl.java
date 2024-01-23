package it.unibo.model.entity.obstacles;

import java.awt.Color;
import java.awt.Graphics2D;

import it.unibo.model.entity.AbstractEntityImpl;

public class CircularSawImpl extends AbstractEntityImpl implements CircularSaw{

    private double radius;

    public CircularSawImpl(final double x, final double y, final double width, final double height, final double radius) {
        super(x, y, width, height);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillOval((int)this.x, (int)this.y, (int)this.width, (int)this.height);
    }

    @Override
    public double getRadius() {
        return this.radius;
    }
    
}
