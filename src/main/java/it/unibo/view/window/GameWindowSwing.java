package it.unibo.view.window;

import java.io.IOException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unibo.commons.Constants;
import it.unibo.commons.input.KeyboardInput;
import it.unibo.controller.GameController;
import it.unibo.view.imageRenderer.ImageRenderer;
import it.unibo.view.imageRenderer.ImageRendererImpl;
import it.unibo.view.panel.GamePanel;

public class GameWindowSwing extends JFrame implements GameWindow {

    private final GameController controller;
    private final ImageRenderer renderer;

    /**
     * Constructs a new instance of GameWindowSwing with the specified GameController.
     *
     * @param controller the GameController associated with the window.
     */
    public GameWindowSwing(final GameController controller) {
        this.controller = controller;
        this.renderer = new ImageRendererImpl(this.controller.getNumRows(), this.controller.getNumCols());
        initializeWindowProperties();
        initializeGamePanel();
        this.setVisible(true);
    }

    @Override
    public void paint() {
        this.repaint();
    }

    @Override
    public void displayVictoryMessage() {
        JOptionPane.showMessageDialog(this, "WIN", "WIN", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
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

    /**
     * Creates a new instance of GamePanel with the specified GameController and sets its initial properties.
     *
     * @return a new instance of GamePanel configured with background, stationary, saws, and MeatBoy images.
     * @throws IOException if an I/O error occurs while obtaining the images.
     */
    private GamePanel createGamePanel() throws IOException {
        GamePanel panel = new GamePanel(this.controller);
        panel.setLocation(0, 0);
        panel.setImages(
            List.of(
                this.renderer.getBackGround(),
                this.renderer.getStationary(controller.getStationary()),
                this.renderer.getSaws(controller.getSaws()),
                this.renderer.getMeatBoy()));
        return panel;
    }

}
