package it.unibo.view.imageRenderer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.List;
import java.util.Optional;

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
     * Renders stationary objects on the map.
     *
     * @param stationary A 2D list of Optional<Tile> representing stationary objects.
     * @return A BufferedImage containing rendered stationary objects.
     */
    @Override
    public BufferedImage getStationary(final List<List<Optional<Tile>>> stationary) {
        BufferedImage image = new BufferedImage(
                numCols * Constants.TILE_SIZE,
                numRows * Constants.TILE_SIZE,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        for (int row = 0; row < numRows; row++) {
            for (int column = 0; column < numCols; column++) {
                Optional<Tile> tile = stationary.get(row).get(column);
                if (tile.isPresent()) {
                    try {
                        g.drawImage(
                            getSubImage(
                                ImageIO.read(new File("./src/main/resources/" + tile.get().getSrcImage())),
                                tile.get()),
                            column * Constants.TILE_SIZE,
                            row * Constants.TILE_SIZE,
                            Constants.TILE_SIZE,
                            Constants.TILE_SIZE,
                            null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        g.dispose();
        return image;
    }

    /**
     * Renders circular saws on the map.
     *
     * @param saws A list of CircularSaw objects representing circular saws.
     * @return A BufferedImage containing rendered circular saws.
     */
    @Override
    public BufferedImage getSaws(final List<CircularSaw> saws) {
        BufferedImage image = new BufferedImage(
                numCols * Constants.TILE_SIZE,
                numRows * Constants.TILE_SIZE,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        for (int i = 0; i < saws.size(); i++) {
            CircularSaw saw = saws.get(i);
            if (!Objects.isNull(saw)) {
                try {
                    g.drawImage(
                        ImageIO.read(new File("./src/main/resources/buzzsaw2.png")),
                        (int) saw.getX(),
                        (int) saw.getY(),
                        (int) saw.getHitbox().getHitbox().getWidth(),
                        (int) saw.getHitbox().getHitbox().getHeight(),
                        null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
