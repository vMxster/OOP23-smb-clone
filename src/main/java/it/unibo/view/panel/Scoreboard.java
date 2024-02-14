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
    private GameController controller;
    private JLabel label;
    private JLabel deathsField;
    private JLabel timeRecordField;
    private JButton backButton;
    private JButton refreshButton;
    private int deaths;
    //time record

    /**
     * 
     * @param controller
     * @param window
     */
    public Scoreboard(final GameController controller, final GameWindowSwing window) {
        this.setLayout(new GridLayout(5, 1));
        this.controller = controller;
        this.deaths = 0;
        this.label = new JLabel("LEVEL 1");
        this.deathsField = new JLabel("TOTAL DEATHS: " + deaths);
        this.timeRecordField = new JLabel("RECORD TIME: ");
        this.backButton = new JButton("BACK");
        this.refreshButton = new JButton("REFRESH");

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
                //updateTimeRecord
                deathsField.setText("TOTAL DEATHS: " + deaths);
                repaint();
                System.out.println(deaths);
            }
        });

        this.add(label);
        this.add(deathsField);
        this.add(timeRecordField);
        this.add(backButton);
        this.add(refreshButton);
    }


    public void updateDeaths() {
        deaths = this.controller.getDeaths();
    }
    
    public void updateTimeRecord() {

    }
}
