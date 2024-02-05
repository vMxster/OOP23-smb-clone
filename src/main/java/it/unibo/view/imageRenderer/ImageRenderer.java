package it.unibo.view.imageRenderer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.tiles.Tile;

/**
 * The Renderer interface defines methods for rendering game elements.
 */
public interface ImageRenderer {

    /**
     * Generates a BufferedImage representing the stationary tiles in the game.
     * 
     * @param stationary a 2D List of Tile objects representing the stationary tiles.
     * @return a BufferedImage representing the stationary tiles.
     * @throws IOException if an I/O error occurs while generating the image.
     */
    BufferedImage getStationary(final List<List<Tile>> stationary) throws IOException;

    /**
     * Generates a BufferedImage representing the background of the game.
     * 
     * @return a BufferedImage representing the background.
     * @throws IOException if an I/O error occurs while generating the image.
     */
    BufferedImage getBackGround() throws IOException;

    /**
     * Generates a BufferedImage representing the character MeatBoy in the game.
     * 
     * @return a BufferedImage representing Meat Boy.
     * @throws IOException if an I/O error occurs while generating the image.
     */
    BufferedImage getMeatBoy() throws IOException;

    /**
     * Generates a BufferedImage representing the saws of the game.
     * 
     * @return a BufferedImage representing the background.
     * @throws IOException if an I/O error occurs while generating the image.
     */
    BufferedImage getSaws(final List<CircularSaw> saws);

}

