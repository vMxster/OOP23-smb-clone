package it.unibo.view.window;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.unibo.controller.GameController;

public class GameMenu extends JPanel{

    JButton startButton;
    JButton scoreboardButton;
    JButton quitButton;
    GameWindowSwing window;

    public GameMenu (final GameController controller, final GameWindowSwing window){
        this.setLayout(new GridLayout(3,1));
        startButton = new JButton("START");
        scoreboardButton = new JButton("SCOREBOARD");
        quitButton = new JButton("QUIT");
        this.window = window;

        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                window.switchPanel();
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

        this.add(startButton);
        this.add(scoreboardButton);
        this.add(quitButton);
    }
}
