package it.unibo.view.window;

import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.unibo.commons.Constants;
import it.unibo.controller.GameController;
import it.unibo.view.panel.GameMenu;
import it.unibo.view.imageRenderer.ImageRenderer;
import it.unibo.view.imageRenderer.ImageRendererImpl;
import it.unibo.view.panel.GamePanel;
import it.unibo.view.panel.Scoreboard;

/**
 * The GameWindowSwing class represents a Swing-based implementation of the GameWindow interface.
 * It extends JFrame and provides methods for rendering the game window and handling user interaction.
 */
public class GameWindowSwing extends JFrame implements GameWindow {

    public static final long serialVersionUID = 1;
    private final GameController controller;
    private final ImageRenderer renderer;
    private final GameMenu menu;
    private final Scoreboard scoreboard;
    private GamePanel gamePanel;

    /**
     * Constructs a new instance of GameWindowSwing with the specified GameController.
     *
     * @param controller the GameController associated with the window.
     */
    public GameWindowSwing(final GameController controller) {
        this.controller = controller;
        this.renderer = new ImageRendererImpl(this.controller.getNumRows(), this.controller.getNumCols());
        this.menu = new GameMenu(this.controller, this);
        this.gamePanel = new GamePanel(this.controller);
        this.scoreboard = new Scoreboard(this.controller, this);
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
    @Override
    public void initializeGamePanel() {
        try {
            this.gamePanel = createGamePanel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Set the game panel visible.
     */
    @Override
    public void setPanelVisible() {
        this.setVisible(true);
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
    public void switchPanel(PanelType type) {
        var panel = selectPanel(type);
        this.setContentPane(panel);
        panel.requestFocus();
        this.setVisible(true);
    }

    private JPanel selectPanel(PanelType type) {
        return switch(type) {
            case GAME -> gamePanel;
            case MENU -> menu;
            case SCOREBOARD -> scoreboard;
            default -> throw new IllegalArgumentException();
        };
    }
}
