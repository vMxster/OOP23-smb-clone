package it.unibo.smb.view.window;

import java.awt.Font;
import java.io.Serial;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import it.unibo.smb.commons.Constants;
import it.unibo.smb.controller.EnvironmentType;
import it.unibo.smb.controller.GameController;
import it.unibo.smb.view.imagerenderer.manager.ImageType;
import it.unibo.smb.view.panel.GameMenu;
import it.unibo.smb.view.imagerenderer.factory.manager.ImageRendererManagerFactoryImpl;
import it.unibo.smb.view.imagerenderer.manager.ImageRendererManager;
import it.unibo.smb.view.imageresizer.ImageResizer;
import it.unibo.smb.view.imageresizer.factory.ImageResizerFactoryImpl;
import it.unibo.smb.view.panel.GamePanel;
import it.unibo.smb.view.panel.LevelSelectionPanel;
import it.unibo.smb.view.panel.LoadingPanel;
import it.unibo.smb.view.panel.Scoreboard;

/**
 * The GameWindowSwing class represents a Swing-based implementation of the GameWindow interface.
 * It extends JFrame and provides methods for rendering the game window and handling user interaction.
 */
public class GameWindowSwing extends JFrame implements GameWindow {

    /** Default serial version UID. */
    @Serial
    private static final long serialVersionUID = 4L;
    private static final int INITIAL_TIMER_POSITIONX = (int) (Constants.SW * 0.01);
    private static final int INITIAL_TIMER_POSITIONY = (int) (Constants.SH * 0.01);
    private static final int TIMER_WIDTH = (int) (Constants.SW * 0.08);
    private static final int TIMER_HEIGHT = (int) (Constants.SH * 0.03);
    private static final int INITIAL_DEATHSFIELD_POSITIONX = (int) (Constants.SW * 0.96);
    private static final int INITIAL_DEATHSFIELD_POSITIONY = (int) (Constants.SH * 0.01);
    private static final int DEATHSFIELD_WIDTH = (int) (Constants.SW * 0.05);
    private static final int DEATHSFIELD_HEIGHT = (int) (Constants.SH * 0.03);
    private static final int FONT_SIZE = 30;

    private final GameMenu menu;
    private final JLabel timerField;
    private final LoadingPanel loading;
    private final JLabel deathsField;
    private final Scoreboard scoreboard;
    private final transient ImageResizer imageResizer;
    private final LevelSelectionPanel levelSelection;
    private transient ImageRendererManager renderer;
    private GamePanel gamePanel;

    /**
     * Constructs a new instance of GameWindowSwing with the specified GameController.
     *
     * @param controller the GameController associated with the window.
     */
    public GameWindowSwing(final GameController controller) {
        this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass()
                .getClassLoader()
                .getResource(ImageType.MEAT_BOY.toString()))).getImage());
        this.menu = new GameMenu(controller);
        this.timerField = new JLabel();
        this.deathsField = new JLabel();
        this.scoreboard = new Scoreboard(controller);
        this.loading = new LoadingPanel();
        this.imageResizer = new ImageResizerFactoryImpl()
                .createImageResizer();
        this.levelSelection = new LevelSelectionPanel(controller);
        setContentPane(menu);
        initializeWindowProperties();
    }

    /**
     * Starts the game with the specified environment type and controller.
     *
     * @param environmentType The environment type.
     * @param controller The game controller.
     */
    @Override
    public final void start(final EnvironmentType environmentType, final GameController controller) {
        this.renderer = new ImageRendererManagerFactoryImpl()
                .createImageRendererManager(controller);
        this.gamePanel = new GamePanel(controller);
        initializeGamePanel(environmentType);
    }

    /**
     * Updates the statistics displayed in the game window.
     */
    @Override
    public final void updateStats() {
        this.scoreboard.updateStats();
    }

    /**
     * Paints the content of the game window.
     * This method is responsible for updating and rendering the content of the game window.
     * It should be called whenever the content needs to be refreshed or repainted.
     *
     * @param centiSeconds  Time in hundredths of a second.
     * @param currentDeaths Number of deaths in the current session.
     */
    @Override
    public void paint(final int centiSeconds, final int currentDeaths) {
        this.timerField.setText(String.format("%d:%02d", centiSeconds / 100, centiSeconds % 100));
        this.deathsField.setText(String.format("%d", currentDeaths));
        this.repaint();
    }

    /**
     * Displays a graphical message or UI elements indicating the player's victory.
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
        this.setLocationRelativeTo(null);
        this.setTitle("Super Meat Boy Clone");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Initializes the game panel with the specified environment type.
     *
     * @param environmentType The environment type for rendering the game panel.
     */
    private void initializeGamePanel(final EnvironmentType environmentType) {
        this.gamePanel.setLocation(0, 0);
        this.gamePanel.setImages(
                this.imageResizer.resize(this.renderer.render(environmentType)));
        this.timerField.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
        this.timerField.setBounds(INITIAL_TIMER_POSITIONX, INITIAL_TIMER_POSITIONY, TIMER_WIDTH, TIMER_HEIGHT);
        this.deathsField.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
        this.deathsField.setBounds(INITIAL_DEATHSFIELD_POSITIONX,
                INITIAL_DEATHSFIELD_POSITIONY, DEATHSFIELD_WIDTH, DEATHSFIELD_HEIGHT);
        this.gamePanel.add(timerField);
        this.gamePanel.add(deathsField);
    }

    @Override
    public final void setPanelVisible() {
        this.setVisible(true);
    }

    /**
     * Switches the content pane to the specified panel type.
     *
     * @param type The type of panel to set.
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
            case LEVELS -> levelSelection;
            case LOADING -> loading;
        };
    }
}
