package it.unibo.smb.model.entity.obstacles.factory.circularsaw;

import it.unibo.smb.model.entity.obstacles.CircularSaw;
import it.unibo.smb.model.entity.obstacles.CircularSawImpl;

/**
 * An implementation of the CircularSawFactory interface.
 */
public class CircularSawFactoryImpl implements CircularSawFactory {
    @Override
    public final CircularSaw createCircularSaw(final double x, final double y, final int radius) {
        return new CircularSawImpl(x, y, radius);
    }
}
