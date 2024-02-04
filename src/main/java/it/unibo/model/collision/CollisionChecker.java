package it.unibo.model.collision;

public interface CollisionChecker {

    static enum CollisionState {GROUND, WALL, AIR, SAW, BANDAGE_GIRL, LEFT_BOUND, RIGHT_BOUND, UPPER_BOUND, FALL}

    void isColliding();

    CollisionState isInWindow();

    void updateMeatBoy();

    void moveMeatBoy(int k);

    void stopMovingMeatBoy(int k);

    CollisionState getState();
}
