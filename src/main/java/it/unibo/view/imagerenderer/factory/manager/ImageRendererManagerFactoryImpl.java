package it.unibo.view.imagerenderer.factory.manager;

import it.unibo.controller.GameController;
import it.unibo.view.imagerenderer.manager.ImageRendererManager;
import it.unibo.view.imagerenderer.manager.ImageRendererManagerImpl;

public class ImageRendererManagerFactoryImpl implements ImageRendererManagerFactory {

    @Override
    public ImageRendererManager createImageRendererManager(final GameController controller) {
        return new ImageRendererManagerImpl(controller);
    }

}
