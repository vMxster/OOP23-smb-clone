package it.unibo.model.collision;

public interface CollisionChecker {

    static enum CollisionState {GROUND, WALL, SAW, BANDAGE_GIRL, LEFT_BOUND, RIGHT_BOUND, UPPER_BOUND, FALL}

    CollisionState isColliding();

    CollisionState isInWindow();

    void updateMeatBoy();

    void moveMeatBoy(int k);

    void stopMovingMeatBoy(int k);
}
