package it.unibo.smb.view.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import it.unibo.smb.view.window.GameWindow;
import it.unibo.smb.controller.GameController;
import it.unibo.smb.view.window.GameWindow.PanelType;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Scoreboard class represents the panel where the User can view statistic after passing the level.
 * It extends JPanel and provides the number of deaths and the time that the User managed to pass the level.
 */
public class Scoreboard extends JPanel {

    private static final long serialVersionUID = 1;
    private static final int LABEL_FONT_SIZE = 40;
    private static final int FIELD_FONT_SIZE = 30;
    private static final int BUTTON_FONT_SIZE = 30;
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 50;
    private static final int VERTICAL_STRUT_SMALL = 10;
    private static final int VERTICAL_STRUT_MEDIUM = 20;
    private static final int VERTICAL_STRUT_LARGE = 30;
    private static final Color BUTTON_BACKGROUND_COLOR = new Color(214, 47, 55);
    private static final String FONT_TYPE = "Arial";
    private final transient GameController controller;
    private final JLabel deathsField;
    private final JLabel timeRecordField;

    /**
     * Constructs a new instance of Scoreboard with the GameController and GameWindow.
     * 
     * @param controller the GameController associated with the window.
     * @param window the GameWindow that can switch to change panel.
     */
    public Scoreboard(final GameController controller, final GameWindow window) {
        this.controller = controller;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);

        final JLabel levelLabel = new JLabel("LEVEL 1");
        levelLabel.setAlignmentX(CENTER_ALIGNMENT);
        levelLabel.setFont(new Font(FONT_TYPE, Font.BOLD, LABEL_FONT_SIZE));
        levelLabel.setForeground(Color.WHITE);
        add(Box.createVerticalStrut(VERTICAL_STRUT_MEDIUM));
        add(levelLabel);

        deathsField = new JLabel("TOTAL DEATHS: " + this.controller.getDeaths());
        deathsField.setAlignmentX(CENTER_ALIGNMENT);
        deathsField.setFont(new Font(FONT_TYPE, Font.BOLD, FIELD_FONT_SIZE));
        deathsField.setForeground(Color.WHITE);
        add(Box.createVerticalStrut(VERTICAL_STRUT_SMALL));
        add(deathsField);

        timeRecordField = new JLabel(String.format("BEST TIME RECORD: %d:%02d",
                this.controller.getTimeRecord() / 100, this.controller.getTimeRecord() % 100));
        timeRecordField.setAlignmentX(CENTER_ALIGNMENT);
        timeRecordField.setFont(new Font(FONT_TYPE, Font.BOLD, FIELD_FONT_SIZE));
        timeRecordField.setForeground(Color.WHITE);
        add(Box.createVerticalStrut(VERTICAL_STRUT_SMALL));
        add(timeRecordField);

        final JButton backButton = createButton("BACK", e -> window.switchPanel(PanelType.MENU));
        backButton.setAlignmentX(CENTER_ALIGNMENT);
        add(Box.createVerticalStrut(VERTICAL_STRUT_LARGE));
        add(backButton);

        updateDeaths();
        updateTimeRecord();
    }

    private JButton createButton(final String text, final ActionListener actionListener) {
        final JButton button = new JButton(text);
        button.setFont(new Font(FONT_TYPE, Font.BOLD, BUTTON_FONT_SIZE));
        button.setBackground(BUTTON_BACKGROUND_COLOR);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.addActionListener(actionListener);
        return button;
    }

    /**
     * Updates the display of total deaths in the user interface.
     * Retrieves the total number of deaths from the associated controller and sets the text of the deathsField
     * to reflect this information.
     */
    private void updateDeaths() {
        deathsField.setText("TOTAL DEATHS: " + this.controller.getDeaths());
    }

    /**
     * Updates the display of the best time record in the user interface.
     * Retrieves the best time record from the associated controller, which is stored in milliseconds,
     * and converts it to a readable format (minutes and seconds) before setting the text of the timeRecordField.
     * The time is formatted as "BEST TIME RECORD: mm:ss".
     */
    private void updateTimeRecord() {
        timeRecordField.setText(String.format("BEST TIME RECORD: %d:%02d",
                this.controller.getTimeRecord() / 100, this.controller.getTimeRecord() % 100));
    }

    @Override
    public final void addNotify() {
        super.addNotify();
        updateDeaths();
        updateTimeRecord();
        repaint();
    }
}
