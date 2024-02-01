package it.unibo.model.entity;

import java.awt.Graphics2D;

/**
 * The Entity interface represents an Entity.
 */
public interface Entity<H> {

    /**
     * Gets the X coordinate of the entity.
     *
     * @return The X coordinate.
     */
    double getX();

    /**
     * Gets the Y coordinate of the entity.
     *
     * @return The Y coordinate.
     */
    double getY();

    /**
     * Sets the X coordinate of the entity.
     *
     * @param x The new X coordinate.
     */
    void setX(final double x);

    /**
     * Sets the Y coordinate of the entity.
     *
     * @param y The new Y coordinate.
     */
    void setY(final double y);

    /**
     * Gets the width of the entity.
     *
     * @return The width of the entity.
     */
    double getWidth();

    /**
     * Gets the height of the entity.
     *
     * @return The height of the entity.
     */
    double getHeight();

    /**
     * Draws the entity using the provided {@code Graphics2D} object.
     *
     * @param g The {@code Graphics2D} object to draw the entity.
     */
    void draw(Graphics2D g);
    
    H getHitbox();
}