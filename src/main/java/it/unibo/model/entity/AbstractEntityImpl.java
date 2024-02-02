package it.unibo.model.entity;

import java.awt.Graphics2D;

import it.unibo.model.hitbox.Hitbox;

public abstract class AbstractEntityImpl<H extends Hitbox<?>> implements Entity<H> {

    protected double x;
    protected double y;
    protected double width;
    protected double height;
    protected H hitbox;

    
    public AbstractEntityImpl(final double x, final double y, final double width, final double height, final H hitbox) {
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
        this.hitbox.updatePosition(x, this.y);
        this.x = x;
    }
    
    @Override
    public void setY(double y) {
        this.hitbox.updatePosition(this.x, y);
        this.y = y;
    }

    @Override
    public H getHitbox() {
        return this.hitbox;
    }
}
