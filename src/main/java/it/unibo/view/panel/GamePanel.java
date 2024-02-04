package it.unibo.view.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

import it.unibo.commons.Constants;
import it.unibo.controller.GameController;
import it.unibo.model.entity.player.MeatBoy;

public class GamePanel extends JPanel{
    private final List<BufferedImage> images;
    private GameController controller;
    private final MeatBoy meatBoy;

    public GamePanel(GameController controller) {
        this.images = new ArrayList<>();
        this.controller = controller;
        this.meatBoy = this.controller.getMeatBoy();
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
        paintMeatBoy(g2d);
    }

    void paintMeatBoy(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect((int)meatBoy.getX(), (int)meatBoy.getY(), Constants.TILE_SIZE, Constants.TILE_SIZE);
    }

    public void keyPressed(KeyEvent e) {
        this.controller.getGameModel().getCollisionChecker().moveMeatBoy(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        this.controller.getGameModel().getCollisionChecker().stopMovingMeatBoy(e.getKeyCode());
    }

}
