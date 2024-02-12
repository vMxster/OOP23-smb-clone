package it.unibo.view.panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.unibo.controller.GameController;
import it.unibo.view.window.GameWindowSwing;
import it.unibo.view.window.GameWindow.PanelType;

/**
 * The GameMenu class represents the panel of the main menu of the game.
 * It extends JPanel and provides buttons to switch to the GamePanel, check the scoreboard after a level and quit the application.
 */
public class GameMenu extends JPanel {

    private JButton startButton;
    private JButton scoreboardButton;
    private JButton quitButton;
    /**
     * Constructs a new instance of GameMenu with the specified GameController and GameWindowSwing.
     * 
     * @param controller the GameController associated with the window.
     * @param window the GameWindowSwing that can switch to change panel.
     */
    public GameMenu(final GameController controller, final GameWindowSwing window) {
        this.setLayout(new GridLayout(3, 1));
        startButton = new JButton("START");
        scoreboardButton = new JButton("SCOREBOARD");
        quitButton = new JButton("QUIT");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.start();
                window.switchPanel(PanelType.GAME);
            }
        });

        scoreboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", 
                "Exit Confirmation", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        this.add(startButton);
        this.add(scoreboardButton);
        this.add(quitButton);
    }
}
