package it.unibo.commons.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import it.unibo.view.panel.GamePanel;

/**
 * Custom KeyAdapter class for handling keyboard input events.
 * Delegates key events to the associated GamePanel for processing.
 */
public class KeyboardInput extends KeyAdapter {

    private final GamePanel panel;

    /**
     * Constructs the KeyboardInput with the specified GamePanel.
     * 
     * @param panel the GamePanel to which key events will be delegated
     */
    public KeyboardInput(final GamePanel panel) {
        this.panel = panel;
    }

    /**
     * Called when a key is pressed. Delegates the event to the associated GamePanel.
     * 
     * @param e the KeyEvent representing the key press event
     */
    @Override
    public void keyPressed(final KeyEvent e) {
        panel.keyPressed(e);
    }

    /**
     * Called when a key is released. Delegates the event to the associated GamePanel.
     * 
     * @param e the KeyEvent representing the key release event
     */
    @Override
    public void keyReleased(final KeyEvent e) {
        panel.keyReleased(e);
    }
}
