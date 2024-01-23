package it.unibo.model.entity.player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import it.unibo.model.entity.AbstractEntityImpl;

public class MeatBoyImpl extends AbstractEntityImpl implements MeatBoy {

    private static final double SPEED = 4;

    private double speedMul;

    //moves
    private boolean moveLeft;
    private boolean moveRight;
    private boolean jump;

    public MeatBoyImpl(final double x, final double y, final double width, final double height) {
        super(x, y, width, height);
        this.speedMul = 1;
    }

    @Override
    public void update() {
        if (moveLeft && !moveRight) this.x -= SPEED * speedMul;
        if (!moveLeft && moveRight) this.x += SPEED * speedMul;
        if (jump) this.y -= 17;
        if (!this.isOnGround()) this.y += 7;
    }

    @Override
    public boolean isOnGround() {
        return this.y >= 500;
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

    public void move(int k) {
        switch (k) {
            case KeyEvent.VK_A:
                this.moveLeft = true;
                break;
            case KeyEvent.VK_D:
                this.moveRight = true;
                break;
            case KeyEvent.VK_SPACE:
                if (this.isOnGround()) {
                    this.jump = true;
                }
                break;
            case KeyEvent.VK_SHIFT:
                this.speedMul = 2;
                break;
            default:
                break;
        }
    }

    @Override
    public void stopMoving(int k) {
        switch (k) {
            case KeyEvent.VK_A:
                this.moveLeft = false;
                break;
            case KeyEvent.VK_D:
                this.moveRight = false;
                break;
            case KeyEvent.VK_SPACE:
                this.jump = false;
                break;
            case KeyEvent.VK_SHIFT:
                this.speedMul = 1;
                break;
            default:
                break;
        }
    }
}
