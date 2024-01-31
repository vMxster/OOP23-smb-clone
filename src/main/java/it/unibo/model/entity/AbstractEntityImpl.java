package it.unibo.model.entity;

import java.awt.Graphics2D;

public abstract class AbstractEntityImpl<T> implements Entity {

    protected double x;
    protected double y;
    protected double width;
    protected double height;
    protected T hitbox;

    public AbstractEntityImpl(final double x, final double y, final double width, final double height, final T hitbox) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.hitbox = hitbox;
    }

    @Override
    public abstract void draw(Graphics2D g);

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public double getWidth() {
        return this.width;
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
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }
    
}
