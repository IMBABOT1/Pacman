package com.imbabot.pacman_game.Food;

import Game.GameController;
import Game.GameMap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.imbabot.pacman_game.Helpers.Assets;

public class BlueFood extends BasicFood {



    public BlueFood(GameController gc, int cellX, int cellY){
        super(gc, cellX, cellY, true, Assets.getInstance().getAtlas().findRegion("blue"));
        this.cellX = cellX;
        this.cellY  = cellY;
        this.gc = gc;
    }

}
