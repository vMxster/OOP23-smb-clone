package it.unibo.smb.view.imagerenderer.manager;

import it.unibo.smb.controller.EnvironmentType;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * The ImageRendererManager interface is responsible for managing the rendering of the game map, including circular saws,
 * stationary tiles, background, and the character MeatBoy.
 */
public interface ImageRendererManager {

    /**
     * Manages the rendering of circular saws, stationary tiles, background, and MeatBoy into a list of BufferedImages
     * based on the provided environment type.
     *
     * @param environmentType the type of environment for which rendering is requested.
     * @return A list of BufferedImages representing the rendered game elements.
     */
    List<BufferedImage> render(EnvironmentType environmentType);
}
