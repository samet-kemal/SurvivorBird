package com.samet.survivorbird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SurvivorBird extends ApplicationAdapter {

	SpriteBatch batch;
	Texture background;
	Texture bird;
	float birdX = 0;
	float birdY = 0;
	int gameState = 0;
	float velocity = 0;
	float gravity = 0.1f;


	@Override
	public void create() {
		batch = new SpriteBatch();
		background = new Texture("background.png");
		bird = new Texture("bird.png");
		birdX = Gdx.graphics.getWidth() / 2 - Gdx.graphics.getHeight() / 2;
		birdY = Gdx.graphics.getHeight() / 3;

	}

	@Override
	public void render () {

		if (gameState == 1) {
			if (Gdx.input.justTouched()) {
				velocity = -7;
			}
			if (birdY > 0 || velocity < 0) {

				velocity = velocity + gravity + 0.1f;
				birdY = birdY - velocity;
			}


		} else {
			if (Gdx.input.justTouched()) {
				gameState = 1;
			}
		}


		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		batch.draw(bird, birdX, birdY, Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() / 10);


		batch.end();

	}
	
	@Override
	public void dispose () {

	}
}
