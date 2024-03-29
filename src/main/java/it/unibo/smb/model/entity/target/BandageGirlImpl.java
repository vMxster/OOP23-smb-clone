package it.unibo.smb.model.entity.target;

import it.unibo.smb.commons.Constants;
import it.unibo.smb.model.entity.EntityImpl;
import it.unibo.smb.model.hitbox.RectangleHitbox;

public class BandageGirlImpl extends EntityImpl<RectangleHitbox> implements BandageGirl {

    public BandageGirlImpl(final double x, final double y) {
        super(x, y, 
            new RectangleHitbox(
                x, 
                y, 
                (int) (Constants.TILE_SIZE * Constants.SCALE_PROPORTION), 
                (int) (Constants.TILE_SIZE * Constants.SCALE_PROPORTION)));
    }
}
