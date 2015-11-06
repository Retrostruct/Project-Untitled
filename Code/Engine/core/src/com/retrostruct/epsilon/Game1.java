package com.retrostruct.epsilon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Game1 extends ApplicationAdapter {
	SpriteBatch batch;
    Player player;
    Vector2 vec = null;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        player = new Player();
	}

	@Override
	public void render () {
        player.update(Gdx.graphics.getDeltaTime());
        if(Gdx.input.isTouched() || Gdx.input.isButtonPressed(Buttons.LEFT)) {
			vec	= new Vector2(Gdx.input.getX(), Gdx.input.getY());
        }
		player.move(vec);

		Gdx.gl.glClearColor(0.39f, 0.58f, 0.93f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
        player.draw(batch);
		batch.end();
	}
}
