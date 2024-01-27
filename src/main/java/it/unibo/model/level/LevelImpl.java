package it.unibo.model.level;

import java.net.URL;
import java.util.List;

import it.unibo.commons.Constants;
import it.unibo.model.entity.player.MeatBoyImpl;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.tiles.TileManager;
import it.unibo.model.tiles.TileManagerImpl;
import it.unibo.model.GameModel;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;

public class LevelImpl implements Level{

	private final GameModel model;
    private final TileManager tileManager;
    private final List<Platform> platforms;
	private final List<CircularSaw> circularSaws;
    private final BandageGirl bandageGirl;
	private final MeatBoy meatBoy;
	private final int widthLevel;
	private final int heightLevel;

	public LevelImpl(final GameModel model, final URL urlMap) {
 		this.model = model;
		this.tileManager = new TileManagerImpl(urlMap);
		this.platforms = tileManager.getPlatforms();
		this.circularSaws = tileManager.getSaws();
		this.meatBoy = new MeatBoyImpl(tileManager.getPlayerCoordStart().getX(), tileManager.getPlayerCoordStart().getY(), Constants.TILE_SIZE, Constants.TILE_SIZE);
		this.bandageGirl = tileManager.getBandageGirl();
		this.widthLevel = tileManager.getNumCols() * Constants.TILE_SIZE;
		this.heightLevel = tileManager.getNumRows() * Constants.TILE_SIZE;
	}
	
	@Override
	public void update() {
		//if(meatBoy.getHitbox().intersects(bandageGirl.getHitbox())) {
		//	model.finished();
		//}
	}

	@Override
	public List<Platform> getPlatforms() {
		return this.platforms;
	}

	@Override
	public List<CircularSaw> getCircularSaws() {
		return this.circularSaws;
	}

	@Override
	public int getWidthLevel() {
		return this.widthLevel;
	}

	@Override
	public int getHeightLevel() {
		return this.heightLevel;
	}

	@Override
	public TileManager getTileManager() {
		return this.tileManager;
	}

}
