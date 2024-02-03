package it.unibo.model.entity;

import it.unibo.model.hitbox.Hitbox;

public class EntityImpl<H extends Hitbox<?>> implements Entity<H> {

    protected double x;
    protected double y;
    protected H hitbox;

    public EntityImpl(final double x, final double y, final H hitbox) {
        this.x = x;
        this.y = y;
        this.hitbox = hitbox;
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
    public H getHitbox() {
        return this.hitbox;
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
}
