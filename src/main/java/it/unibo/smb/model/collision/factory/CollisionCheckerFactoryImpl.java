package it.unibo.smb.model.collision.factory;

import it.unibo.smb.model.collision.CollisionChecker;
import it.unibo.smb.model.collision.CollisionCheckerImpl;
import it.unibo.smb.model.collision.CollisionHandler;

/**
 * An implementation of the CollisionCheckerFactory interface.
 */
public class CollisionCheckerFactoryImpl implements CollisionCheckerFactory {
    @Override
    public final CollisionChecker createCollisionChecker(final CollisionHandler collisionHandler) {
        return new CollisionCheckerImpl(collisionHandler);
    }
}
