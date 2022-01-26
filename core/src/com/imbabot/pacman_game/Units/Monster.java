package com.imbabot.pacman_game.Units;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.imbabot.pacman_game.GameController;
import com.imbabot.pacman_game.GameMap;

public class Monster extends Unit{


    public Monster(TextureAtlas atlas, GameController gc) {
        super(gc, 5, 5);
        this.texture = atlas.findRegion("MonsterRed");
    }

    @Override
    public void update(float dt) {

    }


    public void render(SpriteBatch batch){
        batch.draw(texture, cellX * GameMap.CELL_SIZE, cellY * GameMap.CELL_SIZE);
    }

}
