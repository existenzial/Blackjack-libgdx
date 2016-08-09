package com.existenzial.blackjack;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Blackjack extends Game {
	//set Screen Size and Pixel-Per-Meter
	public static final int VIEW_WIDTH = 800;
	public static final int VIEW_HEIGHT = 480;
	public static final float PPM = 100;

	public SpriteBatch batch;

	public static AssetManager assetManager;

	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		//Load SoundFX + Music
		//assetManager.load("", Music.class);
		//assetManager.load("", Sound.class);

		//assetManager.finishLoading();

		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		super.render();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		super.dispose();
		//assetManager.dispose();
		batch.dispose();
		img.dispose();
	}
}
