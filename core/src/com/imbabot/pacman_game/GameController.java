package com.imbabot.pacman_game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class GameController {

    private Hero hero;
    private GameMap gameMap;

    public GameController(TextureAtlas atlas){
        this.gameMap = new GameMap(atlas);
        this.hero = new Hero(atlas, this);
    }

    public Hero getHero() {
        return hero;
    }

    public GameMap getGameMap() {
        return gameMap;
    }


    public void update(float dt){
        gameMap.update(dt);
        hero.update(dt);
    }
}
