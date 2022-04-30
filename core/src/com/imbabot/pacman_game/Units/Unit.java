package com.imbabot.pacman_game.Units;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import Game.GameController;
import com.imbabot.pacman_game.Helpers.Poolable;

public abstract class Unit implements Poolable {

    float movementTime;
    float movementMaxTime;
    int cellX;
    int cellY;
    GameController gc;
    TextureRegion texture;
    boolean active;

    public int getCellX() {
        return cellX;
    }

    public int getCellY() {
        return cellY;
    }


    @Override
    public boolean isActive() {
        return active;
    }

    public Unit(GameController gc, int cellX, int cellY, boolean active){
        this.gc = gc;
        this.cellX = cellX;
        this.cellY = cellY;
        this.active = active;
    }

    public boolean isCellEmpty(int cx, int cy){
        return gc.getGameMap().isCellPossible(cx, cy) && gc.getUnitController().getMonsterInCel(cx, cy);
    }


    public abstract void update(float dt);
}