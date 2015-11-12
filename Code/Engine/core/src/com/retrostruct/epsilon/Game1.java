package com.retrostruct.epsilon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class Game1 extends ApplicationAdapter {
	SpriteBatch batch;
	Stage stage;
	Mouse mouse;
	
	Player player;
	Vector2 goTo;
	Vector2 startPos;
    
	@Override
	public void create () {
		batch = new SpriteBatch();
		stage = new Stage(new ExtendViewport(800, 600));
		mouse = new Mouse(0, 0);
		
		startPos = new Vector2(800 / 2, 600 / 2);
		player = new Player(startPos);
	}
	
	public void update(float dt) {
		player.update(dt);
		if(mouse.isPressed()) {
			goTo = mouse.getPos();
		}
		
		if(goTo != null) {
			player.move(goTo);
		}
	}
	
	public void draw(SpriteBatch batch) {
		player.draw(batch);
	}

	@Override
	public void render () {
		mouse.update(stage);
		update(Gdx.graphics.getDeltaTime());
		
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(stage.getCamera().combined);
		
		batch.begin();
		draw(batch);
		batch.end();
	}
	
	@Override
	public void resize(int w, int h) {
		stage.getViewport().update(w, h);
	}
}
