package com.imbabot.pacman_game.Food;

import Game.GameController;
import Game.GameMap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.imbabot.pacman_game.Helpers.Assets;

public class BasicFood {

    int cellX;
    int cellY;
    GameController gc;
    TextureRegion texture;
    boolean active;

    public BasicFood(GameController gc, int cellX, int cellY, boolean active, TextureRegion texture){
        this.cellX = cellX;
        this.cellY  = cellY;
        this.gc = gc;
        this.texture = texture;
        this.active = true;
    }

    public int getCellX() {
        return cellX;
    }

    public int getCellY() {
        return cellY;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



    public void render(SpriteBatch batch){
        if (active) {
            batch.draw(texture, cellX * GameMap.CELL_SIZE, cellY * GameMap.CELL_SIZE);
        }
    }

    public void update(float dt){

    }
}
