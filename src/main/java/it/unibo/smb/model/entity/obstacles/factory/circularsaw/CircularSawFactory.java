package it.unibo.smb.model.entity.obstacles.factory.circularsaw;

import it.unibo.smb.model.entity.obstacles.CircularSaw;

/**
 * An interface for factories that create circular saw obstacles.
 */
public interface CircularSawFactory {
    /**
     * Creates a circular saw obstacle with the specified position and radius.
     *
     * @param x The x-coordinate of the circular saw's position.
     * @param y The y-coordinate of the circular saw's position.
     * @param radius The radius of the circular saw.
     * @return A new instance of CircularSaw.
     */
    CircularSaw createCircularSaw(double x, double y, int radius);
}
