package com.imbabot.pacman_game.Units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.imbabot.pacman_game.Direction;
import com.imbabot.pacman_game.GameController;
import com.imbabot.pacman_game.GameMap;


public class Packman extends Unit{

    private float speed;
    private StringBuilder stringBuilder;
    private int score;
    private TextureRegion texture;


    public Packman(TextureAtlas atlas, GameController gc){
        super(gc, 1, 1);
        this.speed = 5f;
        this.stringBuilder = new StringBuilder();
        this.score = 0;
        this.texture = atlas.findRegion("Pacman");
    }

    public void update(float dt){
        Direction direction = null;
       if (direction == Direction.RIGHT) {
           cellX += speed;
      }else if (direction == Direction.LEFT){
           cellX -= speed * dt;
        }else if (direction == Direction.LEFT){
            cellY += speed * dt;
        }else if (direction == Direction.BOTTOM){
            cellY -= speed * dt;
        }
        movement(dt);
    }

    public void movement(float dt){
       Direction direction = null;
       if (Gdx.input.isKeyJustPressed(Input.Keys.D)){
          direction = Direction.RIGHT;
      }else if (Gdx.input.isKeyJustPressed(Input.Keys.A)){
           direction = Direction.LEFT;
       }else if (Gdx.input.isKeyJustPressed(Input.Keys.W)){
           direction = Direction.TOP;
        }else if (Gdx.input.isKeyJustPressed(Input.Keys.S)){
           direction = Direction.BOTTOM;
        }
    }


    public void renderGUI(SpriteBatch batch, BitmapFont font){
        stringBuilder.setLength(0);
        stringBuilder.append("Score: " + score);
        font.draw(batch, stringBuilder, 10, 700);
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, cellX * GameMap.CELL_SIZE, cellY * GameMap.CELL_SIZE);
    }


}