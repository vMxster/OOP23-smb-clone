package it.unibo.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JPanel;
import java.awt.image.BufferedImage; 

import it.unibo.controller.GameController;
import it.unibo.model.collision.CollisionChecker;
import it.unibo.model.collision.CollisionCheckerImpl;
import it.unibo.model.entity.player.MeatBoy;

public class GamePanel extends JPanel{

    private final MeatBoy meatBoy;
    private final Timer gameTimer;
    private final List<BufferedImage> images;
    private GameController controller;
    private CollisionChecker collisionChecker;

    public GamePanel(GameController controller) {
        
        this.controller = controller;
        this.meatBoy = this.controller.getMeatBoy();
        this.collisionChecker = new CollisionCheckerImpl(controller.getGameModel());
        this.gameTimer = new Timer();
        this.images = new ArrayList<>();
        this.gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                collisionChecker.updateMeatBoy();
                repaint();
                if (collisionChecker.isInWindow() == CollisionChecker.CollisionState.FALL) {
                    try {
                        Thread.sleep(500);
                        System.exit(0);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    if (collisionChecker.isColliding() == (CollisionChecker.CollisionState.SAW)) {
                        System.out.println("HAI PERSO");      
                    } else if (collisionChecker.isColliding() == (CollisionChecker.CollisionState.BANDAGE_GIRL)) {
                        System.out.println("HAI VINTO");
                    }  
                    
                }   
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

    public void keyPressed(KeyEvent e) {
        this.collisionChecker.moveMeatBoy(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        this.collisionChecker.stopMovingMeatBoy(e.getKeyCode());
    }

}
