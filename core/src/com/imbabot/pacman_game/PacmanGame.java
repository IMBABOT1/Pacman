package com.imbabot.pacman_game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class PacmanGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Hero hero;
	private BitmapFont font32;
	private TextureAtlas atlas;
	private GameMap gameMap;


	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.atlas = new TextureAtlas("game.pack");
		this.hero = new Hero(atlas);
		this.font32 = new BitmapFont(Gdx.files.internal("font32.fnt"));
		this.gameMap = new GameMap(atlas);
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		gameMap.render(batch);
		hero.render(batch);
		hero.renderGUI(batch, font32);
		batch.end();
	}


	public void update(float dt){
		gameMap.update(dt);
		hero.update(dt);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		atlas.dispose();
	}
}
