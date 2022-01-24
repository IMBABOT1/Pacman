package com.imbabot.pacman_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class Pacman {

    private Vector2 position;
    private Texture texture;
    private float speed;

    private boolean isPressedD;
    private boolean isPressedA;
    private boolean isPressedW;
    private boolean isPressedS;

    public Pacman(){
        this.texture = new Texture("Pacman.png");
        this.position = new Vector2(100, 100);
        this.speed = 300.0f;
        this.isPressedD = false;
        this.isPressedA = false;
        this.isPressedS = false;
        this.isPressedW = false;
    }

    public void update(float dt){
        movement(dt);
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

    public void render(SpriteBatch batch){
        batch.draw(texture, position.x, position.y);
    }
}
