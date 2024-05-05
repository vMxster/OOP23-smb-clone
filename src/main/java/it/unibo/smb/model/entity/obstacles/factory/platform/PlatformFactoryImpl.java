package it.unibo.smb.model.entity.obstacles.factory.platform;

import it.unibo.smb.model.entity.obstacles.Platform;
import it.unibo.smb.model.entity.obstacles.PlatformImpl;

/**
 * Implementation of the PlatformFactory interface for creating Platform objects.
 */
public class PlatformFactoryImpl implements PlatformFactory {
    @Override
    public final Platform createPlatform(final double x, final double y, final int width, final int height) {
        return new PlatformImpl(x, y, width, height);
    }
}
