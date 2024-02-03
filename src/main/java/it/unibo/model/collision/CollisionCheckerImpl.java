package it.unibo.model.collision;

import java.util.List;

import it.unibo.commons.Constants;
import it.unibo.model.GameModel;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.hitbox.CircularHitbox;
import it.unibo.model.hitbox.RectangleHitbox;

import java.awt.event.KeyEvent;

public class CollisionCheckerImpl implements CollisionChecker{

    private List<CircularHitbox> sawsHitboxs;
    private List<RectangleHitbox> platformsHitboxs;
    private RectangleHitbox bandageGirlHitbox;
    private MeatBoy meatBoy;

    private boolean moveLeft;
    private boolean moveRight;
    private boolean jump;

    private boolean leftBound;
    private boolean rightBound;
    private boolean upperBound;

    public CollisionCheckerImpl(GameModel gameModel) {
        this.sawsHitboxs = gameModel.getSaws().stream().map(t -> t.getHitbox()).toList();
        this.platformsHitboxs = gameModel.getPlatforms().stream().map(t -> t.getHitbox()).toList();
        this.bandageGirlHitbox = gameModel.getBandageGirl().getHitbox();
        this.meatBoy = gameModel.getMeatBoy();
    }

    @Override
    public CollisionState isColliding() {
        CollisionState state = null;
        if (this.platformsHitboxs.stream()
                .map(h -> h.getHitbox())
                .filter(h -> h.intersects(meatBoy.getHitbox().getHitbox()))
                .count() > 0) {
            state = CollisionState.GROUND;
        }
        if (this.sawsHitboxs.stream()
                .map(h -> h.getHitbox())
                .filter(h -> h.intersects(meatBoy.getHitbox().getHitbox()))
                .count() > 0) {
            state = CollisionState.SAW;
        }
        if (this.bandageGirlHitbox.getHitbox().intersects(meatBoy.getHitbox().getHitbox())) {
            state = CollisionState.BANDAGE_GIRL;
        } 
        return state;
    }

    @Override
    public CollisionState isInWindow() {
        if (this.meatBoy.getX() < 0) leftBound = true;
        else leftBound = false;
        if (this.meatBoy.getX() + Constants.TILE_SIZE > Constants.SW - Constants.TILE_SIZE) rightBound = true;
        else rightBound = false;
        if (this.meatBoy.getY() < 0) upperBound = true;
        else upperBound = false;    
        return (this.meatBoy.getY() > Constants.SH) ? CollisionState.FALL : null;
    }

    @Override
    public void updateMeatBoy() {
        //left
        if (moveLeft && !moveRight && !leftBound) {
            this.meatBoy.setX(this.meatBoy.getX() - MeatBoy.SPEED * this.meatBoy.getSpeedMul());
            this.meatBoy.getHitbox().updatePosition(this.meatBoy.getX(), this.meatBoy.getY());
            if (isColliding() == CollisionState.GROUND) {
                this.meatBoy.setX(this.meatBoy.getX() + MeatBoy.SPEED * this.meatBoy.getSpeedMul());
            }
        }
        //right
        if (!moveLeft && moveRight && !rightBound) {
            this.meatBoy.setX(this.meatBoy.getX() + MeatBoy.SPEED * this.meatBoy.getSpeedMul());
            this.meatBoy.getHitbox().updatePosition(this.meatBoy.getX(), this.meatBoy.getY());
            if (isColliding() == CollisionState.GROUND) {
                this.meatBoy.setX(this.meatBoy.getX() - MeatBoy.SPEED * this.meatBoy.getSpeedMul());
            }
        }
        //up
        if (jump && !upperBound) {
            this.meatBoy.setY(this.meatBoy.getY() - 10);
            this.meatBoy.getHitbox().updatePosition(this.meatBoy.getX(), this.meatBoy.getY());
            if (isColliding() == CollisionState.GROUND) {
                this.meatBoy.setY(this.meatBoy.getY() + 10);
            }
        }
        //fall
        if (!jump && this.isColliding() != CollisionState.GROUND) {
            this.meatBoy.setY(this.meatBoy.getY() + 10);
            this.meatBoy.getHitbox().updatePosition(this.meatBoy.getX(), this.meatBoy.getY());
            if (isColliding() == CollisionState.GROUND) {
                this.meatBoy.setY(this.meatBoy.getY() - 10);
            }
        }
        this.meatBoy.getHitbox().updatePosition(this.meatBoy.getX(), this.meatBoy.getY());
    }

    @Override
    public void moveMeatBoy(int k) {
        switch (k) {
            case KeyEvent.VK_A:
                this.moveLeft = true;
                break;
            case KeyEvent.VK_D:
                this.moveRight = true;
                break;
            case KeyEvent.VK_SPACE:
                this.jump = true;
                break;
            case KeyEvent.VK_SHIFT:
                this.meatBoy.setSpeedMul(2);
                break;
            default:
                break;
        }
    }

    @Override
    public void stopMovingMeatBoy(int k) {
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
                this.meatBoy.setSpeedMul(1);
                break;
            default:
                break;
        }
    }

    
}
