package it.unibo.model.entity;

/**
 * Entity
 */
public interface Entity {

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
     * Updates the status.
     * @param delta delta time
     */
    void update(double delta);

}