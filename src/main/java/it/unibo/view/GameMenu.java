package it.unibo.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unibo.controller.GameControllerImpl;

public class GameMenu extends JFrame{

    public GameMenu (){
        setTitle("Super Meat Boy Clone");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));

        JButton startButton = new JButton("Start");
        JButton scoreboardButton = new JButton("Scoreboard");
        JButton quitButton = new JButton("Quit");

        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameControllerImpl();
            }
        } );

        scoreboardButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        } );

        quitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        } );

        panel.add(startButton);
        panel.add(scoreboardButton);
        panel.add(quitButton);

        add(panel);
        setVisible(true);
    }
}
