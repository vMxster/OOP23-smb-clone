package it.unibo.smb.model.entity.obstacles.factory.laserbarrier;

import it.unibo.smb.model.entity.obstacles.LaserBarrier;
import it.unibo.smb.model.entity.obstacles.LaserBarrierImpl;

/**
 * An implementation of the LaserBarrierFactory interface.
 */
public class LaserBarrierFactoryImpl implements LaserBarrierFactory {
    @Override
    public final LaserBarrier createLaserBarrier(final double x, final double y, final int width, final int height) {
        return new LaserBarrierImpl(x, y, width, height);
    }
}
