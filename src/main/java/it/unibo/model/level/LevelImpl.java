package it.unibo.model.level;

import java.util.List;

import it.unibo.model.tiles.Tile;
import it.unibo.model.tiles.TileManager;
import it.unibo.model.tiles.TileManagerImpl;
import it.unibo.commons.Point2D;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.target.BandageGirl;

public class LevelImpl implements Level{

    private final TileManager tileManager;
	private final MeatBoy meatBoy;
	private final BandageGirl bandageGirl;
	private final Point2D<Double,Double> meatBoyStartCoord;
	
	public LevelImpl(final String tmx) {
		this.tileManager = new TileManagerImpl(tmx);
		this.meatBoy = tileManager.getMeatBoy();
		this.bandageGirl = tileManager.getBandageGirl();
		this.meatBoyStartCoord = new Point2D<>(meatBoy.getX(), meatBoy.getY());
	}

	@Override
	public MeatBoy getMeatBoy() {
		return this.meatBoy;
	}

	@Override
	public Point2D<Double,Double> getMeatBoyStartCoord() {
		return this.meatBoyStartCoord;
	}

	@Override
	public BandageGirl getBandageGirl() {
		return this.bandageGirl;
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
