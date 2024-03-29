package it.unibo.smb.view.imagerenderer.factory.gameobjects;

import it.unibo.smb.view.imagerenderer.gameobjects.ImageRendererSaws;
import it.unibo.smb.view.imagerenderer.gameobjects.ImageRendererSawsImpl;

/**
 * The ImageRendererSawsFactoryImpl class is an implementation of the ImageRendererSawsFactory interface.
 * It provides a concrete implementation of the factory method createImageRendererSaws(), instantiating
 * ImageRendererSaws objects.
 */
public class ImageRendererSawsFactoryImpl implements ImageRendererSawsFactory {

    @Override
    public final ImageRendererSaws createImageRendererSaws(final int numRows, final int numColumns) {
        return new ImageRendererSawsImpl(numRows, numColumns);
    }

}
