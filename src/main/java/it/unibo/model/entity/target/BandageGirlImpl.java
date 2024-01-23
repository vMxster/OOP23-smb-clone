package it.unibo.model.entity.target;

import java.awt.Color;
import java.awt.Graphics2D;

import it.unibo.commons.Constants;
import it.unibo.model.entity.AbstractEntityImpl;
import it.unibo.model.hitbox.RectangleHitbox;
import it.unibo.model.hitbox.RectangleHitboxImpl;

public class BandageGirlImpl extends AbstractEntityImpl implements BandageGirl {

    private boolean touched = false;
    private RectangleHitbox hitbox;

    public BandageGirlImpl(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.hitbox = new RectangleHitboxImpl(x, y, Constants.MEATBOY_WIDTH, Constants.MEATBOY_HEIGHT);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.PINK);
        g.fillRect((int)this.x, (int)this.y, (int)this.width, (int)this.height);
        this.hitbox.draw(g);
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
