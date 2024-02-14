package it.unibo.view.imagerenderer.factory.gameobjects;

import it.unibo.view.imagerenderer.gameobjects.ImageRendererSaws;

public interface ImageRendererSawsFactory {

    ImageRendererSaws createImageRendererSaws(int numRows, int numColumns);

}

