package it.unibo.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Objects;
import javax.swing.JPanel;
import java.awt.image.BufferedImage; 

import it.unibo.commons.Constants;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.CircularSawImpl;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.obstacles.PlatformImpl;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.player.MeatBoyImpl;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.entity.target.BandageGirlImpl;

public class GamePanel extends JPanel implements ActionListener {

    private final MeatBoy meatBoy;
    private final BandageGirl bandageGirl;
    private final CircularSaw saw;
    private final Platform platform;
    private final Timer gameTimer;
    private BufferedImage backgroundImage;

    public GamePanel() {
        
        this.meatBoy = new MeatBoyImpl(200, 200, Constants.MEATBOY_WIDTH, Constants.MEATBOY_HEIGHT);
        this.bandageGirl = new BandageGirlImpl(250, 200, Constants.MEATBOY_WIDTH, Constants.MEATBOY_HEIGHT);
        this.gameTimer = new Timer();
        this.saw = new CircularSawImpl(100, 150, 50, 50, 50);
        this.platform = new PlatformImpl(150, 150, 80, 20);
        this.gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                meatBoy.update();
                repaint();
            }
            
        }, 0, 17);
    }

    public void setBackgroundImage(BufferedImage backgroundImage) {
        this.backgroundImage = backgroundImage;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(Objects.requireNonNull(backgroundImage), 0, 0, this);
        this.meatBoy.draw(g2d);
        this.saw.draw(g2d);
        this.platform.draw(g2d);
        this.bandageGirl.draw(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public void keyPressed(KeyEvent e) {
        this.meatBoy.move(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        this.meatBoy.stopMoving(e.getKeyCode());
    }

}
