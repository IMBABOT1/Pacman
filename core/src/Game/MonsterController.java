package Game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.imbabot.pacman_game.Helpers.ObjectPool;
import com.imbabot.pacman_game.Units.Monster;

public class MonsterController extends ObjectPool<Monster> {
    private GameController gc;

    public MonsterController(GameController gc){
        this.gc = gc;
    }

    public void activate(int cellX, int cellY){
        getActiveElement().activate(cellX, cellY);
    }


    public Monster getMonsterInCel(int cellX, int cellY){
        for (Monster m: getActiveList()){
            if (m.getCellX() == cellX && m.getCellY() == cellY){
                return m;
            }
        }

        return null;
    }

    public void update(float dt){
        for (Monster m: getActiveList()){
            m.update(dt);
        }
        checkPool();
    }

    public void render(SpriteBatch batch){
        for (Monster m: getActiveList()) {
            m.render(batch);
        }
    }

    @Override
    protected Monster newObject() {
        return new Monster(gc);
    }
}