package it.unibo;

import it.unibo.view.GameWindow;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SuperMeatBoy {
    private static final int PROPORTION = 2;

    public static void main(String[] args) {
        GameWindow frame = new GameWindow();

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);

        frame.setTitle("Super Meat Boy Clone");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
