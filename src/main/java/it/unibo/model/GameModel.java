package it.unibo.model;

import java.util.List;

import it.unibo.model.tiles.Tile;

public interface GameModel {

    List<List<Tile>> getBackground();

    List<List<Tile>> getStationary();

    int getNumRows();

    int getNumCols();

    List<List<Tile>> getForeground();
    
}
