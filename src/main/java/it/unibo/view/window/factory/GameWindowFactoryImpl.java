package it.unibo.view.window.factory;

import it.unibo.controller.GameController;
import it.unibo.view.window.GameWindow;
import it.unibo.view.window.swing.GameWindowSwing;

/**
 * The GameWindowFactoryImpl class implements the GameWindowFactory interface
 * and provides methods to create instances of GameWindow.
 */
public class GameWindowFactoryImpl implements GameWindowFactory {

    /**
     * Creates a Swing-based GameWindow instance.
     *
     * @param controller The GameController associated with the window.
     * @return A GameWindowSwing instance.
     */
    @Override
    public GameWindow createSwingGameWindow(final GameController controller) {
        return new GameWindowSwing(controller);
    }

}
