package it.unibo.model.collision;

import it.unibo.model.GameModel;

public class CollisionHandlerImpl implements CollisionHandler {
    private CollisionChecker collisionChecker;
    private GameModel gameModel;

    public CollisionHandlerImpl(GameModel gameModel) {
        this.gameModel = gameModel;
        this.collisionChecker = new CollisionCheckerImpl(this);
    }

    @Override
    public GameModel getGameModel() {
        return this.gameModel;
    }

    @Override
    public void check() {
        if (collisionChecker.isInWindow() == CollisionChecker.CollisionState.FALL) {
            try {
                Thread.sleep(500);
                System.exit(0);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else {
            if (collisionChecker.getState() == (CollisionChecker.CollisionState.SAW)) {
                System.out.println("HAI PERSO");
            } else if (collisionChecker.getState() == (CollisionChecker.CollisionState.BANDAGE_GIRL)) {
                System.out.println("HAI VINTO");
            }  
        }
    }

    @Override
    public void moveMeatBoy(int keyCode) {
        this.collisionChecker.moveMeatBoy(keyCode);
    }

    @Override
    public void stopMovingMeatBoy(int keyCode) {
        this.collisionChecker.stopMovingMeatBoy(keyCode);
    }

    @Override
    public void updateMeatBoy() {
        this.collisionChecker.updateMeatBoy();
    }
}
