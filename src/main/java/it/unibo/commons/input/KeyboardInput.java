package it.unibo.commons.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import it.unibo.view.panel.GamePanel;

/**
 * This class represents a keyboard input handler that extends the KeyAdapter class.
 * It provides methods to handle keyboard input events.
 */
public class KeyboardInput extends KeyAdapter {

    private GamePanel panel;

    /**
     * Constructs a KeyboardInput object with the specified GamePanel.
     * 
     * @param panel The GamePanel to which this keyboard input handler is associated.
     */
    public KeyboardInput(final GamePanel panel) {
        this.panel = panel;
    }

    /**
     * Invoked when a key is pressed while the associated component has focus.
     * 
     * @param e The KeyEvent object containing information about the key press event.
     */
    @Override
    public void keyPressed(final KeyEvent e) {
        this.panel.keyPressed(e);
    }

    /**
     * Invoked when a key is released while the associated component has focus.
     *
     * @param e The KeyEvent object containing information about the key release event.
     */
    @Override
    public void keyReleased(final KeyEvent e) {
        this.panel.keyReleased(e);
    }
}
