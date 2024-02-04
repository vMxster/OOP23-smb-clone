package it.unibo.view.window;

import java.util.List;

import javax.swing.JFrame;

import it.unibo.commons.Constants;
import it.unibo.commons.input.KeyboardInput;
import it.unibo.controller.GameController;
import it.unibo.view.imageRenderer.ImageRenderer;
import it.unibo.view.imageRenderer.ImageRendererImpl;
import it.unibo.view.panel.GamePanel;

public class GameWindow extends JFrame {

    private final GameController controller;
    private final ImageRenderer renderer;

    public GameWindow(final GameController controller) {

        this.setSize(Constants.SW, Constants.SH);
        this.setResizable(false);
        this.setLocationByPlatform(true);
        this.setTitle("Super Meat Boy Clone");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.controller = controller;
        this.renderer = new ImageRendererImpl(this.controller.getNumRows(), this.controller.getNumCols());
        
        GamePanel panel = new GamePanel(controller);
        panel.setLocation(0,0);
        try {
            panel.setImages(
            List.of(
                renderer.getBackGround(),
                renderer.getStationary(controller.getStationary()),
                renderer.getSaws(controller.getSaws())));
                this.setContentPane(panel);
                addKeyListener(new KeyboardInput(panel));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        this.setVisible(true);
    }
}
