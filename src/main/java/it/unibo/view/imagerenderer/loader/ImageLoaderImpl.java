package it.unibo.view.imagerenderer.loader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import it.unibo.view.imagerenderer.manager.ImageType;

/**
 * The ImageLoaderImpl class provides functionality to load images based on the specified ImageType.
 */
public class ImageLoaderImpl implements ImageLoader {

    /**
     * Constructs a new instance of ImageLoaderImpl.
     */
    public ImageLoaderImpl() {
    }

    /**
     * Loads the image associated with the specified ImageType.
     *
     * @param imageType The type of image to load.
     * @return The loaded BufferedImage.
     */
    @Override
    public BufferedImage load(final ImageType imageType) {
        try {
            return getImage(imageType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BufferedImage(0, 0, 0);
    }

    /**
     * Loads the image file associated with the specified ImageType.
     *
     * @param imageType The type of image to load.
     * @return The loaded BufferedImage.
     * @throws IOException if an I/O error occurs.
     */
    private BufferedImage getImage(final ImageType imageType) throws IOException {
        return ImageIO.read(new File("./src/main/resources/" + imageType));
    }

}
