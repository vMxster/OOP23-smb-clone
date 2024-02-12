package it.unibo.view.panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.controller.GameController;
/**
 * The Scoreboard class represents the panel where the User can view statistic after passing the level.
 * It extends JPanel and provides the number of deaths and the time that the User managed to pass the level.
 */
public class Scoreboard extends JPanel  {
    private JLabel label;
    private JLabel deathsField;
    private JLabel timeRecordField;
    private JButton backButton;
    private int deaths = 0;
    //time record

    /**
     * 
     * @param controller
     */
    public Scoreboard(final GameController controller) {
        this.setLayout(new GridLayout(4, 1));
        label = new JLabel("LEVEL 1");
        deathsField = new JLabel("DEATHS: " + this.deaths);
        timeRecordField = new JLabel("TIME: ");
        backButton = new JButton("BACK");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            }
        });

        this.add(label);
        this.add(deathsField);
        this.add(timeRecordField);
        this.add(backButton);
    }

    

    private void updateDeaths() {
    }

    private void updateTimeRecord() {

    }
}
