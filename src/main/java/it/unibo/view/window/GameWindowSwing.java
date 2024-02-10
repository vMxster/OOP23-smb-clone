package it.unibo.view.window;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unibo.commons.Constants;
import it.unibo.controller.GameController;
import it.unibo.view.imagerenderer.ImageRenderer;
import it.unibo.view.imagerenderer.ImageRendererImpl;
import it.unibo.view.panel.GameMenu;
import it.unibo.view.panel.GamePanel;

/**
 * The GameWindowSwing class represents a Swing-based implementation of the GameWindow interface.
 * It extends JFrame and provides methods for rendering the game window and handling user interaction.
 */
public class GameWindowSwing extends JFrame implements GameWindow {

    public static final long serialVersionUID = 1;
    private final GameController controller;
    private final ImageRenderer renderer;
    private final GameMenu menu;
    private final GamePanel gamePanel;

    /**
     * Constructs a new instance of GameWindowSwing with the specified GameController.
     *
     * @param controller the GameController associated with the window.
     */
    public GameWindowSwing(final GameController controller) {
        this.controller = controller;
        this.renderer = new ImageRendererImpl(this.controller.getNumRows(), this.controller.getNumCols());
        this.menu = new GameMenu(controller, this);
        this.gamePanel = new GamePanel(this.controller);
        initializeGamePanel();
        setContentPane(menu);
        initializeWindowProperties();
    }

    /**
     * Paints the content of the game window.
     * This method is responsible for updating and rendering the content of the game window.
     * It should be called whenever the content needs to be refreshed or repainted.
     */
    @Override
    public void paint() {
        this.repaint();
    }

    /**
     * This method is responsible for showing a graphical message or UI elements
     * indicating the player's victory.
     */
    @Override
    public void displayVictoryMessage() {
        JOptionPane.showMessageDialog(this, "WIN", "WIN", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
    }

    /**
     * This method is responsible for switching between different panels within the game window.
     */
    @Override
    public void switchPanel() {
        this.setContentPane(gamePanel);
        gamePanel.requestFocus();
        this.setVisible(true);
    }

    /**
     * Initializes the properties of the game window.
     */
    private void initializeWindowProperties() {
        this.setSize(Constants.SW, Constants.SH);
        this.setResizable(false);
        this.setLocationByPlatform(true);
        this.setTitle("Super Meat Boy Clone");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Initializes the game panel.
     */
    private void initializeGamePanel() {
        this.gamePanel.setLocation(0, 0);
        try {
            this.gamePanel.setImages(
                List.of(
                    this.renderer.getBackGround(),
                    this.renderer.getStationary(controller.getStationary()),
                    this.renderer.getSaws(controller.getSaws()),
                    this.renderer.getMeatBoy()));
        } catch (IOException e) {
            Logger.getLogger(GameWindowSwing.class.getName())
                .severe("An error occurred: " + e.getMessage());
        }
    }

}
