package com.imbabot.pacman_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;


public class Hero {

    private int rightBorder;
    private int leftBorder;
    private int top;
    private int bottom;

    private GameController gc;
    private float cellX;
    private float cellY;
    private TextureRegion texture;
    private float speed;

    private boolean isPressedD;
    private boolean isPressedA;
    private boolean isPressedW;
    private boolean isPressedS;

    private float offset;

    private StringBuilder stringBuilder;
    private int score;






    public Hero(TextureAtlas atlas, GameController gc){
        this.texture = atlas.findRegion("Pacman");
        this.cellX = 1;
        this.cellY = 1;
        this.speed = 5f;
        this.isPressedD = false;
        this.isPressedA = false;
        this.isPressedS = false;
        this.isPressedW = false;
        this.offset = 36;
        this.stringBuilder = new StringBuilder();
        this.score = 0;
        this.gc = gc;
        this.leftBorder = 0;
        this.rightBorder = 15;
        this.top = 8;
        this.bottom = 0;
    }

    public void update(float dt){
        Direction direction = null;
        if (direction == Direction.RIGHT) {
            cellX += speed * dt;
        }else if (direction == Direction.LEFT){
            cellX -= speed * dt;
        }else if (direction == Direction.LEFT){
            cellY += speed * dt;
        }else if (direction == Direction.BUTTON){
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
            direction = Direction.BUTTON;
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