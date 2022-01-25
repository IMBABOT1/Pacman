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

    private Vector2 position;
    private TextureRegion texture;
    private float speed;

    private boolean isPressedD;
    private boolean isPressedA;
    private boolean isPressedW;
    private boolean isPressedS;

    private float offset;

    private StringBuilder stringBuilder;
    private int score;


    public Hero(TextureAtlas atlas){
        this.texture = atlas.findRegion("Pacman");
        this.position = new Vector2(100, 100);
        this.speed = 300.0f;
        this.isPressedD = false;
        this.isPressedA = false;
        this.isPressedS = false;
        this.isPressedW = false;
        this.offset = 36;
        this.stringBuilder = new StringBuilder();
        this.score = 0;
    }

    public void update(float dt){
        movement(dt);
        checkBounds();
    }

    private void checkBounds(){
        if (position.x > 1280 - offset){
            position.x = 1280 - offset;
        }
        if (position.x < 0 + offset){
            position.x = 0 + offset;
        }
        if (position.y > 720 - offset){
            position.y = 720 - offset;
        }
        if (position.y < 0 + offset){
            position.y = 0 + offset;
        }
    }

    public void movement(float dt){
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            isPressedD = true;
            isPressedA = false;
            isPressedS = false;
            isPressedW = false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            isPressedD = false;
            isPressedA = true;
            isPressedS = false;
            isPressedW = false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            isPressedD = false;
            isPressedA = false;
            isPressedS = true;
            isPressedW = false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            isPressedD = false;
            isPressedA = false;
            isPressedS = false;
            isPressedW = true;
        }
        if (isPressedA){
            position.x -= speed * dt;
        }
        if (isPressedD){
            position.x += speed * dt;
        }
        if (isPressedS){
            position.y -= speed * dt;
        }
        if (isPressedW){
            position.y += speed * dt;
        }

    }

    public void renderGUI(SpriteBatch batch, BitmapFont font){
        stringBuilder.setLength(0);
        stringBuilder.append("Score: " + score);
        font.draw(batch, stringBuilder, 10, 700);
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, position.x - offset, position.y - offset);
    }
}
