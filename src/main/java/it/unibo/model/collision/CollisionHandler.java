package it.unibo.model.collision;

import it.unibo.model.GameModel;

public interface CollisionHandler {

    GameModel getGameModel();
    
    void check();

    void moveMeatBoy(int keyCode);

    void stopMovingMeatBoy(int keyCode);

    void updateMeatBoy();
}
