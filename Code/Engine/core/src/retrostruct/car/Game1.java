package retrostruct.car;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game1 extends ApplicationAdapter {
	SpriteBatch batch;
	
	// Test
	Texture img;
	int x = 0, y = 0, speed = 10;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("player.png");
	}
	
	public void update() {
		// TODO: Add game logic
		
		// Test
		if(Gdx.input.isKeyPressed(Keys.D)) x += speed;
		else if(Gdx.input.isKeyPressed(Keys.A)) x -= speed;
		if(Gdx.input.isKeyPressed(Keys.W)) y += speed;
		else if(Gdx.input.isKeyPressed(Keys.S)) y -= speed;
		
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)) Gdx.app.exit(); // Exit when escape is pressed
	}
	
	public void draw() {
		batch.draw(img, x, y);
		// TODO: Add draw code
	}

	@Override
	public void render () {
		update(); // Update
		clear(0, 0, 0, 1); // Clear
		batch.begin(); // Begin sprite batch
		draw(); // Draw
		batch.end(); // End sprite batch
	}
	
	// Clears the screen
	private void clear(int r, int g, int b, int a) {
		Gdx.gl.glClearColor(r, g, b, a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}
