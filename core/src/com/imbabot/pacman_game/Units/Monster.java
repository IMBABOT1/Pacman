package com.imbabot.pacman_game.Units;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.imbabot.pacman_game.Helpers.Assets;
import Game.GameController;
import Game.GameMap;
import com.imbabot.pacman_game.Helpers.Utils;

public class Monster extends Unit{

    private int bestX = -1;
    private int bestY = -1;


    public Monster(GameController gc) {
        super(gc, MathUtils.random(10, 19), MathUtils.random(2, 8), true);
        this.texture = Assets.getInstance().getAtlas().findRegion("MonsterRed");
        this.movementMaxTime = 0.4f;
        this.movementTime = 0.0f;
    }


    public void activate(int cellX, int cellY){
        this.cellY = cellY;
        this.cellX = cellX;
    }


    @Override
    public void update(float dt) {
        int heroX = gc.getUnitController().getPackman().cellX;
        int heroY = gc.getUnitController().getPackman().cellY;
        if (Utils.getCellIntDistance(cellX, cellY, heroX, heroY) < 20) {
            move(dt, heroX, heroY);
        }else {
            int dx = -1;
            int dy = -1;
            do {
                dx = MathUtils.random(0, GameMap.getCellsX() - 1);
                dy = MathUtils.random(0, GameMap.getCellsY() - 1);
            }while (!isCellEmpty(dx, dy) && Utils.cellsIsNeighbors(cellX, cellY, dx, dy));
            move(dt, dx, dy);
        }
    }



    private void move(float dt, int prefX, int prefY){
        movementTime += dt;

        if (movementTime >= movementMaxTime) {
            float bestDst = 10000;
            for (int i = cellX - 1; i <= cellX + 1; i++) {
                for (int j = cellY - 1; j <= cellY + 1; j++) {
                    if (Utils.cellsIsNeighbors(cellX, cellY, i, j) && isCellEmpty(i, j)) {
                        float dst = (float) Math.sqrt((i - prefX) * (i - prefX) + (j - prefY) * (j - prefY));
                        if (dst < bestDst) {
                            bestDst = dst;
                            bestX = i;
                            bestY = j;
                        }
                    }
                }
            }
            movementTime = 0;
            cellX = bestX;
            cellY = bestY;
        }
    }




    public void render(SpriteBatch batch) {
        if (active) {
            batch.draw(texture, cellX * GameMap.CELL_SIZE, cellY * GameMap.CELL_SIZE);
        } else {
            cellX = 15;
            cellY = 5;
            active = true;
        }
    }
}