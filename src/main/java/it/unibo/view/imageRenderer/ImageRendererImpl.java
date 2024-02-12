package it.unibo.view.imageRenderer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import javax.imageio.ImageIO;

import it.unibo.commons.Constants;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.tiles.Tile;

/**
 * The ImageRendererImpl class is responsible for rendering images for the game map, including background, 
 * player character (Meat Boy), stationary objects, and circular saws.
 */
public class ImageRendererImpl implements ImageRenderer {

    private final int numRows;
    private final int numCols;

    /**
     * Initializes a new instance of ImageRenderer with the given number of rows
     * and columns.
     *
     * @param numRows The number of Map rows.
     * @param numCols The number of Map columns.
     */
    public ImageRendererImpl(final int numRows, final int numCols) {
        this.numCols = numCols;
        this.numRows = numRows;
    }

    /**
     * Retrieves the background image for the game.
     *
     * @return The background image.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public BufferedImage getBackGround() throws IOException {
        return ImageIO.read(new File("./src/main/resources/background.png"));
    }

    /**
     * Retrieves the image for the player character (Meat Boy).
     *
     * @return The image for Meat Boy.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public BufferedImage getMeatBoy() throws IOException {
        return ImageIO.read(new File("./src/main/resources/meatboystanding.png"));
    }

    /**
     * Generates a BufferedImage representing the stationary tiles in the game.
     * 
     * @param stationary A 2D List of Tile objects representing the stationary tiles.
     * @return A BufferedImage representing the stationary tiles.
     */
    @Override
    public BufferedImage getStationary(final List<List<Optional<Tile>>> stationary) {
        final BufferedImage image = new BufferedImage(
                numCols * Constants.TILE_SIZE,
                numRows * Constants.TILE_SIZE,
                BufferedImage.TYPE_INT_ARGB);
        final Graphics2D g = (Graphics2D) image.getGraphics();

        IntStream.range(0, numRows).forEach(row ->
                IntStream.range(0, numCols).forEach(column -> {
                    final Optional<Tile> tile = stationary.get(row).get(column);
                    tile.ifPresent(t -> {
                        try {
                            g.drawImage(
                                    getSubImage(ImageIO.read(new File("./src/main/resources/" + t.getSrcImage())), t),
                                    column * Constants.TILE_SIZE,
                                    row * Constants.TILE_SIZE,
                                    Constants.TILE_SIZE,
                                    Constants.TILE_SIZE,
                                    null);
                        } catch (IOException e) {
                            Logger.getLogger(ImageRendererImpl.class.getName())
                                    .severe("An error occurred: " + e.getMessage());
                        }
                    });
                }));
        g.dispose();
        return image;
    }

    /**
     * Generates a BufferedImage representing the saws of the game.
     * 
     * @param saws The List of CircularSaw objects representing the saws.
     * @return A BufferedImage representing the saws.
     */
    @Override
    public BufferedImage getSaws(final List<CircularSaw> saws) {
        final BufferedImage image = new BufferedImage(
                numCols * Constants.TILE_SIZE,
                numRows * Constants.TILE_SIZE,
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
                        Logger.getLogger(ImageRendererImpl.class.getName())
                                .severe("An error occurred: " + e.getMessage());
                    }
                });
        g.dispose();
        return image;
    }

    /**
     * Returns a subimage from the provided base image based on the specified tile.
     *
     * @param baseImage The base image from which to extract the subimage.
     * @param tile The Tile object specifying the subimage's position.
     * @return The subimage corresponding to the specified Tile.
     */
    private BufferedImage getSubImage(final BufferedImage baseImage, final Tile tile) {
        return baseImage.getSubimage(
                tile.getX(),
                tile.getY(),
                Constants.TILE_SIZE,
                Constants.TILE_SIZE);
    }

}
