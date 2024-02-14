package it.unibo.view.window;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import it.unibo.commons.Constants;
import it.unibo.controller.GameController;
import it.unibo.view.panel.GameMenu;
import it.unibo.view.imagerenderer.factory.manager.ImageRendererManagerFactoryImpl;
import it.unibo.view.imagerenderer.manager.ImageRendererManager;
import it.unibo.view.imageresizer.ImageResizer;
import it.unibo.view.imageresizer.ImageResizerImpl;
import it.unibo.view.panel.GamePanel;
import it.unibo.view.panel.Scoreboard;

/**
 * The GameWindowSwing class represents a Swing-based implementation of the GameWindow interface.
 * It extends JFrame and provides methods for rendering the game window and handling user interaction.
 */
public class GameWindowSwing extends JFrame implements GameWindow {

    public static final long serialVersionUID = 2;
    private static final int INITIAL_TIMER_POSITION = 10;
    private static final int TIMER_WIDTH = 100;
    private static final int TIMER_HEIGHT = 30;
    private static final int INITIAL_DEATHSFIELD_POSITIONX = 1280;
    private static final int INITIAL_DEATHSFIELD_POSITIONY = 10;
    private static final int DEATHSFIELD_WIDTH = 100;
    private static final int DEATHSFIELD_HEIGHT = 30;
    private static final int FONT_SIZE = 30;
    private final GameController controller;
    private final ImageRendererManager renderer;
    private final GameMenu menu;
    private final JLabel timerField;
    private final JLabel deathsField;
    private final Scoreboard scoreboard;
    private final ImageResizer imageResizer;
    private final GamePanel gamePanel;

    /**
     * Constructs a new instance of GameWindowSwing with the specified GameController.
     *
     * @param controller the GameController associated with the window.
     */
    public GameWindowSwing(final GameController controller) {
        this.controller = controller;
        this.renderer = new ImageRendererManagerFactoryImpl()
            .createImageRendererManager(this.controller);
        this.menu = new GameMenu(this.controller);
        this.timerField = new JLabel();
        this.deathsField = new JLabel();
        this.scoreboard = new Scoreboard(this.controller, this);
        this.imageResizer = new ImageResizerImpl(this.controller);
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
    public void paint(final int centiSeconds, final int currentDeaths) {
        this.timerField.setText(String.format("%d:%02d", centiSeconds / 100, centiSeconds % 100));
        this.deathsField.setText(String.format("%d", currentDeaths));
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
        this.gamePanel.setLocation(0, 0);
        this.gamePanel.setImages(this.imageResizer.resize(this.renderer.render()));
        this.timerField.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
        this.timerField.setBounds(INITIAL_TIMER_POSITION, INITIAL_TIMER_POSITION, TIMER_WIDTH, TIMER_HEIGHT);
        this.deathsField.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
        this.deathsField.setBounds(INITIAL_DEATHSFIELD_POSITIONX, INITIAL_DEATHSFIELD_POSITIONY, DEATHSFIELD_WIDTH, DEATHSFIELD_HEIGHT);
        this.gamePanel.add(timerField);
        this.gamePanel.add(deathsField);
    }

    /**
     * Set the game panel visible.
     */
    @Override
    public void setPanelVisible() {
        this.setVisible(true);
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