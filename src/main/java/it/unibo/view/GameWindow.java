package it.unibo.view;

import java.awt.Dimension;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;

import it.unibo.commons.input.KeyboardInput;
import it.unibo.controller.GameController;
import it.unibo.view.renderer.ImageRenderer;
import it.unibo.view.renderer.ImageRendererImpl;

public class GameWindow extends JFrame {

    private final GameController controller;
    private final ImageRenderer renderer;

    public GameWindow(final GameController controller) throws IOException {
        this.controller = controller;
        this.renderer = new ImageRendererImpl(this.controller.getNumRows(), this.controller.getNumCols());

        GamePanel panel = new GamePanel();
        panel.setLocation(0,0);
        panel.setSize(new Dimension(600,800));
        panel.setImages(
            List.of(
                renderer.getBackGround(),
                renderer.getStationary(controller.getStationary()),
                renderer.getSaws(controller.getSaws())));
        this.setContentPane(panel);
        addKeyListener(new KeyboardInput(panel));
    }

}
