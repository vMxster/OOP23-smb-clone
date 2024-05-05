package it.unibo.smb.model.entity.obstacles.factory.laserbarrier;

import it.unibo.smb.model.entity.obstacles.LaserBarrier;

/**
 * An interface for factories that create laser barriers.
 */
public interface LaserBarrierFactory {
    /**
     * Creates a laser barrier with the specified position and dimensions.
     *
     * @param x The x-coordinate of the laser barrier's position.
     * @param y The y-coordinate of the laser barrier's position.
     * @param width The width of the laser barrier.
     * @param height The height of the laser barrier.
     * @return A new instance of LaserBarrier.
     */
    LaserBarrier createLaserBarrier(double x, double y, int width, int height);
}
