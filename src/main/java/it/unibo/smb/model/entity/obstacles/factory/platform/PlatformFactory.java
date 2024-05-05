package it.unibo.smb.model.entity.obstacles.factory.platform;

import it.unibo.smb.model.entity.obstacles.Platform;

/**
 * Interface representing a factory for creating Platform objects.
 */
public interface PlatformFactory {
    /**
     * Creates a new Platform object with the specified parameters.
     *
     * @param x      The x-coordinate of the top-left corner of the platform.
     * @param y      The y-coordinate of the top-left corner of the platform.
     * @param width  The width of the platform.
     * @param height The height of the platform.
     * @return The newly created Platform object.
     */
    Platform createPlatform(double x, double y, int width, int height);
}
