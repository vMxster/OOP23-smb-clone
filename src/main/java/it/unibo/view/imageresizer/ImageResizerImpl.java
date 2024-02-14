package it.unibo.view.imageresizer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import it.unibo.commons.Constants;

import java.util.ArrayList;

public class ImageResizerImpl implements ImageResizer {

    public ImageResizerImpl() {
    }

    @Override
    public List<BufferedImage> resize(final List<BufferedImage> images) {
        final List<BufferedImage> newImages = new ArrayList<>();
        final double scaleX = (double) Constants.SW / 800;
        final double scaleY = (double) Constants.SH / 600;
        for (int i = 0; i<images.size(); i++) {
            int scaledWidth = (int) (images.get(i).getWidth() * scaleX);
            int scaledHeight = (int) (images.get(i).getHeight() * scaleY);
            BufferedImage resizedImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = resizedImage.createGraphics();
            if (i==images.size()-1) {
                g.drawImage(images.get(i), 0,0, (int) (Constants.TILE_SIZE * scaleX) , (int) (Constants.TILE_SIZE * scaleY) , null);
                newImages.add(resizedImage);
                g.dispose();
            } else {
                g.drawImage(images.get(i), 0, 0, scaledWidth, scaledHeight, null);
                newImages.add(resizedImage);
                g.dispose();
            }
        }
        return newImages;
    }

}
