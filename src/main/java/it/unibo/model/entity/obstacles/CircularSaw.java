package it.unibo.model.entity.obstacles;

import it.unibo.model.entity.Entity;

public interface CircularSaw extends Entity{
    
    /**
     * @return range of action of the saw
     */
    double getRadius();
}