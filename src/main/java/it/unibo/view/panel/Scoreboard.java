package it.unibo.view.panel;

import java.awt.Color;
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
    private static final int ROWS = 4;
    private static final int COLS = 1;
    private final transient GameController controller;
    private JLabel deathsField;
    private JLabel timeRecordField;

    /**
     * Constructs a new instance of Scoreboard with the GameController and GameWindowSwing.
     * 
     * @param controller the GameController associated with the window.
     * @param window the GameWindowSwing that can switch to change panel.
     */
    public Scoreboard(final GameController controller, final GameWindowSwing window) {
        this.setLayout(new GridLayout(ROWS, COLS));
        this.controller = controller;
        final JLabel levelLabel = new JLabel("LEVEL 1");
        deathsField = new JLabel("TOTAL DEATHS: " + this.controller.getDeaths());
        timeRecordField = new JLabel(String.format("BEST TIME RECORD: %d:%02d", this.controller.getTimeRecord() / 100, this.controller.getTimeRecord() % 100));
        final JButton backButton = new JButton("BACK");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                window.switchPanel(PanelType.MENU);
            }
        });

        this.setBackground(Color.BLACK);
        this.add(levelLabel);
        levelLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        levelLabel.setFont(GameMenu.TITLE_TEXT_FONT);
        levelLabel.setForeground(Color.WHITE);
        setupLable(deathsField);
        setupLable(timeRecordField);
        setupButton(backButton);
    }

    private void setupButton(final JButton button) {
        this.add(button);
        button.setFont(GameMenu.TEXT_FONT);
        button.setBackground(GameMenu.BUTTON_COLOR);
        button.setForeground(Color.BLACK);
    }

    private void setupLable(final JLabel label) {
        this.add(label);
        label.setFont(GameMenu.TEXT_FONT);
        label.setForeground(Color.WHITE);
    }

    /**
     * Update the number of deaths every time the player die.
     */
    public void updateDeaths() {
        this.deathsField.setText("TOTAL DEATHS: " + this.controller.getDeaths());
    }

    /**
     * Update the time record every time the player ends the level with a better time than before.
     */
    public void updateTimeRecord() {
        this.timeRecordField.setText(String.format("BEST TIME RECORD: %d:%02d", this.controller.getTimeRecord() / 100, this.controller.getTimeRecord() % 100));
    }

    @Override
    public void addNotify() {
        super.addNotify();
        updateDeaths();
        updateTimeRecord();
        repaint();
    }

}
