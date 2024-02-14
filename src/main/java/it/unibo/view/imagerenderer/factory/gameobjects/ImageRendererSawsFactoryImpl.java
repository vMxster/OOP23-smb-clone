package it.unibo.view.imagerenderer.factory.gameobjects;

import it.unibo.view.imagerenderer.gameobjects.ImageRendererSaws;
import it.unibo.view.imagerenderer.gameobjects.ImageRendererSawsImpl;

public class ImageRendererSawsFactoryImpl implements ImageRendererSawsFactory {

    @Override
    public final ImageRendererSaws createImageRendererSaws(final int numRows, final int numColumns) {
        return new ImageRendererSawsImpl(numRows, numColumns);
    }

}
