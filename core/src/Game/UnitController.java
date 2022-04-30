package Game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.imbabot.pacman_game.Units.Packman;
import com.imbabot.pacman_game.Units.Unit;

import java.util.ArrayList;
import java.util.List;

public class UnitController {
    private GameController gc;
    private Packman packman;
    private MonsterController monsterController;
    private List<Unit> units;

    public UnitController (GameController gc) {
        this.gc = gc;
        this.packman = new Packman(gc);
        this.monsterController = new MonsterController(gc);
        this.units = new ArrayList<>();
        this.units.add(packman);
        this.monsterController.activate(5, 5);
        this.monsterController.activate(15, 5);
        this.units.addAll(monsterController.getActiveList());

    }

    public boolean getMonsterInCel(int cellX, int cellY){
        for (Unit u: units){
            if (u.isActive() && !u.equals(packman)){
                if (u.getCellX() == cellX && u.getCellY() == cellY){
                    return false;
                }
            }
        }
        return true;
    }


    public boolean getPacmanInCell(int cellX, int cellY){
        for (Unit u: units){
            if (u.isActive() && u.equals(packman)){
                if (u.getCellX() == cellX && u.getCellY() == cellY){
                    return false;
                }
            }
        }
        return true;
    }




    public MonsterController getMonsterController() {
        return monsterController;
    }


    public Packman getPackman() {
        return packman;
    }


    public void update(float dt){
        monsterController.update(dt);
        packman.update(dt);
    }

    public void render(SpriteBatch batch){
        monsterController.render(batch);
        packman.render(batch);

    }
}