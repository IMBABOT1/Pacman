package com.imbabot.pacman_game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.imbabot.pacman_game.Units.Monster;
import com.imbabot.pacman_game.Units.Packman;

public class GameController {

    private Packman packman;
    private GameMap gameMap;
    private Monster monster;

    public GameController(TextureAtlas atlas){
        this.gameMap = new GameMap(atlas);
        this.packman = new Packman(atlas, this);
        this.monster = new Monster(atlas, this);
    }


    public Monster getMonster() {
        return monster;
    }

    public Packman getHero() {
        return packman;
    }

    public GameMap getGameMap() {
        return gameMap;
    }


    public void update(float dt){
        gameMap.update(dt);
        packman.update(dt);
        monster.update(dt);
    }
}
