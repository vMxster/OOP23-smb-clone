package it.unibo.commons.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import it.unibo.view.GamePanel;

public class KeyboardInput extends KeyAdapter{

    GamePanel panel;
    
    public KeyboardInput(GamePanel panel) {
        this.panel = panel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        panel.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        panel.keyReleased(e);
    }

    
}
