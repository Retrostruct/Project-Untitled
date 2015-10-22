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
	Vector2 goTo;
	Vector2 currentPosition;
	float speed;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		currentPosition = new Vector2(0,0);
		goTo = new Vector2(0,0);
		speed = 5;
	}

	@Override
	public void render () {

		if(Gdx.input.isTouched()){
			goTo.x = Gdx.input.getX();
			goTo.y = Gdx.input.getY();
		}

		if(currentPosition != goTo)
		{
			if(goTo.x > currentPosition.x){
				currentPosition.x+=speed;
			}
			else if(goTo.x < currentPosition.x){
				currentPosition.x-=speed;
			}

			if(goTo.y > currentPosition.y)
			{
				currentPosition.y+=speed;
			}
			else if(goTo.y < currentPosition.y){
				currentPosition.y-=speed;
			}
		}

		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		batch.draw(img, currentPosition.x, Gdx.graphics.getHeight() - currentPosition.y);

		batch.end();
	}
}
