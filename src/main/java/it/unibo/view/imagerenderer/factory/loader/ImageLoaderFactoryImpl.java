package it.unibo.view.imagerenderer.factory.loader;

import it.unibo.view.imagerenderer.loader.ImageLoader;
import it.unibo.view.imagerenderer.loader.ImageLoaderImpl;

public class ImageLoaderFactoryImpl implements ImageLoaderFactory {

    @Override
    public ImageLoader createImageLoader() {
        return new ImageLoaderImpl();
    }

}
