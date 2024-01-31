package it.unibo.model.collision;

import java.util.List;

import it.unibo.model.GameModel;
import it.unibo.model.hitbox.CircularHitbox;
import it.unibo.model.hitbox.RectangleHitbox;

public class CollisionCheckerImpl implements CollisionChecker{

    private List<CircularHitbox> sawsHitboxs;
    private List<RectangleHitbox> platformsHitboxs;
    private RectangleHitbox bandageGirlHitbox;

    public CollisionCheckerImpl(GameModel level) {
        this.sawsHitboxs = level.getSaws().stream().map(t -> t.getHitbox()).toList();
        this.platformsHitboxs = level.getPlatforms().stream().map(t -> t.getHitbox()).toList();
        this.bandageGirlHitbox = level.getBandageGirl().getHitbox();
    }

    @Override
    public CollisionState isColliding(RectangleHitbox mbHitbox) {
        if (this.platformsHitboxs.stream()
                .map(h -> h.getHitbox())
                .filter(h -> h.intersects(mbHitbox.getHitbox()))
                .count() > 0) {
            return CollisionState.GROUND;
        } else if (this.sawsHitboxs.stream()
                .map(h -> h.getHitbox())
                .filter(h -> h.intersects(mbHitbox.getHitbox()))
                .count() > 0) {
            return CollisionState.SAW;
        } else if (this.bandageGirlHitbox.getHitbox().intersects(mbHitbox.getHitbox())) {
            return CollisionState.BANDAGE_GIRL;
        } 
        return null;
    }
    
}
