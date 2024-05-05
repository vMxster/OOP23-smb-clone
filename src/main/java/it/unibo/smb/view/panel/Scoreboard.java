package it.unibo.smb.view.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.Serial;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import it.unibo.smb.controller.GameController;
import it.unibo.smb.controller.EnvironmentType;
import it.unibo.smb.controller.LevelType;
import it.unibo.smb.view.window.GameWindow;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * The Scoreboard represents the panel where the User can view statistics after passing each level.
 * It extends JPanel and provides the number of deaths and the time that the User managed to pass each level.
 */
public class Scoreboard extends JPanel {

    @Serial
    private static final long serialVersionUID = 2;
    private static final int LABEL_FONT_SIZE = 40;
    private static final int FIELD_FONT_SIZE = 30;
    private static final int VERTICAL_STRUT_SMALL = 10;
    private static final int VERTICAL_STRUT_MEDIUM = 20;
    private static final String FONT_TYPE = "Arial";
    private final transient GameController controller;
    private final Map<LevelType, JLabel> deathsLabels;
    private final Map<LevelType, JLabel> timeRecordLabels;

    /**
     * Constructs a new instance of Scoreboard with the GameController.
     *
     * @param controller the GameController associated with the window.
     */
    public Scoreboard(final GameController controller) {
        this.controller = controller;
        this.deathsLabels = new HashMap<>();
        this.timeRecordLabels = new HashMap<>();
        setLayout(new GridBagLayout());
        setOpaque(false);

        final JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));

        final JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));

        addEnvironmentSection(northPanel, EnvironmentType.FACTORY);
        addEnvironmentSection(southPanel, EnvironmentType.FOREST);

        final GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 0.5;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 10, 10, 10);
        add(northPanel, constraints);

        constraints.gridy = 1;
        add(Box.createVerticalStrut(VERTICAL_STRUT_MEDIUM), constraints);

        constraints.gridy = 2;
        add(southPanel, constraints);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false),
                "returnToMainMenu"
        );
        getActionMap().put("returnToMainMenu", new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.getGameWindow().switchPanel(GameWindow.PanelType.MENU);
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
     * Adds a section for a specific environment, including levels and statistics.
     *
     * @param panel       the panel to add the section for.
     * @param environment the environment to add the section for.
     */
    private void addEnvironmentSection(final JPanel panel, final EnvironmentType environment) {
        panel.add(Box.createVerticalStrut(VERTICAL_STRUT_MEDIUM));
        panel.setOpaque(false);

        final JLabel environmentLabel = new JLabel(environment.getName().toUpperCase(Locale.US));
        environmentLabel.setAlignmentX(CENTER_ALIGNMENT);
        environmentLabel.setFont(new Font(FONT_TYPE, Font.BOLD, LABEL_FONT_SIZE));
        environmentLabel.setForeground(Color.WHITE);
        panel.add(environmentLabel);
        panel.add(Box.createVerticalStrut(VERTICAL_STRUT_SMALL));

        Arrays.stream(LevelType.values())
                .filter(level -> level.getEnvironment().equals(environment))
                .forEach(level -> addLevelStatistics(panel, level));
    }

    /**
     * Adds statistics for a specific level.
     *
     * @param panel the panel to add statistics to.
     * @param level the level to add statistics for.
     */
    private void addLevelStatistics(final JPanel panel, final LevelType level) {
        final JLabel levelLabel = new JLabel("LEVEL " + level.getLevelNumber());
        levelLabel.setAlignmentX(CENTER_ALIGNMENT);
        levelLabel.setFont(new Font(FONT_TYPE, Font.BOLD, LABEL_FONT_SIZE));
        levelLabel.setForeground(Color.WHITE);
        panel.add(levelLabel);

        final JLabel deathsField = new JLabel("TOTAL DEATHS: " + this.controller.getDeaths(level));
        deathsField.setAlignmentX(CENTER_ALIGNMENT);
        deathsField.setFont(new Font(FONT_TYPE, Font.BOLD, FIELD_FONT_SIZE));
        deathsField.setForeground(Color.WHITE);
        panel.add(deathsField);

        final JLabel timeRecordField = new JLabel(String.format("BEST TIME RECORD: %d:%02d",
                this.controller.getTimeRecord(level) / 100, this.controller.getTimeRecord(level) % 100));
        timeRecordField.setAlignmentX(CENTER_ALIGNMENT);
        timeRecordField.setFont(new Font(FONT_TYPE, Font.BOLD, FIELD_FONT_SIZE));
        timeRecordField.setForeground(Color.WHITE);
        panel.add(timeRecordField);

        panel.add(Box.createVerticalStrut(VERTICAL_STRUT_SMALL));

        deathsLabels.put(level, deathsField);
        timeRecordLabels.put(level, timeRecordField);
    }

    /**
     * Updates the statistics displayed in the Scoreboard panel.
     * Retrieves the latest statistics from the GameController and updates the corresponding labels.
     */
    public void updateStats() {
        Arrays.stream(LevelType.values())
                .forEach(level -> {
                    deathsLabels.get(level).setText("TOTAL DEATHS: " + this.controller.getDeaths(level));
                    timeRecordLabels.get(level).setText(String.format("BEST TIME RECORD: %d:%02d",
                            this.controller.getTimeRecord(level) / 100, this.controller.getTimeRecord(level) % 100));
                });
    }
}
