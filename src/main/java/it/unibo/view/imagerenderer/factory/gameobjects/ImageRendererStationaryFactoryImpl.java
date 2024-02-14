package it.unibo.view.imagerenderer.factory.gameobjects;

import it.unibo.view.imagerenderer.gameobjects.ImageRendererStationary;
import it.unibo.view.imagerenderer.gameobjects.ImageRendererStationaryImpl;

public class ImageRendererStationaryFactoryImpl implements ImageRendererStationaryFactory {

    @Override
    public final ImageRendererStationary createImageRendererStationary(final int numRows, final int numColumns) {
        return new ImageRendererStationaryImpl(numRows, numColumns);
    }

}
