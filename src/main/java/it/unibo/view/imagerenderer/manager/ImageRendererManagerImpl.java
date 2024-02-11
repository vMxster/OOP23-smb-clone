package it.unibo.view.imagerenderer.manager;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Optional;

import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.tiles.Tile;
import it.unibo.view.imagerenderer.gameobjects.ImageRendererSaws;
import it.unibo.view.imagerenderer.gameobjects.ImageRendererSawsImpl;
import it.unibo.view.imagerenderer.gameobjects.ImageRendererStationary;
import it.unibo.view.imagerenderer.gameobjects.ImageRendererStationaryImpl;

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
        return List.of(
            this.imageRendererGameObjects.render(saws),
            this.imageRendererStationary.render(stationary));
    }

}
