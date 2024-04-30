package it.unibo.smb.view.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Objects;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.smb.controller.GameController;
import it.unibo.smb.view.window.GameWindow.PanelType;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The GameMenu class represents the panel of the main menu of the game.
 * It extends JPanel and provides buttons to switch to the GamePanel, check the scoreboard after a level and quit the application.
 */
@SuppressFBWarnings("DM_EXIT")
public class GameMenu extends JPanel {

    private static final long serialVersionUID = 1;
    private static final int VERTICAL_GAP = 50;
    private static final Color BUTTON_COLOR = new Color(214, 47, 55);
    private static final Font TEXT_FONT = new Font("Arial", Font.BOLD, 30);
    private static final int COMPONENT_GAP = 10;
    private static final int BUTTON_WIDTH = 200;

    /**
     * Constructs a new instance of GameMenu with the specified GameController and GameWindowSwing.
     * 
     * @param controller the GameController associated with the window.
     */
    public GameMenu(final GameController controller) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);

        add(Box.createVerticalStrut(VERTICAL_GAP));

        final JLabel title = new JLabel(
                new ImageIcon(
                        Objects.requireNonNull(
                                getClass().getClassLoader().getResource("supermeatboyintro.png"))));
        title.setAlignmentX(CENTER_ALIGNMENT);
        add(title);

        add(Box.createVerticalStrut(COMPONENT_GAP));

        addButton("START", e -> {
            controller.start();
            controller.getGameWindow().switchPanel(PanelType.GAME);
        });

        addButton("SCOREBOARD", e -> {
            controller.getGameWindow().switchPanel(PanelType.SCOREBOARD);
        });

        add(Box.createVerticalGlue());

        addButton("QUIT", e -> {
            if (JOptionPane.showConfirmDialog(
                    null,
                    "Sei sicuro di volere uscire?",
                    "Esci dal gioco",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        add(Box.createVerticalStrut(VERTICAL_GAP));
    }

    private void addButton(final String text, final ActionListener actionListener) {
        final JButton button = new JButton(text);
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.setFont(TEXT_FONT);
        button.setBackground(BUTTON_COLOR);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, button.getPreferredSize().height));
        button.addActionListener(actionListener);
        add(button);
        add(Box.createVerticalStrut(COMPONENT_GAP));
    }
}
