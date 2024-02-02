package it.unibo.model.level;

import java.net.URL;
import java.util.List;

import it.unibo.model.tiles.Tile;
import it.unibo.model.tiles.TileManager;
import it.unibo.model.tiles.TileManagerImpl;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;

public class LevelImpl implements Level{

    private final TileManager tileManager;
	private final MeatBoy meatBoy;

	private final BandageGirl bandageGirl;

	
	public LevelImpl(final URL urlMap) {
		this.tileManager = new TileManagerImpl(urlMap);
		this.meatBoy = tileManager.getMeatBoy();
		this.bandageGirl = tileManager.getBandageGirl();	
	}
	
	@Override
	public void update() {
	//if (meatBoy.getHitbox().win(bandageGirl)) {
		//	model.finish();
		//}
	}

	@Override
	public MeatBoy getMeatBoy() {
		return meatBoy;
	}

	@Override
	public BandageGirl getBandageGirl() {
		return bandageGirl;
	}

	@Override
	public List<List<Tile>> getStationary() {
		return this.tileManager.getStationary();
	}

	@Override
	public List<Platform> getPlatforms() {
		return this.tileManager.getPlatforms();
	}

	@Override
	public List<CircularSaw> getSaws() {
		return this.tileManager.getSaws();
	}

	@Override
	public int getNumCols() {
		return this.tileManager.getNumCols();
	}

	@Override
	public int getNumRows() {
		return this.tileManager.getNumRows();
	}

}
