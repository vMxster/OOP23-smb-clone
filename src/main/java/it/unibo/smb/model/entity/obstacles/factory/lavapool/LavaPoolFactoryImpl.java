package it.unibo.smb.model.entity.obstacles.factory.lavapool;

import it.unibo.smb.model.entity.obstacles.LavaPool;
import it.unibo.smb.model.entity.obstacles.LavaPoolImpl;

/**
 * An implementation of the LavaPoolFactory interface.
 */
public class LavaPoolFactoryImpl implements LavaPoolFactory {
    @Override
    public final LavaPool createLavaPool(final double x, final double y, final int width, final int height) {
        return new LavaPoolImpl(x, y, width, height);
    }
}
