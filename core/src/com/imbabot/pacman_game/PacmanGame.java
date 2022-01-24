package com.imbabot.pacman_game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class PacmanGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private Pacman pacman;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		pacman = new Pacman();
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		pacman.render(batch);
		batch.end();
	}


	public void update(float dt){
		pacman.update(dt);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
