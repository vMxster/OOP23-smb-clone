package it.unibo.smb.view.imagerenderer.factory.loader;

import it.unibo.smb.view.imagerenderer.loader.ImageLoader;
import it.unibo.smb.view.imagerenderer.loader.ImageLoaderImpl;

/**
 * The ImageLoaderFactoryImpl class is an implementation of the ImageLoaderFactory interface.
 * It provides a concrete implementation of the factory method createImageLoader(), instantiating
 * ImageLoader objects.
 */
public class ImageLoaderFactoryImpl implements ImageLoaderFactory {

    @Override
    public final ImageLoader createImageLoader() {
        return new ImageLoaderImpl();
    }

}
