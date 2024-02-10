package it.unibo.model.entity;

import it.unibo.model.hitbox.Hitbox;

/**
 * This class represents an implementation of the {@link Entity} interface. It encapsulates
 * functionality related to entities in a game or simulation context, providing support for
 * hitboxes of generic type {@code H}.
 *
 * @param <H> The type parameter specifying the type of hitbox associated with this entity.
 *            This allows for flexibility in defining various hitbox types.
 */
public class EntityImpl<H extends Hitbox<?>> implements Entity<H> {

    private double x;
    private double y;
    private H hitbox;

    /**
     * Constructs an EntityImpl object with the specified coordinates and hitbox.
     *
     * @param x      The x-coordinate of the entity.
     * @param y      The y-coordinate of the entity.
     * @param hitbox The hitbox associated with the entity.
     */
    public EntityImpl(final double x, final double y, final H hitbox) {
        this.x = x;
        this.y = y;
        this.hitbox = hitbox;
    }

    /**
     * Retrieves the x-coordinate of the entity.
     *
     * @return The x-coordinate of the entity.
     */
    @Override
    public double getX() {
        return this.x;
    }

    /**
     * Retrieves the y-coordinate of the entity.
     *
     * @return The y-coordinate of the entity.
     */
    @Override
    public double getY() {
        return this.y;
    }

    /**
     * Retrieves the hitbox of the entity.
     *
     * @return The hitbox of the entity.
     */
    @Override
    public H getHitbox() {
        return this.hitbox;
    }

    /**
    * Sets the x-coordinate of the entity to the specified value.
    *
    * @param x The new x-coordinate of the entity.
    */
    @Override
    public void setX(final double x) {
        this.hitbox.updatePosition(x, this.y);
        this.x = x;
    }

    /**
    * Sets the y-coordinate of the entity to the specified value.
    *
    * @param y The new y-coordinate of the entity.
    */
    @Override
    public void setY(final double y) {
        this.hitbox.updatePosition(this.x, y);
        this.y = y;
    }
}
