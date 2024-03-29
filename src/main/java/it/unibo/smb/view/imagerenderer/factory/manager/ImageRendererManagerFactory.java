package it.unibo.smb.view.imagerenderer.factory.manager;

import it.unibo.smb.controller.GameController;
import it.unibo.smb.view.imagerenderer.manager.ImageRendererManager;

/**
 * The ImageRendererManagerFactory interface defines a contract for creating instances of ImageRendererManager.
 */
public interface ImageRendererManagerFactory {

    /**
     * Creates a new instance of ImageRendererManager with the specified GameController.
     *
     * @param controller the GameController instance to be associated with the ImageRendererManager.
     * @return a new instance of ImageRendererManager.
     */
    ImageRendererManager createImageRendererManager(GameController controller);

}

