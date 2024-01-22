package it.unibo.model.entity.obstacles;

import java.awt.Color;
import java.awt.Graphics2D;

public class PlatformImpl implements Platform{

    private double x;
    private double y;
    private double width;
    private double height;

    public PlatformImpl(final double x, final double y, final double width, final double height){
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
    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillRect((int)this.x, (int)this.y, (int)this.width, (int)this.height);
    }
    
}
