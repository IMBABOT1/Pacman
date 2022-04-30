package Game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.imbabot.pacman_game.Helpers.Assets;

public class GameMap {

    public static final int CELLS_X = 21;
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


    public GameMap(){
        this.data = new byte[CELLS_X][CELLS_Y];
        this.grassTexture = Assets.getInstance().getAtlas().findRegion("grass");
        this.wallTexture =  Assets.getInstance().getAtlas().findRegion("wall");
        this.topWall = Assets.getInstance().getAtlas().findRegion("topWall");
    }

    public boolean isCellPossible(float CX, float CY){
        if (CX < 0 || CX > getCellsX() - 1 || CY < 0 || CY > getCellsY() - 1){
            return false;
        }
        if (data[(int) CX][(int) CY] == TERRAIN_WALL){
            return false;
        }
        if (data[(int) CX][(int) CY] == TOP_WALL){
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

                data[20][0] = 2;
                data[20][1] = 2;
                data[20][2] = 2;
                data[20][3] = 2;
                data[20][4] = 2;
                data[20][5] = 2;
                data[20][6] = 2;
                data[20][7] = 2;
                data[20][8] = 2;

                data[20][4] = 0;
                data[0][4] = 0;


                data[2][5] = 2;
                data[2][6] = 2;
                data[2][4] = 2;
                data[2][3] = 2;
                data[2][2] = 2;



                data[4][5] = 2;
                data[4][6] = 2;
                data[4][4] = 2;
                data[4][3] = 2;
                data[4][2] = 2;

                data[6][5] = 2;
                data[6][6] = 2;
                data[6][4] = 2;
                data[6][3] = 2;
                data[6][2] = 2;



                data[8][5] = 2;
                data[8][6] = 2;
                data[8][4] = 2;
                data[8][3] = 2;
                data[8][2] = 2;


                data[10][2] = 2;
                data[10][1] = 2;


                data[10][7] = 2;
                data[10][6] = 2;

                data[12][5] = 2;
                data[12][6] = 2;
                data[12][4] = 2;
                data[12][3] = 2;
                data[12][2] = 2;


                data[14][5] = 2;
                data[14][6] = 2;
                data[14][4] = 2;
                data[14][3] = 2;
                data[14][2] = 2;



                data[16][5] = 2;
                data[16][6] = 2;
                data[16][4] = 2;
                data[16][3] = 2;
                data[16][2] = 2;

                data[18][5] = 2;
                data[18][6] = 2;
                data[18][4] = 2;
                data[18][3] = 2;
                data[18][2] = 2;


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