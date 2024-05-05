package it.unibo.smb.model.collision.factory;

import it.unibo.smb.model.collision.CollisionChecker;
import it.unibo.smb.model.collision.CollisionHandler;

/**
 * An interface for factories that create collision checkers.
 */
public interface CollisionCheckerFactory {
    /**
     * Creates a collision checker with the provided collision handler.
     *
     * @param collisionHandler The collision handler to be associated with the collision checker.
     * @return A new instance of CollisionChecker.
     */
    CollisionChecker createCollisionChecker(CollisionHandler collisionHandler);
}
