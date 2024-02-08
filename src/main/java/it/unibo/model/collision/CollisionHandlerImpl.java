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
            gameModel.getMeatBoy().setX(gameModel.getMeatBoyStartCoord().getX());
            gameModel.getMeatBoy().setY(gameModel.getMeatBoyStartCoord().getY());
        } else {
            if (collisionChecker.getState() == (CollisionChecker.CollisionState.SAW)) {
                gameModel.getMeatBoy().setX(gameModel.getMeatBoyStartCoord().getX());
                gameModel.getMeatBoy().setY(gameModel.getMeatBoyStartCoord().getY());
            } else if (collisionChecker.getState() == (CollisionChecker.CollisionState.BANDAGE_GIRL)) {
                //gameWindow.displayVictoryMessage();
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
