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

    private float offset;

    private StringBuilder stringBuilder;
    private int score;






    public Hero(TextureAtlas atlas, GameController gc){
        this.texture = atlas.findRegion("Pacman");
        this.cellX = 1;
        this.cellY = 1;
        this.speed = 5f;
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
        movement(dt);
        checkBounds();
    }


    private void checkBounds() {
        if (cellX > rightBorder) {
            cellX = rightBorder;
        }
        if (cellX < leftBorder) {
            cellX = leftBorder;
        }
        if (cellY > top) {
            cellY = top;
        }
        if (cellY < bottom) {
            cellY = bottom;
        }
    }

//        if (position.x > 1280 - offset){
//            position.x = 1280 - offset;
//        }
//        if (position.x < 0 + offset){
//            position.x = 0 + offset;
//        }
//        if (position.y > 720 - offset){
//            position.y = 720 - offset;
//        }
//        if (position.y < 0 + offset){
//            position.y = 0 + offset;
//        }


    public void movement(float dt){
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            cellX += speed * dt;
        }else if (Gdx.input.isKeyPressed(Input.Keys.A)){
            cellX -= speed * dt;
        }else if (Gdx.input.isKeyPressed(Input.Keys.S)){
            cellY -= speed * dt;
        }else if (Gdx.input.isKeyPressed(Input.Keys.W)){
            cellY += speed * dt;
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