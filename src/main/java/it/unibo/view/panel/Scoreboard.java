package it.unibo.view.panel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.controller.GameController;

/**
 * The GameMenu class represents the panel where the User can view statistic after passing the level.
 * It extends JPanel and provides the number of deaths and the time that the User managed to pass the level.
 */
public class Scoreboard extends JPanel  {
    private JLabel label;
    private JLabel deathsField;
    private JLabel timeRecordField;
    private int deaths = 0;
    //time record

    /**
     * 
     * @param controller
     */
    public Scoreboard(final GameController controller) {
        this.setLayout(new GridLayout(3, 1));
        label = new JLabel("LEVEL 1");
        deathsField = new JLabel("DEATHS: " + this.deaths);
        timeRecordField = new JLabel("TIME: ");

        this.add(label);
        this.add(deathsField);
        this.add(timeRecordField);
    }

    

    private void updateDeaths() {
    }

    private void updateTimeRecord() {

    }
}
