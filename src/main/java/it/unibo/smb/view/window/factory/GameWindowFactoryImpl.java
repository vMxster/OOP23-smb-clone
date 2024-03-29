package it.unibo.smb.view.window.factory;

import it.unibo.smb.controller.GameController;
import it.unibo.smb.view.window.GameWindow;
import it.unibo.smb.view.window.GameWindowSwing;

/**
 * The GameWindowFactoryImpl class implements the GameWindowFactory interface
 * and provides methods to create instances of GameWindow.
 */
public class GameWindowFactoryImpl implements GameWindowFactory {

    @Override
    public final GameWindow createSwingGameWindow(final GameController controller) {
        return new GameWindowSwing(controller);
    }

}
