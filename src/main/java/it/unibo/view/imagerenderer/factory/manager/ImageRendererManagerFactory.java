package it.unibo.view.imagerenderer.factory.manager;

import it.unibo.controller.GameController;
import it.unibo.view.imagerenderer.manager.ImageRendererManager;

public interface ImageRendererManagerFactory {

    ImageRendererManager createImageRendererManager(GameController controller);

}

