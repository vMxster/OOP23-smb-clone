package it.unibo.smb.controller.factory;

import it.unibo.smb.controller.GameController;
import it.unibo.smb.controller.GameControllerImpl;

/**
 * The GameControllerFactoryImpl class is an implementation of the GameControllerFactory interface.
 * It provides a concrete implementation of the factory method createGameController(), instantiating
 * GameController objects.
 */
public class GameControllerFactoryImpl implements GameControllerFactory {

    @Override
    public final GameController createGameController() {
        return new GameControllerImpl();
    }

}
