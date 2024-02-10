package it.unibo.model.tiles.loader;
/**
 * The TileLoader interface is responsible for loading stationary tiles, platforms,
 * and circular saws from an XML document.
 */
public interface TileLoader {

    /**
     * Loads stationary tiles, platforms and circular saws from an XML document.
     * This method delegates to specific loading methods based on the type of tiles to be loaded.
     */
    void load();

}
