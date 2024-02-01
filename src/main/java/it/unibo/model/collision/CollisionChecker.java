package it.unibo.model.collision;

public interface CollisionChecker {

    static enum CollisionState {GROUND, WALL, SAW, BANDAGE_GIRL}

    CollisionState isColliding();

    void updateMeatBoy();

    void moveMeatBoy(int k);

    void stopMovingMeatBoy(int k);
}
