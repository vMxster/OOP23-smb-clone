package it.unibo.model.entity.target;

import java.awt.Color;
import java.awt.Graphics2D;

import it.unibo.model.entity.AbstractEntityImpl;

public class BandageGirlImpl extends AbstractEntityImpl implements BandageGirl {

    private boolean touched = false;

    public BandageGirlImpl(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.PINK);
        g.fillRect((int)this.x, (int)this.y, (int)this.width, (int)this.height);
    }

    @Override
    public boolean isTouched() {
        return this.touched;
    }

    @Override
    public void touch() {
        this.touched = true;
    }
    
}
