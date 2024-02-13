package it.unibo.view.window;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import it.unibo.commons.Constants;
import it.unibo.controller.GameController;
import it.unibo.view.panel.GameMenu;
import it.unibo.view.imagerenderer.manager.ImageRendererManager;
import it.unibo.view.imagerenderer.manager.ImageRendererManagerImpl;
import it.unibo.view.panel.GamePanel;
import it.unibo.view.panel.Scoreboard;

/**
 * The GameWindowSwing class represents a Swing-based implementation of the GameWindow interface.
 * It extends JFrame and provides methods for rendering the game window and handling user interaction.
 */
public class GameWindowSwing extends JFrame implements GameWindow {

    public static final long serialVersionUID = 1;
    private static final int INITIAL_TIMER_POSITION = 10;
    private static final int TIMER_WIDTH = 100;
    private static final int TIMER_HEIGHT = 30;
    private static final int FONT_SIZE = 30;
    private final GameController controller;
    private final ImageRendererManager renderer;
    private final GameMenu menu;
    private final JLabel timerField;
    private final Scoreboard scoreboard;
    private GamePanel gamePanel;

    /**
     * Constructs a new instance of GameWindowSwing with the specified GameController.
     *
     * @param controller the GameController associated with the window.
     */
    public GameWindowSwing(final GameController controller) {
        this.controller = controller;
        this.renderer = new ImageRendererManagerImpl(this.controller);
        this.menu = new GameMenu(this.controller, this);
        this.timerField = new JLabel();
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
    public void paint(final int centiSeconds) {
        this.timerField.setText(String.format("%d:%02d", centiSeconds / 100, centiSeconds % 100));
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
    private void initializeGamePanel() {
        try {
            this.gamePanel = createGamePanel();
            this.timerField.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
            this.timerField.setBounds(INITIAL_TIMER_POSITION, INITIAL_TIMER_POSITION, TIMER_WIDTH, TIMER_HEIGHT);
            this.gamePanel.add(timerField);
        } catch (IOException e) {
            Logger.getLogger(GameWindowSwing.class.getName())
                .log(Level.SEVERE, "Errore durante l'inizializzazione del pannello di gioco", e);
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
        final var panel = new GamePanel(this.controller);
        panel.setLocation(0, 0);
        panel.setImages(this.renderer.render());
        return panel;
    }

    /**
     * Switches the content pane to the game panel.
     * 
     * @param type Type of panel to set.
     */
    @Override
    public void switchPanel(final PanelType type) {
        final var panel = selectPanel(type);
        this.setContentPane(panel);
        panel.requestFocus();
        this.setVisible(true);
    }

    /**
     * Selects and returns a JPanel based on the specified PanelType.
     *
     * @param type The PanelType specifying the type of panel to select.
     * @return A JPanel corresponding to the specified PanelType.
     */
    private JPanel selectPanel(final PanelType type) {
        return switch (type) {
            case GAME -> gamePanel;
            case MENU -> menu;
            case SCOREBOARD -> scoreboard;
            default -> throw new IllegalArgumentException();
        };
    }
}