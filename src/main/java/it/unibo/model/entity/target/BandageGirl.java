package it.unibo.model.entity.target;

import it.unibo.model.entity.Entity;

public interface BandageGirl extends Entity {
    
    /**
     * Meat boy touch bandage girl.
     */
    void touch();

    /**
     * @return true if she has been touched.
     */
    boolean isTouched();
}
