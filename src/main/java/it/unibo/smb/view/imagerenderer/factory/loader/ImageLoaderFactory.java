package it.unibo.smb.view.imagerenderer.factory.loader;

import it.unibo.smb.view.imagerenderer.loader.ImageLoader;

/**
 * The ImageLoaderFactory interface defines a contract for creating instances of ImageLoader.
 */
public interface ImageLoaderFactory {

    /**
     * Creates a new instance of ImageLoader.
     *
     * @return a new instance of ImageLoader.
     */
    ImageLoader createImageLoader();

}

