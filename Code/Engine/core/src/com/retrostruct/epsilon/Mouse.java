package com.retrostruct.epsilon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Mouse {
	Vector3 pos;
	Boolean pressed = false;
	
	public int getX() {
		return (int)pos.x;
	}
	
	public int getY() {
		return (int)pos.y;
	}
	
	public Vector2 getPos() {
		return new Vector2(pos.x, pos.y);
	}
	
	public Boolean isPressed() {
		return pressed;
	}
	
	public Mouse(int x, int y) {
		pos = new Vector3(x, y, 0);
	}
	
	public void update(Stage stage) {
		pos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		stage.getCamera().unproject(pos);
		pressed = Gdx.input.isButtonPressed(Buttons.LEFT);
	}
	
	public void draw(SpriteBatch batch) {
		// TODO: Draw pointer
	}

}
