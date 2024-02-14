package it.unibo.view.imageresizer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import it.unibo.commons.Constants;
import it.unibo.controller.GameController;

import java.util.ArrayList;

public class ImageResizerImpl implements ImageResizer {

    private final GameController controller;

    public ImageResizerImpl(final GameController controller) {
        this.controller = controller;
    }

    @Override
    public List<BufferedImage> resize(final List<BufferedImage> images) {
        final List<BufferedImage> newImages = new ArrayList<>();
        final double scaleX = (double) Constants.SW / images.get(0).getWidth();
        final double scaleY = (double) Constants.SH / images.get(0).getHeight();
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

        for (var elem : controller.getSaws()) {
            elem.getHitbox().getHitbox().setFrame(
                elem.getHitbox().getHitbox().getX() * scaleX,
                elem.getHitbox().getHitbox().getY() * scaleY,
                (int) (elem.getHitbox().getHitbox().getWidth() * scaleX),
                (int) (elem.getHitbox().getHitbox().getWidth() * scaleX));
        }

        for (var elem : controller.getPlatforms()) {
            elem.getHitbox().getHitbox().setFrame(
                elem.getHitbox().getHitbox().getX() * scaleX,
                elem.getHitbox().getHitbox().getY() * scaleY,
                (int) (elem.getHitbox().getHitbox().getWidth() * scaleX),
                (int) (elem.getHitbox().getHitbox().getHeight() * scaleY));
        }

        controller.getBandageGirl().setX(controller.getBandageGirl().getX() * scaleX);
        controller.getBandageGirl().setY(controller.getBandageGirl().getY() * scaleY);
        controller.getMeatBoyStartCoord().setX(controller.getMeatBoy().getX() * scaleX);
        controller.getMeatBoyStartCoord().setY(controller.getMeatBoy().getY() * scaleY);

        return newImages;
    }

}
