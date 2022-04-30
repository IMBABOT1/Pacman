package com.imbabot.pacman_game.Units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.imbabot.pacman_game.Food.Food;
import com.imbabot.pacman_game.Helpers.Assets;
import Game.Direction;
import Game.GameController;
import Game.GameMap;


public class Packman extends Unit {



    private int score;
    private Direction direction;
    private int lives;
    private boolean killGhosts;
    private float killTime;
    private float killMaxTime;



    public Packman(GameController gc) {
        super(gc, 1, 1, true);
        this.score = 0;
        this.direction = null;
        this.movementMaxTime = 0.2f;
        this.movementTime = 0.0f;
        this.lives = 3;
        this.texture = Assets.getInstance().getAtlas().findRegion("Pacman");
        this.killGhosts = false;
        this.killTime = 0;
        this.killMaxTime = 5;
    }

    public int getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    }


    public float getKillTime() {
        return killTime;
    }


    public boolean isKillGhosts() {
        return killGhosts;
    }




    public void checkMonster() {
        Monster m = gc.getUnitController().getMonsterController().getMonsterInCel(cellX, cellY);
        if (m != null && killGhosts == false) {
            for (Monster m1 : gc.getUnitController().getMonsterController().getActiveList()) {
                m1.active = false;
            }
            active = false;
            lives--;
        }
    }

    public void checkKillMonster(){
        Monster m = gc.getUnitController().getMonsterController().getMonsterInCel(cellX, cellY);
        if (m != null && killGhosts == true){
            m.active = false;
        }
    }

    public void eatFood(){
        for (int i = 0; i < gc.getList().size() ; i++) {
            if (gc.getList().get(i).isActive() && cellX == gc.getList().get(i).getCellX() && cellY == gc.getList().get(i).getCellY()){
                gc.getList().get(i).use(this);
                gc.getList().get(i).setActive(false);
            }
        }
    }


    public void addScore(int amount){
        score += amount;
    }

    public void eatBlueFood(float dt){
        for (int i = 0; i < gc.getBlueFood().size() ; i++) {
            if (cellX == gc.getBlueFood().get(i).getCellX() &&
                cellY == gc.getBlueFood().get(i).getCellY() &&
                gc.getBlueFood().get(i).isActive()){
                gc.getBlueFood().get(i).setActive(false);
                killGhosts = true;
            }
        }

        if (killGhosts == true){
            killTime += dt;
            if (killTime >= killMaxTime){
                killGhosts = false;
                killTime = 0;
            }
        }
    }


    public void update(float dt) {
        checkMovement(dt);
        checkMonster();
        eatFood();




        eatBlueFood(dt);
        checkKillMonster();

        movementTime += dt;


        if (gc.getGameMap().isCellPossible(cellX + 1, cellY)) {
            if (direction == Direction.RIGHT) {
                if (movementTime >= movementMaxTime) {
                    cellX++;
                    movementTime = 0;
                }
            }
        }
        if (gc.getGameMap().isCellPossible(cellX - 1, cellY)) {
            if (direction == Direction.LEFT) {
                if (movementTime >= movementMaxTime) {
                    cellX--;
                    movementTime = 0;
                }
            }
        }
        if (gc.getGameMap().isCellPossible(cellX, cellY + 1)) {
            if (direction == Direction.TOP) {
                if (movementTime >= movementMaxTime) {
                    cellY++;
                    movementTime = 0;
                }
            }
        }
        if (gc.getGameMap().isCellPossible(cellX, cellY - 1)) {
            if (direction == Direction.BOTTOM) {
                if (movementTime >= movementMaxTime) {
                    cellY--;
                    movementTime = 0;
                }
            }
        }

        if (cellX == 0 && cellY == 4 && direction == Direction.LEFT){
            if (movementTime >= movementMaxTime) {
                cellX = 20;
                cellY = 4;
                movementTime = 0;
            }
        }

        if (cellX == 20 && cellY == 4 && direction == Direction.RIGHT){
            if (movementTime >= movementMaxTime) {
                cellX = 0;
                cellY = 4;
                movementTime = 0;
            }
        }
    }






    public void checkMovement(float dt){
        if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            direction = Direction.RIGHT;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            direction = Direction.LEFT;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            direction = Direction.TOP;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            direction = Direction.BOTTOM;
        }
    }





    public void render(SpriteBatch batch) {
        if (active) {
            batch.draw(texture, cellX * GameMap.CELL_SIZE, cellY * GameMap.CELL_SIZE);
        } else {
            cellX = 1;
            cellY = 1;
            active = true;
        }
    }
}