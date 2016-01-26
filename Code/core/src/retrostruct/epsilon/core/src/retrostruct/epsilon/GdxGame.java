package retrostruct.epsilon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import retrostruct.epsilon.entities.Player;
import retrostruct.epsilon.handlers.LevelHandler;
import retrostruct.epsilon.handlers.MouseHandler;

public class GdxGame extends ApplicationAdapter {
	public static final int VIRTUAL_WIDTH = 1280;
	public static final int VIRTUAL_HEIGHT = 720;
	
	SpriteBatch batch;
	Color clear = new Color(0, 0, 0, 1);
	OrthographicCamera camera;
	Viewport viewport;
	Scaling scaling = Scaling.fit;
	MouseHandler mouse;
	Player player;
	
	public void create () {
		Log.DEBUG_MODE = true;
		
		try {
			batch = new SpriteBatch(); // Create sprite batch
			Log.print("Created sprite batch");
		} catch(Exception e) {}
		try {
			camera = new OrthographicCamera(VIRTUAL_WIDTH, VIRTUAL_HEIGHT); // Create camera
			Log.print("Created camera (" + VIRTUAL_WIDTH + "x" + VIRTUAL_HEIGHT + ")");
		} catch(Exception e) {}
		try {
			viewport = new ScalingViewport(scaling, VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera); // Create viewport
			Log.print("Created viewport width scaling \"" + scaling.toString() + "\"");
		} catch(Exception e) {}
		
		camera.update(); // Initially, update camera
		mouse = new MouseHandler(); // Create mouse
		player = new Player(0, -250); // Create player
		LevelHandler.setLevel(0); // Set level to first level
	}

	public void render () {
		mouse.update(camera); // Update mouse
		player.update(mouse, camera);
		camera.update(); // Update the camera
		batch.setProjectionMatrix(camera.combined); // Set the projection matrix of the sprite batch
		
		clear();
		batch.begin(); // Begin rendering the scene
		
		player.render(batch);
		LevelHandler.render(batch);
		
		batch.end();
	}
	
	public void clear() {
		// Clear the screen
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClearColor(clear.r, clear.g, clear.b, clear.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	public void resize(int width, int height) {
		// When the window is resized, change the viewport size
		viewport.update(width, height);
	}
}
