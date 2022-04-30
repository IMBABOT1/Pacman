package Screens;

import Game.GameController;
import Game.WorldRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends AbstractScreen {

    private GameController gameController;
    private WorldRenderer worldRenderer;

    public GameScreen(SpriteBatch batch){
        super(batch);
    }

    @Override
    public void show(){
        this.gameController = new GameController(batch);
        this.worldRenderer = new WorldRenderer(gameController, batch);
    }

    public void render(float delta){
        gameController.update(delta);
        worldRenderer.render();
    }
}
