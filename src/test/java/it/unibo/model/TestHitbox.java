package it.unibo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.commons.Constants;
import it.unibo.model.collision.CollisionChecker;
import it.unibo.model.collision.CollisionCheckerImpl;
import it.unibo.model.collision.CollisionChecker.CollisionState;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.player.MeatBoyImpl;

public class TestHitbox {

    private URL urlMap;
    private GameModel gameModel;
    private CollisionChecker collisionChecker;
    private MeatBoy meatBoy;

    @BeforeEach 
    public void init() throws MalformedURLException {
        this.urlMap = new URL("file:./src/main/resources/factory1.tmx");
        assertNotNull(this.urlMap);
        this.gameModel = new GameModelImpl(urlMap);
        assertNotNull(this.gameModel);
        this.meatBoy = new MeatBoyImpl(0, 0, Constants.TILE_SIZE, Constants.TILE_SIZE);
        assertNotNull(this.meatBoy);
        this.collisionChecker = new CollisionCheckerImpl(gameModel);
        assertNotNull(this.collisionChecker);
    }

    @Test
    void testCollider(){
        assertEquals(CollisionState.GROUND, this.collisionChecker.isColliding());
        meatBoy.setX(660);
        meatBoy.setY(380);
        assertEquals(CollisionState.BANDAGE_GIRL, this.collisionChecker.isColliding());
        meatBoy.setX(150);
        meatBoy.setY(500);
        assertEquals(CollisionState.GROUND, this.collisionChecker.isColliding());
        meatBoy.setX(400);
        meatBoy.setY(250);
        assertEquals(CollisionState.SAW, this.collisionChecker.isColliding());
    }
}
