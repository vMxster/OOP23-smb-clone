package it.unibo;

import it.unibo.view.GameWindow;
import it.unibo.commons.Constants;
import it.unibo.controller.GameControllerImpl;

import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;

public class SuperMeatBoy {

    public static void main(String[] args) throws IOException {
        GameWindow frame = new GameWindow(new GameControllerImpl(new URL(Constants.SOURCE_MAP)));

        frame.setSize(Constants.SW, Constants.SH);
        frame.setResizable(false);
        frame.setLocationByPlatform(true);
        frame.setTitle("Super Meat Boy Clone");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
