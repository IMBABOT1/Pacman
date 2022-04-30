package Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.imbabot.pacman_game.Helpers.Assets;

public class WorldRenderer {
    private GameController gc;
    private SpriteBatch batch;
    private BitmapFont font36;

    public WorldRenderer(GameController gc, SpriteBatch batch) {
        this.gc = gc;
        this.batch = batch;
        this.font36 = Assets.getInstance().getAssetManager().get("fonts/font36.ttf");
    }

    public void render(){
        Gdx.gl.glClearColor(1,1,1,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        gc.getGameMap().render(batch);
        gc.render(batch);
        gc.getUnitController().render(batch);
        font36.draw(batch, "score: " + gc.getUnitController().getPackman().getScore(), 20, 700);
        font36.draw(batch, "lives: " + gc.getUnitController().getPackman().getLives(),  1550, 700);
        if (gc.getUnitController().getPackman().isKillGhosts() == true) {
            int time = Math.round(gc.getUnitController().getPackman().getKillTime());
            font36.draw(batch, "KILL!!!: " + time, 780, 380);
        }
        batch.end();

    }
}