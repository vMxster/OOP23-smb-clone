package it.unibo.view.panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.view.window.GameWindowSwing;
import it.unibo.controller.GameController;
import it.unibo.view.window.GameWindow.PanelType;
/**
 * The Scoreboard class represents the panel where the User can view statistic after passing the level.
 * It extends JPanel and provides the number of deaths and the time that the User managed to pass the level.
 */
public class Scoreboard extends JPanel  {

    public static final long serialVersionUID = 1;
    private static final int ROWS = 5;
    private static final int COLS = 1;
    private final transient GameController controller;
    private int deaths;
    private int record;

    /**
     * Constructs a new instance of Scoreboard with the GameController and GameWindowSwing.
     * 
     * @param controller the GameController associated with the window.
     * @param window the GameWindowSwing that can switch to change panel.
     */
    public Scoreboard(final GameController controller, final GameWindowSwing window) {
        this.setLayout(new GridLayout(ROWS, COLS));
        this.controller = controller;
        this.deaths = 0;
        this.record = 0;
        final JLabel levelLabel = new JLabel("LEVEL 1");
        final JLabel deathsField = new JLabel("TOTAL DEATHS: " + deaths);
        final JLabel timeRecordField = new JLabel(String.format("BEST TIME RECORD: %d:%02d", record / 100, record % 100));
        final JButton refreshButton = new JButton("REFRESH");
        final JButton backButton = new JButton("BACK");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                window.switchPanel(PanelType.MENU);
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                updateDeaths();
                updateTimeRecord();
                deathsField.setText("TOTAL DEATHS: " + deaths);
                timeRecordField.setText(String.format("BEST TIME RECORD: %d:%02d", record / 100, record % 100));
                repaint();
            }
        });

        this.add(levelLabel);
        this.add(deathsField);
        this.add(timeRecordField);
        this.add(refreshButton);
        this.add(backButton);
    }

    /**
     * Update the number of deaths every time the player die.
     */
    public void updateDeaths() {
        deaths = this.controller.getDeaths();
    }

    /**
     * Update the time record every time the player ends the level with a better time than before.
     */
    public void updateTimeRecord() {
        if (this.controller.getTimeRecord() != Integer.MAX_VALUE) {
            record = this.controller.getTimeRecord();
        } else {
            record = 0;
        }
    }
}
