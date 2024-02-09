package it.unibo.view.panel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import it.unibo.commons.input.KeyboardInput;
import it.unibo.controller.GameController;
import it.unibo.model.entity.player.MeatBoy;

/**
 * The GamePanel class represents the main panel for rendering game elements.
 * It extends JPanel and provides methods for painting and handling keyboard input.
 */
public class GamePanel extends JPanel {

    private final List<BufferedImage> images;
    private final GameController controller;
    private final MeatBoy meatBoy;

    /**
     * Constructs a new GamePanel with the specified GameController.
     *
     * @param controller the GameController associated with the panel.
     */
    public GamePanel(final GameController controller) {
        this.images = new ArrayList<>();
        this.controller = controller;
        this.meatBoy = this.controller.getMeatBoy();
        this.setFocusable(true);
        this.addKeyListener(new KeyboardInput(this));
    }

    /**
     * Sets the list of Images to be displayed on the panel and triggers a repaint.
     * In the Images, there are Background, Stationary, Saws and MeatBoy Images (in order).
     *
     * @param images the list of BufferedImages representing game elements.
     */
    public void setImages(final List<BufferedImage> images) {
        this.images.addAll(images);
        repaint();
    }

    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < this.images.size(); i++) {
            if ( i==3 ) {
                g2d.drawImage(Objects.requireNonNull(this.images.get(i)), (int) meatBoy.getX(), (int) meatBoy.getY(), this);
            } else {
                g2d.drawImage(Objects.requireNonNull(this.images.get(i)), 0, 0, this);
            }
        }
    }

    /**
     * Handles key pressed events.
     *
     * @param e the KeyEvent representing the key pressed event.
     */
    public void keyPressed(final KeyEvent e) {
        this.controller.getGameModel().getCollisionHandler().moveMeatBoy(e.getKeyCode());
    }

    /**
     * Handles key released events.
     *
     * @param e the KeyEvent representing the key released event.
     */
    public void keyReleased(final KeyEvent e) {
        this.controller.getGameModel().getCollisionHandler().stopMovingMeatBoy(e.getKeyCode());
    }

}
