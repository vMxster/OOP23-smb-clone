package it.unibo.model.entity.obstacles;

import java.awt.Color;
import java.awt.Graphics2D;

import it.unibo.model.entity.AbstractEntityImpl;

public class DisappearingPlatformImpl extends AbstractEntityImpl implements DisappearingPlatform{
    private boolean touched;

    public DisappearingPlatformImpl(double x, double y, double width, double height, final boolean touched) {
        super(x, y, width, height);
        this.touched = touched;
    }

    @Override
    public boolean isTouched() {
        return this.touched;
    }

    @Override
    public void hit() {
        this.touched = true;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.fillRect((int)this.x, (int)this.y, (int)this.width, (int)this.height);
    }
    
}
