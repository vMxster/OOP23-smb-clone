package it.unibo.model.entity.obstacles;

import java.awt.Graphics2D;

public interface Platform {
    /**
     * @return X coordinate
     */
    double getX();

    /**
     * @return Y coordinate
     */
    double getY();

    /**
     * @return the width of the entity
     */
    double getWidth();

    /**
     * @return the height of the entity
     */
    double getHeight();

    /**
     * 
     * @param g
     */
    void draw(Graphics2D g);
}
