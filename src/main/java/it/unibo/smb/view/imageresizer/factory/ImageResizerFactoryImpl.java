package it.unibo.smb.view.imageresizer.factory;

import it.unibo.smb.view.imageresizer.ImageResizer;
import it.unibo.smb.view.imageresizer.ImageResizerImpl;

/**
 * The ImageResizerFactoryImpl class is an implementation of the ImageResizerFactory interface.
 * It provides functionality to create ImageResizer objects.
 */
public class ImageResizerFactoryImpl implements ImageResizerFactory {

    @Override
    public final ImageResizer createImageResizer() {
        return new ImageResizerImpl();
    }

}
