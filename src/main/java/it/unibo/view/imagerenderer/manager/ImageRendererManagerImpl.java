package it.unibo.view.imagerenderer.manager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;

import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.tiles.Tile;
import it.unibo.view.imagerenderer.gameobjects.ImageRendererSaws;
import it.unibo.view.imagerenderer.gameobjects.ImageRendererSawsImpl;
import it.unibo.view.imagerenderer.stationary.ImageRendererStationary;
import it.unibo.view.imagerenderer.stationary.ImageRendererStationaryImpl;

/**
 * The ImageRendererManager class is responsible for managing the rendering of the game map.
 */
public class ImageRendererManagerImpl implements ImageRendererManager {

    private final ImageRendererSaws imageRendererGameObjects;
    private final ImageRendererStationary imageRendererStationary;

    /**
     * Constructs an ImageRendererManager with the specified number of rows and columns for the game map.
     *
     * @param numRows    The number of rows in the game map.
     * @param numColumns The number of columns in the game map.
     */
    public ImageRendererManagerImpl(final int numRows, final int numColumns) {
        this.imageRendererGameObjects = new ImageRendererSawsImpl(numRows, numColumns);
        this.imageRendererStationary = new ImageRendererStationaryImpl(numRows, numColumns);
    }

    /**
     * Manage the rendering of circular saws and stationary tiles into a list of BufferedImages.
     *
     * @param saws       The list of CircularSaw objects to render.
     * @param stationary The 2D list of Optional Tile objects representing the stationary tiles.
     * @return A list of BufferedImages representing the rendered game elements.
     */
    @Override
    public List<BufferedImage> render(final List<CircularSaw> saws, final List<List<Optional<Tile>>> stationary) {
        final List<BufferedImage> list = new ArrayList<>();
        list.add(
            this.imageRendererGameObjects.render(saws));
        list.add(
            this.imageRendererStationary.render(stationary));
        return list;
    }

    /**
     * Retrieves the background image for the game.
     *
     * @return The background image.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public BufferedImage getBackGround() throws IOException {
        return ImageIO.read(new File("./src/main/resources/background.png"));
    }

    /**
     * Retrieves the image for the player character (Meat Boy).
     *
     * @return The image for Meat Boy.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public BufferedImage getMeatBoy() throws IOException {
        return ImageIO.read(new File("./src/main/resources/meatboystanding.png"));
    }

}
