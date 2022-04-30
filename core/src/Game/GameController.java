package Game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.imbabot.pacman_game.Food.BlueFood;
import com.imbabot.pacman_game.Food.Food;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private SpriteBatch batch;
    private GameMap gameMap;
    private UnitController unitController;
    private List<Food> list;
    private List<BlueFood> blueFood;

    private int topBorder = 8;
    private int bottomBorder= 9;


    public GameController(SpriteBatch batch) {
        this.batch = batch;
        this.gameMap = new GameMap();
        this.unitController = new UnitController(this);
        this.list = new ArrayList<>();
        this.blueFood = new ArrayList<>();
        initFood();
    }

    public List<Food> getList() {
        return list;
    }

    public List<BlueFood> getBlueFood() {
        return blueFood;
    }



    public void initFood(){
        blueFood.add(new BlueFood(this, 1, 4));

        blueFood.add(new BlueFood(this, 19, 4));

        for (int i = 1; i <= topBorder ; i++) {
            list.add(new Food(this, 1, i - 1));
        }

        for (int i = 1; i <= bottomBorder ; i++) {
            list.add(new Food(this, i, 1));
        }

        for (int i = 1; i <= bottomBorder ; i++) {
            list.add(new Food(this, i, 7));
        }

        for (int i = 1; i < topBorder ; i++) {
            list.add(new Food(this, 3, i));
        }

        for (int i = 1; i < topBorder ; i++) {
            list.add(new Food(this, 5, i));
        }

        for (int i = 1; i < topBorder ; i++) {
            list.add(new Food(this, 7, i));
        }

        for (int i = 1; i < topBorder ; i++) {
            list.add(new Food(this, 9, i));
        }

        for (int i = 3; i < topBorder - 2; i++) {
            list.add(new Food(this, 10, i));
        }

        for (int i = 1; i < topBorder ; i++) {
            list.add(new Food(this, 11, i));
        }

        for (int i = 1; i < topBorder ; i++) {
            list.add(new Food(this, 13, i));
        }

        for (int i = 1; i < topBorder ; i++) {
            list.add(new Food(this, 15, i));
        }

        for (int i = 1; i < topBorder ; i++) {
            list.add(new Food(this, 17, i));
        }

        for (int i = 1; i < topBorder ; i++) {
            list.add(new Food(this, 19, i));
        }

        for (int i = 12; i <= bottomBorder + 9 ; i++) {
            list.add(new Food(this, i, 7));
        }

        for (int i = 12; i <= bottomBorder + 9 ; i++) {
            list.add(new Food(this, i, 1));
        }

    }




    public UnitController getUnitController() {
        return unitController;
    }


    public GameMap getGameMap() {
        return gameMap;
    }

    public void update(float dt){
        gameMap.update(dt);
        unitController.update(dt);

        for (int i = 1; i < list.size() ; i++) {
            list.get(i).update(dt);
        }

        for (int i = 0; i < blueFood.size() ; i++) {
            blueFood.get(i).update(dt);
        }

    }

    public void render(SpriteBatch batch){

        for (int i = 1; i < list.size() ; i++) {
            list.get(i).render(batch);
        }

        for (int i = 0; i < blueFood.size() ; i++) {
            blueFood.get(i).render(batch);
        }

    }
}