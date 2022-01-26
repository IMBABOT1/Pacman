package com.imbabot.pacman_game.Units;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.imbabot.pacman_game.GameController;
import com.imbabot.pacman_game.GameMap;

public abstract class Unit {

    int cellX;
    int cellY;
    GameController gc;
    TextureRegion texture;

    public Unit(GameController gc, int cellX, int cellY){
        this.gc = gc;
        this.cellX = cellX;
        this.cellY = cellY;
    }


    public abstract void update(float dt);
}
