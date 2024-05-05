package it.unibo.smb.model.tiles.loader.gameobjects;

import java.util.stream.IntStream;

import it.unibo.smb.model.entity.obstacles.factory.circularsaw.CircularSawFactoryImpl;
import it.unibo.smb.model.entity.obstacles.factory.laserbarrier.LaserBarrierFactoryImpl;
import it.unibo.smb.model.entity.obstacles.factory.lavapool.LavaPoolFactoryImpl;
import it.unibo.smb.model.entity.obstacles.factory.platform.PlatformFactoryImpl;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.smb.commons.Constants;
import it.unibo.smb.model.documentextractor.DocumentExtractor;
import it.unibo.smb.model.documentextractor.TagType;
import it.unibo.smb.model.tiles.loader.manager.GameObjectType;
import it.unibo.smb.model.tiles.loader.manager.TileLoaderManager;

/**
 * The TileLoaderGameObjects class is responsible for loading various types of game objects
 * from the TMX file and populating the TileLoaderManager with saws, platforms, lava pools,
 * and laser barriers.
 */
public class TileLoaderGameObjectsImpl implements TileLoaderGameObjects {

    private final TileLoaderManager tileLoaderManager;
    private final DocumentExtractor documentExtractor;

    /**
     * Constructs a TileLoaderGameObjectsImpl with the specified TileLoaderManager
     * and DocumentExtractor.
     *
     * @param tileLoaderManager  The tile loader manager.
     * @param documentExtractor The document extractor.
     */
    @SuppressFBWarnings(value = "EI2", justification =
                "Justification for Suppressing SpotBugs Warning:\r\n"
                + //
                "The SpotBugs warning \"EI2\" indicates that a mutable object (tileLoaderManager)\r\n"
                + //
                "is being stored without defensively copying its contents. In this context, the\r\n"
                + //
                "tileLoaderManager object is used solely for internal use within the\r\n"
                + //
                "TileLoaderGameObjectsImpl class and for initializing its internal state. It's not\r\n"
                + //
                "exposed to external code, and no modifications are made to it after initialization.\r\n"
                + //
                "Therefore, there's no risk of unintended modification by external code or concurrent\r\n"
                + //
                "access issues. Suppressing this warning is justified as it accurately reflects the\r\n"
                + //
                "intentional design and usage of the tileLoaderManager object within this class.")
    public TileLoaderGameObjectsImpl(final TileLoaderManager tileLoaderManager, final DocumentExtractor documentExtractor) {
        this.tileLoaderManager = tileLoaderManager;
        this.documentExtractor = documentExtractor;
    }

    /**
     * Loads various types of game objects from the game map document into the game world.
     * This method sequentially loads objects of different types, including saws, platforms, lava pools,
     * and laser barriers, into the game world.
     */
    @Override
    public void load() {
        this.loadObjects(GameObjectType.SAWS);
        this.loadObjects(GameObjectType.PLATFORMS);
        this.loadObjects(GameObjectType.LAVAPOOL);
        this.loadObjects(GameObjectType.LASERBARRIER);
    }

    /**
     * Loads objects of a specified type from the game map document and adds them to the game world.
     *
     * @param nameObjects The type of game objects to be loaded.
     */
    private void loadObjects(final GameObjectType nameObjects) {
        final NodeList objects = documentExtractor.getElements(TagType.OBJECTGROUP);
        IntStream.range(0, objects.getLength())
            .mapToObj(i -> (Element) objects.item(i))
            .toList().stream()
                .filter(node -> nameObjects.toString()
                    .equals(node.getAttribute(TagType.NAME.toString())))
                .findFirst()
                .ifPresent(objectGroupElement -> {
                    final NodeList objectsInGroup = objectGroupElement
                        .getElementsByTagName(TagType.OBJECT.toString());
                    IntStream.range(0, objectsInGroup.getLength())
                        .mapToObj(i -> (Element) objectsInGroup.item(i))
                        .toList()
                            .forEach(objectElement -> {
                                final int x = Integer.parseInt(
                                    this.tileLoaderManager.trim(
                                        objectElement
                                            .getAttribute(TagType.X.toString())));
                                final int y = Integer.parseInt(
                                    this.tileLoaderManager.trim(
                                        objectElement
                                            .getAttribute(TagType.Y.toString())));
                                final int width = Integer.parseInt(
                                    this.tileLoaderManager.trim(
                                        objectElement
                                            .getAttribute(TagType.WIDTH.toString())));
                                final int height = Integer.parseInt(
                                    this.tileLoaderManager.trim(objectElement
                                            .getAttribute(TagType.HEIGHT.toString())));
                                addGameObject(nameObjects, x, y, width, height);
                            });
                });
    }

    /**
     * Adds a new game object to the game world.
     *
     * @param nameObjects The type of game object to be added.
     * @param x The x-coordinate of the game object's position.
     * @param y The y-coordinate of the game object's position.
     * @param width The width of the game object.
     * @param height The height of the game object.
     */
    private void addGameObject(final GameObjectType nameObjects, final int x, final int y, final int width, final int height) {
        if (GameObjectType.SAWS.equals(nameObjects)) {
            this.tileLoaderManager.setSaw(new CircularSawFactoryImpl()
                    .createCircularSaw(
                        x * Constants.SCALE_PROPORTION,
                        y * Constants.SCALE_PROPORTION,
                        (int) (width * Constants.SCALE_PROPORTION)));
        } else if (GameObjectType.LAVAPOOL.equals(nameObjects)) {
            this.tileLoaderManager.setLavaPool(new LavaPoolFactoryImpl()
                    .createLavaPool(
                        x * Constants.SCALE_PROPORTION,
                        y * Constants.SCALE_PROPORTION,
                        (int) (width * Constants.SCALE_PROPORTION),
                        (int) (height * Constants.SCALE_PROPORTION)));
        } else if (GameObjectType.LASERBARRIER.equals(nameObjects)) {
            this.tileLoaderManager.setLaserBarrier(new LaserBarrierFactoryImpl()
                    .createLaserBarrier(
                        x * Constants.SCALE_PROPORTION,
                        y * Constants.SCALE_PROPORTION,
                        (int) (width * Constants.SCALE_PROPORTION),
                        (int) (height * Constants.SCALE_PROPORTION)));
        } else {
            this.tileLoaderManager.setPlatform(new PlatformFactoryImpl()
                    .createPlatform(
                        x * Constants.SCALE_PROPORTION,
                        y * Constants.SCALE_PROPORTION,
                        (int) (width * Constants.SCALE_PROPORTION),
                        (int) (height * Constants.SCALE_PROPORTION)));
        }
    }

}
