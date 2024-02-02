package it.unibo.model.entity.player;

import java.awt.Color;
import java.awt.Graphics2D;

import it.unibo.commons.Constants;
import it.unibo.model.entity.AbstractEntityImpl;
import it.unibo.model.hitbox.RectangleHitbox;

public class MeatBoyImpl extends AbstractEntityImpl<RectangleHitbox> implements MeatBoy {

    private double speedMul;

    public MeatBoyImpl(final double x, final double y, final double width, final double height) {
        super(x, y, width, height, new RectangleHitbox(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE)); 
        this.speedMul = 1;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect((int)this.x, (int)this.y, (int)this.width, (int)this.height);
        //this.hitbox.draw(g);
    }

    @Override
    public RectangleHitbox getHitbox() {
        return this.hitbox;
    }

    @Override
    public double getSpeedMul() {
        return speedMul;
    }

    @Override
    public void setSpeedMul(double speedMul) {
        this.speedMul = speedMul;
    }
}
