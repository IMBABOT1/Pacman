package com.imbabot.pacman_game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameMap {

    public static final int CELLS_X = 16;
    public static final int CELLS_Y = 9;
    public static final int CELL_SIZE = 80;

    private final int TERRAIN_GRASS = 0;
    private final int TERRAIN_WALL = 1;

    public static int getCellsX() {
        return CELLS_X;
    }

    public static int getCellsY() {
        return CELLS_Y;
    }



    private byte[][] data;
    private TextureRegion grassTexture;
    private TextureRegion wallTexture;

    public GameMap(TextureAtlas atlas){
        this.data = new byte[CELLS_X][CELLS_Y];
        this.grassTexture = atlas.findRegion("grass");
        this.wallTexture =  atlas.findRegion("walls");
        this.data[1][0] = TERRAIN_WALL;
        this.data[2][0] = TERRAIN_WALL;
        this.data[3][0] = TERRAIN_WALL;
        this.data[4][0] = TERRAIN_WALL;
        this.data[5][0] = TERRAIN_WALL;
        this.data[6][0] = TERRAIN_WALL;
        this.data[7][0] = TERRAIN_WALL;
        this.data[8][0] = TERRAIN_WALL;
        this.data[9][0] = TERRAIN_WALL;
        this.data[10][0] = TERRAIN_WALL;
        this.data[11][0] = TERRAIN_WALL;
        this.data[12][0] = TERRAIN_WALL;
        this.data[13][0] = TERRAIN_WALL;
        this.data[14][0] = TERRAIN_WALL;


    }

    public boolean isCellPossible(float CX, float CY){
        if (CX < 0 || CX > getCellsX() - 1 || CY < 0 || CY > getCellsY() - 1){
            return false;
        }
        return true;
    }




    public void render(SpriteBatch batch) {
        for (int i = 0; i < CELLS_X ; i++) {
            for (int j = 0; j < CELLS_Y ; j++) {
                if (data[i][j] == TERRAIN_GRASS)
                batch.draw(grassTexture, i * CELL_SIZE, j * CELL_SIZE);
            }
        }
        for (int i = 0; i < CELLS_X ; i++) {
            for (int j = 0; j < CELLS_Y ; j++) {
                if (data[i][j] == TERRAIN_WALL){
                    batch.draw(wallTexture, i * CELL_SIZE, j * CELL_SIZE);
                }
            }
        }
    }

    public void update(float dt){

    }
}