package it.unibo.model.hitbox;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RectangleHitbox implements Hitbox<Rectangle> {

    private final Rectangle hitbox;

    public RectangleHitbox(final double x, final double y, final int width, final int height) {
        this.hitbox = new Rectangle((int) x, (int) y, width, height);
    }

    @Override
    public void updatePosition(double x, double y) {
        this.hitbox.setLocation((int) x, (int) y);
    }

    public Rectangle getHitbox() {
        return this.hitbox;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.MAGENTA);
        g.draw(hitbox);
    }
}
