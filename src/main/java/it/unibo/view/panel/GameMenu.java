package it.unibo.view.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.unibo.controller.GameController;
import it.unibo.view.window.GameWindow.PanelType;

/**
 * The GameMenu class represents the panel of the main menu of the game.
 * It extends JPanel and provides buttons to switch to the GamePanel, check the scoreboard after a level and quit the application.
 */
public class GameMenu extends JPanel {

    public static final long serialVersionUID = 1;
    public static final int ROWS = 4;
    public static final int COLS = 1;
    public static final int TITLE_FONT_SIZE = 50;
    public static final int FONT_SIZE = 30;
    public static final Color BUTTON_COLOR = new Color(214,47,55);
    public static final Font TITLE_TEXT_FONT = new Font("Arial", Font.BOLD, TITLE_FONT_SIZE);
    public static final Font TEXT_FONT = new Font("Arial", Font.BOLD, FONT_SIZE);

    /**
     * Constructs a new instance of GameMenu with the specified GameController and GameWindowSwing.
     * 
     * @param controller the GameController associated with the window.
     * @param window the GameWindowSwing that can switch to change panel.
     */
    public GameMenu(final GameController controller) {
        this.setLayout(new GridLayout(ROWS, COLS));
        final JLabel title = new JLabel(new ImageIcon("./src/main/resources/supermeatboyintro.png"));
        final JButton startButton = new JButton("START");
        final JButton scoreboardButton = new JButton("SCOREBOARD");
        final JButton quitButton = new JButton("QUIT");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.start();
                controller.getGameWindow().switchPanel(PanelType.GAME);
            }
        });

        scoreboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.getGameWindow().switchPanel(PanelType.SCOREBOARD);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Sei sicuro di volere uscire?", 
            "Esci dal gioco", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
                }
            }
        });

        this.setBackground(Color.BLACK);
        this.add(title);
        setupButton(startButton);
        setupButton(scoreboardButton);
        setupButton(quitButton);
    }

    private void setupButton(final JButton component) {
        this.add(component);
        component.setFont(TEXT_FONT);
        component.setBackground(BUTTON_COLOR);
        component.setForeground(Color.BLACK);
    }
    
}
