package it.unibo.view;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import it.unibo.commons.Constants;
import it.unibo.commons.input.KeyboardInput;
import it.unibo.controller.GameController;
import it.unibo.model.tiles.Tile;

public class GameWindow extends JFrame {

    private final GameController controller;
    private final int numRows;
    private final int numCols;

    public GameWindow(final GameController controller) throws IOException {
        this.controller = controller;
        this.numRows = controller.getNumRows();
        this.numCols = controller.getNumCols();

        GamePanel panel = new GamePanel();
        panel.setLocation(0,0);
        panel.setSize(new Dimension(600,800));
        panel.setBackgroundImage(getBackGround());
        
        //getStationary(); (FIX REQUIRED)
        this.setContentPane(panel);
        addKeyListener(new KeyboardInput(panel));
    }

    // draws background
    public BufferedImage getBackGround() throws IOException {
        return ImageIO.read(new File("./src/main/resources/background.png"));
    }

    // draws stationary (FIX REQUIRED)
    public BufferedImage getStationary() throws IOException {
        BufferedImage image = new BufferedImage(
                numCols*Constants.TILE_SIZE,
                numRows*Constants.TILE_SIZE,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
		for(int row=0 ; row<numRows ; row++) {
			for(int column=0 ; column<numCols ; column++) {
                Tile tile = controller.getStationary().get(row).get(column);
				if( !Objects.isNull(tile) && !tile.getSrcImage().equals("null") ) {
				    g.drawImage(
                        getSubImage(
                            ImageIO.read(new File("./src/main/resources/" + tile.getSrcImage())),
                            tile),
                        column*Constants.TILE_SIZE,
                        row*Constants.TILE_SIZE,
                        Constants.TILE_SIZE,
                        Constants.TILE_SIZE,
                        null);
                }
			}
		}
		g.dispose();
        return image;
	}

    /**
     * Returns a subimage from the provided base image based on the specified tile.
     * This method extracts a subimage from the given base image using the provided Tile object,
     * which includes information about the subimage's position.
     *
     * @param baseImage The base image from which to extract the subimage.
     * @param tile The Tile object representing the position of the subimage in the format "subImage_row_col".
     * @return The subimage corresponding to the specified Tile.
     * 
     */
    private BufferedImage getSubImage(BufferedImage baseImage, Tile tile) {
        return baseImage.getSubimage(
                tile.getX(), 
                tile.getY(),
                Constants.TILE_SIZE,
                Constants.TILE_SIZE);
    }

}
