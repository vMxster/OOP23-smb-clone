package it.unibo.view.imagerenderer.manager;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.tiles.Tile;

/**
 * The ImageRenderer interface defines methods for rendering game elements.
 */
public interface ImageRendererManager {

    /**
     * Renders the circular saws and stationary tiles into a list of BufferedImages.
     * 
     * @param saws The list of CircularSaw objects to render.
     * @param stationary The 2D list of Optional Tile objects representing the stationary tiles.
     * @return A list of BufferedImages representing the rendered game elements.
     */
    List<BufferedImage> render(List<CircularSaw> saws, List<List<Optional<Tile>>> stationary);

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

}
