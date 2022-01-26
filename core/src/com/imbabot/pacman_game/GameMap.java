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
    private final int TOP_WALL = 2;

    public static int getCellsX() {
        return CELLS_X;
    }

    public static int getCellsY() {
        return CELLS_Y;
    }

    private byte[][] data;
    private TextureRegion grassTexture;
    private TextureRegion wallTexture;
    private TextureRegion topWall;

    public GameMap(TextureAtlas atlas){
        this.data = new byte[CELLS_X][CELLS_Y];
        this.grassTexture = atlas.findRegion("grass");
        this.wallTexture =  atlas.findRegion("wall");
        this.topWall = atlas.findRegion("topWall");
    }

    public boolean isCellPossible(float CX, float CY){
        if (CX < 0 || CX > getCellsX() - 1 || CY < 0 || CY > getCellsY() - 1){
            return false;
        }
        if (data[(int) CX][(int) CY] == TERRAIN_WALL){
            return false;
        }
        return true;
    }

    private final void generateMap(){
        for (int i = 0; i < CELLS_X; i++) {
            for (int j = 0; j < CELLS_Y  ; j++) {
                data[i][0] = 1;
                data[i][8] = 1;
                data[0][j] = 2;

                data[15][0] = 2;
                data[15][1] = 2;
                data[15][2] = 2;
                data[15][3] = 2;
                data[15][4] = 2;
                data[15][5] = 2;
                data[15][6] = 2;
                data[15][7] = 2;
                data[15][8] = 2;


                data[2][5] = 2;
                data[2][6] = 2;
                data[2][4] = 2;
                data[2][3] = 2;
                data[2][2] = 2;

                data[3][2] = 1;

                data[4][5] = 2;
                data[4][6] = 2;
                data[4][4] = 2;
                data[4][3] = 2;
                data[4][2] = 2;

                data[5][2] = 1;

                data[6][5] = 2;
                data[6][6] = 2;
                data[6][4] = 2;
                data[6][3] = 2;
                data[6][2] = 2;


                data[8][2] = 2;
                data[8][1] = 2;


                data[8][7] = 2;
                data[8][6] = 2;

                data[10][5] = 2;
                data[10][6] = 2;
                data[10][4] = 2;
                data[10][3] = 2;
                data[10][2] = 2;

                data[11][2] = 1;


                data[12][5] = 2;
                data[12][6] = 2;
                data[12][4] = 2;
                data[12][3] = 2;
                data[12][2] = 2;



            }
        }
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
        for (int i = 0; i < CELLS_X ; i++) {
            for (int j = 0; j < CELLS_Y ; j++) {
                if (data[i][j] == TOP_WALL){
                    batch.draw(topWall, i * CELL_SIZE, j * CELL_SIZE);
                }
            }
        }
    }

    public void update(float dt){
        generateMap();
    }
}