package it.unibo.smb.view.imagerenderer.factory.manager;

import it.unibo.smb.controller.GameController;
import it.unibo.smb.view.imagerenderer.manager.ImageRendererManager;
import it.unibo.smb.view.imagerenderer.manager.ImageRendererManagerImpl;

/**
 * The ImageRendererManagerFactoryImpl class is an implementation of the ImageRendererManagerFactory interface.
 * It provides a concrete implementation of the factory method createImageRendererManager(), instantiating
 * ImageRendererManager objects.
 */
public class ImageRendererManagerFactoryImpl implements ImageRendererManagerFactory {

    @Override
    public final ImageRendererManager createImageRendererManager(final GameController controller) {
        return new ImageRendererManagerImpl(controller);
    }

}
