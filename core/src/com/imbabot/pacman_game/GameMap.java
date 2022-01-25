package com.imbabot.pacman_game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameMap {

    public static final int CELLS_X = 16;
    public static final int CELLS_Y = 9;
    public static final int CELL_SIZE = 80;

    private byte[][] data;
    private TextureRegion grassTexture;

    public GameMap(TextureAtlas atlas){
        this.data = new byte[CELLS_X][CELLS_Y];
        this.grassTexture = atlas.findRegion("grass");
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < CELLS_X ; i++) {
            for (int j = 0; j < CELLS_Y ; j++) {
                batch.draw(grassTexture, i * CELL_SIZE, j * CELL_SIZE);
            }
        }
    }

    public void update(float dt){

    }
}
