package it.unibo.view.imageRenderer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.tiles.Tile;

/**
 * The ImageRenderer interface defines methods for rendering game elements.
 */
public interface ImageRenderer {

    /**
     * Generates a BufferedImage representing the stationary tiles in the game.
     * 
     * @param stationary A 2D List of Tile objects representing the stationary tiles.
     * @return A BufferedImage representing the stationary tiles.
     * @throws IOException If an I/O error occurs while generating the image.
     */
    BufferedImage getStationary(List<List<Optional<Tile>>> stationary) throws IOException;

    /**
     * Generates a BufferedImage representing the background of the game.
     * 
     * @return A BufferedImage representing the background.
     * @throws IOException If an I/O error occurs while generating the image.
     */
    BufferedImage getBackGround() throws IOException;

    /**
     * Generates a BufferedImage representing the character MeatBoy in the game.
     * 
     * @return A BufferedImage representing Meat Boy.
     * @throws IOException If an I/O error occurs while generating the image.
     */
    BufferedImage getMeatBoy() throws IOException;

    /**
     * Generates a BufferedImage representing the saws of the game.
     * 
     * @param saws The List of CircularSaw objects representing the saws.
     * @return A BufferedImage representing the background.
     * @throws IOException If an I/O error occurs while generating the image.
     */
    BufferedImage getSaws(List<CircularSaw> saws);

}

