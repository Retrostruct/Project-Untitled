package retrostruct.epsilon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import retrostruct.epsilon.entities.Player;
import retrostruct.epsilon.handlers.ItemHandler;
import retrostruct.epsilon.handlers.LevelHandler;
import retrostruct.epsilon.handlers.MouseHandler;

public class GdxGame extends ApplicationAdapter {
	public static final int VIRTUAL_WIDTH = 1920;
	public static final int VIRTUAL_HEIGHT = 1080;
	
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Viewport viewport;
	private MouseHandler mouse;
	
	private Player player;
	
	// Test
	private Texture bg;

	@Override
	public void create () {
		batch = new SpriteBatch(); // Create sprite batch
		camera = new OrthographicCamera(VIRTUAL_WIDTH, VIRTUAL_HEIGHT); // Create camera
		viewport = new ScalingViewport(Scaling.fit, VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera); // Create viewport
		camera.update(); // Initially, update camera
		mouse = new MouseHandler(); // Create mouse
		
		player = new Player(0, -250);
		LevelHandler.setLevel(0);
		
		// Test
		bg = new Texture("map.png");
	}

	@Override
	public void render () {
		mouse.update(camera); // Update mouse
		player.update(mouse, camera);
		camera.update(); // Update the camera
		batch.setProjectionMatrix(camera.combined); // Set the projection matrix of the sprite batch
		
		// Clear the screen
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin(); // Begin rendering the scene
		
		float per = 0.6f;
		batch.draw(bg, 0, -bg.getHeight()*per/2, bg.getWidth() * per, bg.getHeight() * per);
		player.render(batch);
		ItemHandler.render(batch);
		
		batch.end();
	}
	
	public void resize(int width, int height) {
		// When the window is resized, change the viewport size
		viewport.update(width, height);
	}
}
