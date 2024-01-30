package it.unibo.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JPanel;
import java.awt.image.BufferedImage; 

import it.unibo.commons.Constants;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.player.MeatBoyImpl;

public class GamePanel extends JPanel implements ActionListener {

    private final MeatBoy meatBoy;
    private final Timer gameTimer;
    private final List<BufferedImage> images;

    public GamePanel() {
        
        this.meatBoy = new MeatBoyImpl(200, 200, Constants.TILE_SIZE, Constants.TILE_SIZE);
        this.gameTimer = new Timer();
        this.images = new ArrayList<>();
        this.gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                meatBoy.update();
                repaint();
            }
            
        }, 0, 17);
    }

    public void setImages(final List<BufferedImage> images) {
        this.images.addAll(images);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int i=0 ; i<this.images.size() ; i++) {
            g2d.drawImage(Objects.requireNonNull(this.images.get(i)), 0, 0, this);
        }
        this.meatBoy.draw(g2d);
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
