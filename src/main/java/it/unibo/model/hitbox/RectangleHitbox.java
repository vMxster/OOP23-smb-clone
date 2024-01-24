package it.unibo.model.hitbox;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RectangleHitbox<T extends Rectangle> implements Hitbox<T> {

    private final T hitbox;

    public RectangleHitbox(final double x, final double y, final double width, final double height) {
        this.hitbox = (T) new Rectangle((int) x, (int) y, (int) width, (int) height);
    }

    @Override
    public void updatePosition(double x, double y) {
        this.hitbox.setLocation((int) x, (int) y);
    }

    public T getHitbox() {
        return this.hitbox;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.MAGENTA);
        g.draw(hitbox);
    }
}
