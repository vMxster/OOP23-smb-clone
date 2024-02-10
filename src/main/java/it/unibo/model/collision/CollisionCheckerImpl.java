package it.unibo.model.collision;

import java.util.List;

import it.unibo.commons.Constants;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.hitbox.CircularHitbox;
import it.unibo.model.hitbox.RectangleHitbox;

import java.awt.event.KeyEvent;

public class CollisionCheckerImpl implements CollisionChecker{

    private List<CircularHitbox> sawsHitboxs;
    private List<RectangleHitbox> platformsHitboxs;
    private RectangleHitbox bandageGirlHitbox;
    private MeatBoy meatBoy;

    private CollisionHandler collisionHandler;

    private boolean moveLeft;
    private boolean moveRight;
    private boolean jump;

    private boolean leftBound;
    private boolean rightBound;
    private boolean upperBound;

    private CollisionState state;
    private int jumpHeight;

    public CollisionCheckerImpl(CollisionHandler collisionHandler) {
        this.collisionHandler = collisionHandler;
        this.sawsHitboxs = this.collisionHandler.getGameModel().getSaws().stream().map(t -> t.getHitbox()).toList();
        this.platformsHitboxs = this.collisionHandler.getGameModel().getPlatforms().stream().map(t -> t.getHitbox()).toList();
        this.bandageGirlHitbox = this.collisionHandler.getGameModel().getBandageGirl().getHitbox();
        this.meatBoy = this.collisionHandler.getGameModel().getMeatBoy();
    }

    @Override
    public void isColliding() {
        if (this.platformsHitboxs.stream()
                .map(h -> h.getHitbox())
                .filter(h -> h.intersects(meatBoy.getHitbox().getHitbox()))
                .count() > 0) {
            state = CollisionState.GROUND;
        } else state = CollisionState.AIR;
        if (this.sawsHitboxs.stream()
                .map(h -> h.getHitbox())
                .filter(h -> h.intersects(meatBoy.getHitbox().getHitbox()))
                .count() > 0) {
            state = CollisionState.SAW;
        }
        if (this.bandageGirlHitbox.getHitbox().intersects(meatBoy.getHitbox().getHitbox())) {
            state = CollisionState.BANDAGE_GIRL;
        }
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
            isColliding();
            if (state == CollisionState.GROUND) {
                state = CollisionState.WALL;
                this.meatBoy.setX(this.meatBoy.getX() + MeatBoy.SPEED * this.meatBoy.getSpeedMul());
            }
        }
        //right
        if (!moveLeft && moveRight && !rightBound) {
            this.meatBoy.setX(this.meatBoy.getX() + MeatBoy.SPEED * this.meatBoy.getSpeedMul());
            isColliding();
            if (state == CollisionState.GROUND) {
                state = CollisionState.WALL;
                this.meatBoy.setX(this.meatBoy.getX() - MeatBoy.SPEED * this.meatBoy.getSpeedMul());
            }
        }
        //up
        if (jump && !upperBound && jumpHeight < 200) {
            this.meatBoy.setY(this.meatBoy.getY() - 10);
            isColliding();
            if (state == CollisionState.GROUND) {
                this.meatBoy.setY(this.meatBoy.getY() + 10);
            }
            jumpHeight += 10;
          //fall
        } else if (state == CollisionState.AIR || state == CollisionState.WALL) {
            if (state == CollisionState.AIR) {
                this.meatBoy.setY(this.meatBoy.getY() + 5);
                isColliding();
                if (state == CollisionState.GROUND) {
                    this.meatBoy.setY(this.meatBoy.getY() - 5);
                    jumpHeight = 0; 
                }
            } else {
                this.meatBoy.setY(this.meatBoy.getY() + 5);
                if(moveRight) this.meatBoy.setX(this.meatBoy.getX() + 1);
                else if (moveLeft) this.meatBoy.setX(this.meatBoy.getX() - 1);
                isColliding();
                if (state == CollisionState.GROUND) {
                    state = CollisionState.WALL;
                    if(moveRight) this.meatBoy.setX(this.meatBoy.getX() - 1);
                    else if (moveLeft) this.meatBoy.setX(this.meatBoy.getX() + 1);
                    jumpHeight = 0;
                }
            }
        }
        System.out.println(state);
    }

    @Override
    public void moveMeatBoy(int k) {
        switch (k) {
            case KeyEvent.VK_A -> this.moveLeft = true;
            case KeyEvent.VK_D -> this.moveRight = true;
            case KeyEvent.VK_SPACE -> {
                if (state != CollisionState.AIR) {
                    this.jump = true;
                }
            }
            case KeyEvent.VK_SHIFT -> this.meatBoy.setSpeedMul(2);
            default -> { }
        }
    }

    @Override
    public void stopMovingMeatBoy(int k) {
        switch (k) {
            case KeyEvent.VK_A -> this.moveLeft = false;
            case KeyEvent.VK_D -> this.moveRight = false;
            case KeyEvent.VK_SPACE -> this.jump = false;
            case KeyEvent.VK_SHIFT -> this.meatBoy.setSpeedMul(1);
            default -> { }
        }
    }

    @Override
    public CollisionState getState() {
        return state;
    }

    
}
