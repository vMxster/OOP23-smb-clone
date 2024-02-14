package it.unibo.controller.factory;

import it.unibo.controller.GameController;
import it.unibo.controller.GameControllerImpl;

public class GameControllerFactoryImpl implements GameControllerFactory {

    @Override
    public GameController createGameController() {
        return new GameControllerImpl();
    }

}
