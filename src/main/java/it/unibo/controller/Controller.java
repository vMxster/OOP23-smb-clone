package it.unibo.controller;

import java.util.List;

import it.unibo.model.tiles.Tile;

public interface Controller {

    List<List<Tile>> getBackground();

    List<List<Tile>> getForeground();

    List<List<Tile>> getStationary();

    String getTmxURL();

    int getNumRow();

    int getNumCols();
    
}
