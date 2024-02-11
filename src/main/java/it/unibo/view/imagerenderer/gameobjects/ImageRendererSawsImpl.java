package it.unibo.view.imagerenderer.gameobjects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import it.unibo.commons.Constants;
import it.unibo.model.entity.obstacles.CircularSaw;

/**
 * An implementation of ImageRendererSaws that generates a BufferedImage representing
 * the saws in a game.
 */
public class ImageRendererSawsImpl implements ImageRendererSaws {

    private final int numRows;
    private final int numColumns;

    /**
     * Constructs an ImageRendererSawsImpl object with the specified number of rows and columns.
     *
     * @param numRows    The number of rows in the grid.
     * @param numColumns The number of columns in the grid.
     */
    public ImageRendererSawsImpl(final int numRows, final int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
    }

    /**
     * Renders the saws represented by the provided List of CircularSaw objects
     * into a BufferedImage.
     *
     * @param saws The List of CircularSaw objects representing the saws.
     * @return A BufferedImage representing the saws.
     */
    @Override
    public BufferedImage render(final List<CircularSaw> saws) {
        return getSaws(saws);
    }

    /**
     * Generates a BufferedImage representing the saws in the game.
     *
     * @param saws The List of CircularSaw objects representing the saws.
     * @return A BufferedImage representing the saws.
     */
    private BufferedImage getSaws(final List<CircularSaw> saws) {
        final BufferedImage image = new BufferedImage(
                this.numColumns * Constants.TILE_SIZE,
                this.numRows * Constants.TILE_SIZE,
                BufferedImage.TYPE_INT_ARGB);
        final Graphics2D g = (Graphics2D) image.getGraphics();

        saws.stream()
                .filter(saw -> !Objects.isNull(saw))
                .forEach(saw -> {
                    try {
                        g.drawImage(
                                ImageIO.read(new File("./src/main/resources/buzzsaw2.png")),
                                (int) saw.getX(),
                                (int) saw.getY(),
                                (int) saw.getHitbox().getHitbox().getWidth(),
                                (int) saw.getHitbox().getHitbox().getHeight(),
                                null);
                    } catch (IOException e) {
                        Logger.getLogger(ImageRendererSawsImpl.class.getName())
                                .severe("An error occurred: " + e.getMessage());
                    }
                });
        g.dispose();
        return image;
    }

}
