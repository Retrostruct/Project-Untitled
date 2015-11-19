package com.retrostruct.epsilon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.awt.Rectangle;

import javafx.scene.media.MediaPlayer;
import sun.font.GlyphLayout;


public class Game1 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Vector2 goTo;
	Vector2 currentPosition;
	float speed;
    BitmapFont font;
	String[] test = new String[2];

	GlyphLayout layout;
	Choice choiceTest;

	
	@Override
	public void create () {

		test[0] = "hahahaha";
		test[1] = "Som om lel";
		batch = new SpriteBatch();
		img = new Texture("pengiun.jpg");
		currentPosition = new Vector2(0,0);
		goTo = new Vector2(0,0);
		speed = 5;

		choiceTest = new Choice(test);
        font = new BitmapFont(Gdx.files.internal("TestFont.fnt"));



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

		choiceTest.Render(batch, font);

		batch.end();
	}
}
