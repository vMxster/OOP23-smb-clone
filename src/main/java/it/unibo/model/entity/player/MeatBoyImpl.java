package it.unibo.model.entity.player;

import java.awt.Color;
import java.awt.Graphics2D;

public class MeatBoyImpl implements MeatBoy {

    private double x;
    private double y;
    private double width;
    private double height;

    public MeatBoyImpl(final double x, final double y, final double width, final double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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
    public void update(final double delta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean isOnGround() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isOnGround'");
    }

    @Override
    public boolean isTouchingSide() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isTouchingSide'");
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect((int)this.x, (int)this.y, (int)this.width, (int)this.height);
    }

}
