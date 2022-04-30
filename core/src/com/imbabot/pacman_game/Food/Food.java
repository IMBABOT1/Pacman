package com.imbabot.pacman_game.Food;

import Game.GameController;
import Game.GameMap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.imbabot.pacman_game.Helpers.Assets;
import com.imbabot.pacman_game.Units.Packman;

public class Food extends BasicFood {

    public Food(GameController gc, int cellX, int cellY) {
        super(gc, cellX, cellY, true, Assets.getInstance().getAtlas().findRegion("food"));
        this.cellX = cellX;
        this.cellY = cellY;
        this.gc = gc;
    }

    public void use(Packman packman){
        packman.addScore(1);
    }
}
