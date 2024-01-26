package it.unibo;

import it.unibo.view.GameWindow;
import it.unibo.commons.Constants;
import it.unibo.controller.ControllerImpl;

import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;

public class SuperMeatBoy {

    public static void main(String[] args) throws IOException {
        URL urlMap = new URL("resources/factory1.tmx");
        GameWindow frame = new GameWindow(new ControllerImpl(urlMap));

        frame.setSize(Constants.SW / Constants.PROPORTION, Constants.SH / Constants.PROPORTION);
        frame.setLocationByPlatform(true);

        frame.setTitle("Super Meat Boy Clone");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
