package it.unibo.view.window;

import java.io.IOException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unibo.commons.Constants;
import it.unibo.controller.GameController;
import it.unibo.view.imageRenderer.ImageRenderer;
import it.unibo.view.imageRenderer.ImageRendererImpl;
import it.unibo.view.panel.GamePanel;

/**
 * The GameWindowSwing class represents a Swing-based implementation of the GameWindow interface.
 * It extends JFrame and provides methods for rendering the game window and handling user interaction.
 */
public class GameWindowSwing extends JFrame implements GameWindow {

    private final GameController controller;
    private final ImageRenderer renderer;
    private final GameMenu menu;
    private GamePanel gamePanel;

    /**
     * Constructs a new instance of GameWindowSwing with the specified GameController.
     *
     * @param controller the GameController associated with the window.
     */
    public GameWindowSwing(final GameController controller) {
        this.controller = controller;
        this.renderer = new ImageRendererImpl(this.controller.getNumRows(), this.controller.getNumCols());
        this.menu = new GameMenu(controller, this);
        this.initializeGamePanel();
        this.setContentPane(menu);
        initializeWindowProperties();
        this.setVisible(true);
    }

    /**
     * Paints the game window.
     */
    @Override
    public void paint() {
        this.repaint();
    }

    /**
     * Displays a victory message dialog.
     */
    @Override
    public void displayVictoryMessage() {
        JOptionPane.showMessageDialog(this, "WIN", "WIN", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
    }

    /**
     * Initializes the properties of the game window.
     */
    @Override
    public void initializeWindowProperties() {
        this.setSize(Constants.SW, Constants.SH);
        this.setResizable(false);
        this.setLocationByPlatform(true);
        this.setTitle("Super Meat Boy Clone");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Initializes the game panel.
     */
    @Override
    public void initializeGamePanel() {
        try {
            this.gamePanel = createGamePanel();
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

    /**
     * Switches the content pane to the game panel.
     */
    public void switchPanel() {
        this.setContentPane(gamePanel);
        gamePanel.requestFocus();
        this.setVisible(true);
    }

}
