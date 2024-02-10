package it.unibo.model.entity.player;

import it.unibo.commons.Constants;
import it.unibo.model.entity.EntityImpl;
import it.unibo.model.hitbox.RectangleHitbox;

/**
 * This class represents a specific implementation of the {@link EntityImpl} class for the MeatBoy entity.
 * It extends {@link EntityImpl} and specifies a hitbox of type {@link RectangleHitbox}, thereby implementing
 * the {@link MeatBoy} interface.
 */
public class MeatBoyImpl extends EntityImpl<RectangleHitbox> implements MeatBoy {

    /**
     * Represents the default speed value for the MeatBoy entity.
     * This value is used when no specific speed multiplier is set.
     */
    public static final double SPEED = 4;

    private double speedMul;

    /**
     * Constructs a MeatBoyImpl object with the specified coordinates.
     * 
     * @param x The x-coordinate of the MeatBoy.
     * @param y The y-coordinate of the MeatBoy.
     */
    public MeatBoyImpl(final double x, final double y) {
        super(x, y, new RectangleHitbox(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE)); 
        this.speedMul = 1;
    }

    /**
     * Retrieves the speed multiplier associated with this MeatBoy entity.
     *
     * @return The speed multiplier value.
     */
    @Override
    public double getSpeedMul() {
        return this.speedMul;
    }

    /**
     * Sets the speed multiplier associated with this MeatBoy entity to the specified value.
     *
     * @param speedMul The new value for the speed multiplier.
     */
    @Override
    public void setSpeedMul(final double speedMul) {
        this.speedMul = speedMul;
    }
}
