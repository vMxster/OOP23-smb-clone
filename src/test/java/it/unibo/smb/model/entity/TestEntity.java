package it.unibo.smb.model.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.unibo.smb.model.entity.obstacles.CircularSaw;
import it.unibo.smb.model.entity.obstacles.CircularSawImpl;
import it.unibo.smb.model.entity.obstacles.Platform;
import it.unibo.smb.model.entity.obstacles.PlatformImpl;
import it.unibo.smb.model.entity.player.MeatBoy;
import it.unibo.smb.model.entity.player.MeatBoyImpl;
import it.unibo.smb.model.entity.target.BandageGirl;
import it.unibo.smb.model.entity.target.BandageGirlImpl;
import it.unibo.smb.model.hitbox.CircularHitbox;
import it.unibo.smb.model.hitbox.RectangleHitbox;

class TestEntity {

    @Test
    void testMeatBoy() {
        final MeatBoy meatBoy = new MeatBoyImpl(0, 0);
        assertEquals(RectangleHitbox.class, meatBoy.getHitbox().getClass());
    }

    @Test
    void testBandageGirl() {
        final BandageGirl bandageGirl = new BandageGirlImpl(0, 0);
        assertEquals(RectangleHitbox.class, bandageGirl.getHitbox().getClass());
    }

    @Test
    void testCircularSaw() {
        final CircularSaw circularSaw = new CircularSawImpl(0, 0, 10);
        assertEquals(CircularHitbox.class, circularSaw.getHitbox().getClass());
    }

    @Test
    void testPlatform() {
        final Platform platform = new PlatformImpl(0, 0, 100, 20);
        assertEquals(RectangleHitbox.class, platform.getHitbox().getClass());
    }
}
