package it.unibo.model.entity.obstacles;

import java.awt.Color;
import java.awt.Graphics2D;

import it.unibo.model.hitbox.CircularHitbox;
import it.unibo.model.hitbox.CircularHitboxImpl;

public class CircularSawImpl implements CircularSaw{

    private double x;
    private double y;
    private double width;
    private double height;
    private double radius;

    private CircularHitbox hitbox;

    public CircularSawImpl(final double x, final double y, final double width, final double height, final double radius) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.radius = radius;
        this.hitbox = new CircularHitboxImpl(x, y, radius);
    }

    @Override
    public double getX() {
        return this.x; 
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillOval((int)this.x, (int)this.y, (int)this.width, (int)this.height);
        this.hitbox.draw(g);
    }

    @Override
    public double getRadius() {
        return this.radius;
    }
    
}
