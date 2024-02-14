package it.unibo.view.imageresizer;

import java.awt.image.BufferedImage;
import java.util.List;

public interface ImageResizer {

    List<BufferedImage> resize(List<BufferedImage> render);

}
