package it.unibo.model.tiles;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import it.unibo.commons.Point2D;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.target.BandageGirl;

/**
 * The TileManager interface represents a manager for handling tiles in a game.
 * It provides methods to load and manage a tile map from a specified TMX file.
 */
public interface TileManager {

    /**
     * Parses the TMX file and populates the tile map with background, foreground, stationary objects,
     * and additional game elements such as platforms, circular saws, and player starting coordinates.
     * This method is responsible for initializing the internal state of the TileManager based on the
     * contents of the TMX file.
     *
     * @throws XPathExpressionException if an XPath expression error occurs during parsing.
     * @throws SAXException if a SAX parsing error occurs during the document parsing.
     * @throws ParserConfigurationException if a configuration error occurs while creating the DocumentBuilder.
     * @throws IOException if an I/O error occurs while reading the TMX file.
     */
    void loadMap() throws XPathExpressionException, SAXException, ParserConfigurationException, IOException;

    /**
     * Returns the ArrayList of Platforms parsed from the TMX file.
     *
     * @return The ArrayList of Platforms parsed from the TMX file.
     */
    List<Platform> getPlatforms();

    /**
     * Returns the ArrayList of CircularSaws parsed from the TMX file.
     *
     * @return The ArrayList of CircularSaws parsed from the TMX file.
     */
    List<CircularSaw> getSaws();

    /**
     * Returns the number of columns in the TileMap.
     *
     * @return The number of columns in the TileMap.
     */
    int getNumCols();

    /**
     * Returns the number of rows in the TileMap.
     *
     * @return The number of rows in the TileMap.
     */
    int getNumRows();

    /**
     * Returns the starting position of the player.
     *
     * @return The starting position of the player.
     */
    Point2D<Integer, Integer> getPlayerCoordStart();

    /**
     * Returns the BandageGirl object parsed from the TMX file.
     *
     * @return The BandageGirl object parsed from the TMX file.
     */
    BandageGirl getBandageGirl();
    
}
