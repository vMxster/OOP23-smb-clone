package it.unibo;

import it.unibo.view.GameWindow;
import it.unibo.commons.Constants;


import javax.swing.JFrame;

public class SuperMeatBoy {

    public static void main(String[] args) {
        GameWindow frame = new GameWindow();

        frame.setSize(Constants.SW / Constants.PROPORTION, Constants.SH / Constants.PROPORTION);
        frame.setLocationByPlatform(true);

        frame.setTitle("Super Meat Boy Clone");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
