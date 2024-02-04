package it.unibo.view.window;

import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;

import it.unibo.commons.Constants;
import it.unibo.commons.input.KeyboardInput;
import it.unibo.controller.GameController;
import it.unibo.view.imageRenderer.ImageRenderer;
import it.unibo.view.imageRenderer.ImageRendererImpl;
import it.unibo.view.panel.GamePanel;

public class GameWindowSwing extends JFrame implements GameWindow {

    private final GameController controller;
    private final ImageRenderer renderer;

    public GameWindowSwing(final GameController controller) {
        this.controller = controller;
        this.renderer = new ImageRendererImpl(this.controller.getNumRows(), this.controller.getNumCols());
        initializeWindowProperties();
        initializeGamePanel();
        this.setVisible(true);
    }

    @Override
    public void initializeWindowProperties() {
        this.setSize(Constants.SW, Constants.SH);
        this.setResizable(false);
        this.setLocationByPlatform(true);
        this.setTitle("Super Meat Boy Clone");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void initializeGamePanel() {
        try {
            GamePanel panel = createGamePanel();
            this.setContentPane(panel);
            addKeyListener(new KeyboardInput(panel));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private GamePanel createGamePanel() throws IOException {
        GamePanel panel = new GamePanel(this.controller);
        panel.setLocation(0, 0);
        panel.setImages(
            List.of(
                this.renderer.getBackGround(),
                this.renderer.getStationary(controller.getStationary()),
                this.renderer.getSaws(controller.getSaws())));
        return panel;
    }

}
