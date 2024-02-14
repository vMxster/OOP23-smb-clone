package it.unibo.view.imagerenderer.factory.gameobjects;

import it.unibo.view.imagerenderer.gameobjects.ImageRendererStationary;

public interface ImageRendererStationaryFactory {

    ImageRendererStationary createImageRendererStationary(int numRows, int numColumns);

}

