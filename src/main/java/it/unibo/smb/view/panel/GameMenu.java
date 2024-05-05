package it.unibo.smb.view.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Serial;
import java.util.Objects;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.smb.controller.GameController;
import it.unibo.smb.view.window.GameWindow.PanelType;

/**
 * A panel representing the game menu, allowing users to start the game, view the scoreboard, or quit the game.
 */
@SuppressFBWarnings("DM_EXIT")
public class GameMenu extends JPanel {

    @Serial
    private static final long serialVersionUID = 2;
    private static final int VERTICAL_GAP = 50;
    private static final Color BUTTON_COLOR = new Color(214, 47, 55);
    private static final Font TEXT_FONT = new Font("Arial", Font.BOLD, 30);
    private static final int COMPONENT_GAP = 10;
    private static final int BUTTON_WIDTH = 200;

    /**
     * Constructs a new GameMenu panel with the specified GameController.
     * @param controller The GameController instance controlling the game.
     */
    public GameMenu(final GameController controller) {
        setLayout(new GridBagLayout());
        setOpaque(false);

        add(Box.createVerticalStrut(VERTICAL_GAP));

        addButton("START", e -> {
            controller.getGameWindow().switchPanel(PanelType.LEVELS);
        }, 0);

        addButton("SCOREBOARD", e -> {
            controller.getGameWindow().switchPanel(PanelType.SCOREBOARD);
        }, 1);

        addButton("QUIT", e -> {
            if (JOptionPane.showConfirmDialog(
                    null,
                    "Sei sicuro di volere uscire?",
                    "Esci dal gioco",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }, 2);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false),
                "returnToMainMenu"
        );
        getActionMap().put("returnToMainMenu", new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (JOptionPane.showConfirmDialog(
                        null,
                        "Sei sicuro di volere uscire?",
                        "Esci dal gioco",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        add(Box.createVerticalStrut(VERTICAL_GAP));
    }

    @Override
    protected final void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(
                new ImageIcon(Objects.requireNonNull(
                        getClass().getClassLoader().getResource("titlescreen.png"))).getImage(),
                0,
                0,
                getWidth(),
                getHeight(),
                this);
    }

    /**
     * Adds a button to the game menu panel.
     * @param text The text to display on the button.
     * @param actionListener The ActionListener for the button.
     * @param gridY The grid Y position of the button.
     */
    private void addButton(final String text, final ActionListener actionListener, final int gridY) {
        final GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = gridY;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets.bottom = COMPONENT_GAP;

        final JButton button = new JButton(text);
        button.setFont(TEXT_FONT);
        button.setBackground(BUTTON_COLOR);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(BUTTON_WIDTH * 2, button.getPreferredSize().height));
        button.addActionListener(actionListener);
        add(button, constraints);
    }
}
