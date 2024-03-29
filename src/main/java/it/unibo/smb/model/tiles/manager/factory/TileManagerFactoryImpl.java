package it.unibo.smb.model.tiles.manager.factory;

import it.unibo.smb.model.tiles.manager.TileManager;
import it.unibo.smb.model.tiles.manager.TileManagerImpl;

/**
 * The TileManagerFactoryImpl class is an implementation of the TileManagerFactory interface.
 * It provides functionality to create TileManager objects based on the provided TMX (Tile Map XML).
 */
public class TileManagerFactoryImpl implements TileManagerFactory {

    @Override
    public final TileManager createTileManager(final String tmx) {
        return new TileManagerImpl(tmx);
    }

}
