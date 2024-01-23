package it.unibo.model.entity;

import java.awt.Graphics2D;

/**
 * Entity
 */
public interface Entity {

    /**
     * @return X coordinate.
     */
    double getX();

    /**
     * @return Y coordinate.
     */
    double getY();

    /**
     * @return the width of the entity.
     */
    double getWidth();

    /**
     * @return the height of the entity.
     */
    double getHeight();

    /**
     * @param g graphic to draw.
     */
    void draw(Graphics2D g);
}