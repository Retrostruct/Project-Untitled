package com.retrostruct.epsilon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Game1 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
    Animation ani;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("pengiun.jpg");
        ani = new Animation("AnimationTest.png", 100, 100, 10);
	}

	@Override
	public void render () {
        ani.update(Gdx.graphics.getDeltaTime());
        if(Gdx.input.isTouched()) {
            ani.changeAnimation(2);
        }

		Gdx.gl.glClearColor(0.39f, 0.58f, 0.93f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(img, 0, 0);
        ani.draw(batch, 0, 0);
		batch.end();
	}
}
