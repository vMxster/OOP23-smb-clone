package it.unibo.model.entity;

/**
 * The Entity interface represents an Entity.
 */
public interface Entity<H> {

    /**
     *
     * @return Returns the X coordinate of the entity.
     */
    double getX();

    /**
     *
     * @return Returns the Y coordinate of the entity.
     */
    double getY();

    /**
     * 
     * @return Returns the hitbox of the entity.
     */
    H getHitbox();

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
}