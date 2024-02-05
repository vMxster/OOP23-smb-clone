package it.unibo.view.window.factory;

import it.unibo.controller.GameController;
import it.unibo.view.window.GameWindow;
import it.unibo.view.window.GameWindowSwing;

public class GameWindowFactoryImpl implements GameWindowFactory {

    @Override
    public GameWindow createSwingGameWindow(final GameController controller) {
        return new GameWindowSwing(controller);
    }
    
}
