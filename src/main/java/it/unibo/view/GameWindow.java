package it.unibo.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import it.unibo.commons.Constants;
import it.unibo.commons.input.KeyboardInput;
import it.unibo.controller.Controller;
import it.unibo.model.tiles.Tile;

public class GameWindow extends JFrame {

    private final Controller controller;
    private final int numRows;
    private final int numCols;

    public GameWindow(final Controller controller) throws IOException {
        this.controller = controller;
        this.numRows = controller.getNumRow();
        this.numCols = controller.getNumCols();
        GamePanel panel = new GamePanel();
        panel.setLocation(0,0);
        panel.setSize(this.getSize());
        panel.setBackground(Color.CYAN);
        this.setContentPane(panel);

        addKeyListener(new KeyboardInput(panel));
        BufferedImage background = drawMap();   // TBD the position
    }

    // draws all the Map (bg,fg,platforms)
    public BufferedImage drawMap() throws IOException{
        BufferedImage image = new BufferedImage(
                numCols*Constants.TILE_SIZE,
                numRows*Constants.TILE_SIZE,
                BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) image.getGraphics();
		for(int row=0 ; row<numRows ; row++) {
			for(int column=0 ; column<numCols ; column++) {
                Tile tile = controller.getBackground().get(row).get(column);
				if( !Objects.isNull(tile) ) {
                    g.drawImage(
                        getSubImageByIdentifier(
                            ImageIO.read(new File("./src/main/resources/" + tile.getSrcImage())),
                            tile.getIdentifier()),
                        column*Constants.TILE_SIZE,
                        row*Constants.TILE_SIZE,
                        Constants.TILE_SIZE,
                        Constants.TILE_SIZE,
                        null);
                }
			}
		}
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
		for(int row=0 ; row<numRows ; row++) {
			for(int column=0 ; column<numCols ; column++) {
                Tile tile = controller.getForeground().get(row).get(column);
				if( !Objects.isNull(tile) ) {
				    g.drawImage(
                        getSubImageByIdentifier(
                            ImageIO.read(new File("./src/main/resources/" + tile.getSrcImage())),
                            tile.getIdentifier()),
                        column*Constants.TILE_SIZE,
                        row*Constants.TILE_SIZE,
                        Constants.TILE_SIZE,
                        Constants.TILE_SIZE,
                        null);
                }
			}
		}
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
		for(int row=0 ; row<numRows ; row++) {
			for(int column=0 ; column<numCols ; column++) {
                Tile tile = controller.getStationary().get(row).get(column);
				if( !Objects.isNull(tile) ) {
				    g.drawImage(
                        getSubImageByIdentifier(
                            ImageIO.read(new File("./src/main/resources/" + tile.getSrcImage())),
                            tile.getIdentifier()),
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
     * Returns the subimage associated with an identifier from the baseImage.
     *
     * @param baseImage The base image from which to extract the subimage.
     * @param identifier The identifier of the subimage in the format "subImage_row_col".
     * @return The subimage corresponding to the identifier.
     */
    private BufferedImage getSubImageByIdentifier(BufferedImage baseImage, String identifier) {
        String[] parts = identifier.split("_");

        return baseImage.getSubimage(
                Integer.parseInt(parts[1]), 
                Integer.parseInt(parts[2]),
                Constants.TILE_SIZE,
                Constants.TILE_SIZE);
    }

}
