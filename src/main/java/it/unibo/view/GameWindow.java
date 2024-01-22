package it.unibo.view;

import java.awt.Color;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

    public GameWindow() {
        GamePanel panel = new GamePanel();
        panel.setLocation(0,0);
        panel.setSize(this.getSize());
        panel.setBackground(Color.CYAN);
        this.setContentPane(panel);
    }
}
