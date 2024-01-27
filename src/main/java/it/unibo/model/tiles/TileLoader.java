package it.unibo.model.tiles;

import java.util.List;

/**
 * The TileLoader interface provides methods for loading various types of tiles, 
 * stationary elements, platforms, and circular saws from an XML document 
 * into corresponding lists or instances.
 */
public interface TileLoader {

    /**
     * Loads tiles from the specified layer in the XML document into the given tileList.
     * Parses the specified layer in the document and populates the tileList with the extracted tiles.
     *
     * @param tileList The list to populate with tiles. It is a List of Lists of Tile objects.
     * @param layerNameToParse The name of the layer in the XML document to be parsed.
     */
    void loadTiles(final List<List<Tile>> tileList, final String layerNameToParse);

    /**
 	 * Loads stationary tiles from the XML document into the stationary list.
 	 * Parses the specified layer in the document and populates the stationary list.
 	 */
    void loadStationaryTiles();

    /**
 	 * Loads Platform objects from the XML document.
 	 * Parses the "rectangle" object group in the document and creates Platform instances.
 	 */
    void loadPlatforms();

    /**
 	 * Loads CircularSaw objects from the XML document.
 	 * Parses the "saws" object group in the document and creates CircularSaw instances.
 	 */
    void loadCircularSaws();
    
}
