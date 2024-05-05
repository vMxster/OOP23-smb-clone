package it.unibo.smb.view.panel;

import it.unibo.smb.controller.GameController;
import it.unibo.smb.view.window.GameWindow;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serial;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * A panel for displaying level selection options.
 */
public class LevelSelectionPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 1;
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 30;
    private static final int BUTTON_FONT_SIZE = 18;
    private static final int PANEL_FONT_SIZE = 20;
    private static final Color BUTTON_BACKGROUND_COLOR = new Color(214, 47, 55);
    private static final Color LABEL_TEXT_COLOR = Color.WHITE;

    /**
     * Constructs a new LevelSelectionPanel with the specified GameController.
     * @param controller The GameController instance controlling the game.
     */
    public LevelSelectionPanel(final GameController controller) {
        setLayout(new GridBagLayout());
        setOpaque(false);

        final JPanel forestPanel = createSectionPanel("Factory", controller);
        final JPanel factoryPanel = createSectionPanel("Forest", controller);

        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(forestPanel, gbc);
        gbc.gridy = 1;
        add(factoryPanel, gbc);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    controller.getGameWindow().switchPanel(GameWindow.PanelType.MENU);
                }
            }
        });
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
     * Creates a panel for a specific section of levels.
     * @param sectionName The name of the section.
     * @param controller The GameController instance controlling the game.
     * @return The JPanel representing the section.
     */
    private JPanel createSectionPanel(final String sectionName, final GameController controller) {
        final JPanel sectionPanel = new JPanel(new GridBagLayout());
        sectionPanel.setOpaque(false);
        sectionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel sectionLabel = new JLabel(sectionName);
        sectionLabel.setFont(new Font("Arial", Font.BOLD, PANEL_FONT_SIZE));
        sectionLabel.setForeground(LABEL_TEXT_COLOR);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0);
        sectionPanel.add(sectionLabel, gbc);

        IntStream.rangeClosed(1, 2)
                .mapToObj(i -> {
                    final JButton levelButton = createStyledButton("Level " + i);
                    levelButton.addActionListener(e -> {
                        controller.getGameWindow().switchPanel(GameWindow.PanelType.LOADING);
                        final Timer timer = new Timer(0, e1 -> {
                            controller.start(sectionName, i);
                            controller.getGameWindow().switchPanel(GameWindow.PanelType.GAME);
                        });
                        timer.setRepeats(false);
                        timer.start();
                    });
                    return levelButton;
                })
                .forEach(levelButton -> {
                    gbc.gridy++;
                    sectionPanel.add(levelButton, gbc);
                });
        return sectionPanel;
    }

    /**
     * Creates a styled JButton.
     * @param text The text to display on the button.
     * @return The styled JButton.
     */
    private JButton createStyledButton(final String text) {
        final JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, BUTTON_FONT_SIZE));
        button.setBackground(BUTTON_BACKGROUND_COLOR);
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.setForeground(LABEL_TEXT_COLOR);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }
}
