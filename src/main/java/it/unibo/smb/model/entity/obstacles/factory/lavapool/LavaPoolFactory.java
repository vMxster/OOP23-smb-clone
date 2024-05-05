package it.unibo.smb.model.entity.obstacles.factory.lavapool;

import it.unibo.smb.model.entity.obstacles.LavaPool;

/**
 * An interface for factories that create lava pools.
 */
public interface LavaPoolFactory {
    /**
     * Creates a lava pool with the specified position and dimensions.
     *
     * @param x The x-coordinate of the lava pool's position.
     * @param y The y-coordinate of the lava pool's position.
     * @param width The width of the lava pool.
     * @param height The height of the lava pool.
     * @return A new instance of LavaPool.
     */
    LavaPool createLavaPool(double x, double y, int width, int height);
}
