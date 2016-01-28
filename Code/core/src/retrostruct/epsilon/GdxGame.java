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
import retrostruct.epsilon.enums.GameStates;
import retrostruct.epsilon.handlers.MouseHandler;
import retrostruct.epsilon.handlers.SaveGame;

public class GdxGame extends ApplicationAdapter {
	public static final int VIRTUAL_WIDTH = 1280;
	public static final int VIRTUAL_HEIGHT = 720;
	
	private GameStates currentGameState = GameStates.MAIN_MENU;
	
	private SpriteBatch batch;
	private Color clear = new Color(0, 0, 0, 1);
	private OrthographicCamera camera;
	private Viewport viewport;
	private Scaling scaling = Scaling.fit;
	private Player player;
	
	public void create () {
		Log.DEBUG_MODE = true;
		batch = new SpriteBatch(); // Create sprite batch
		camera = new OrthographicCamera(VIRTUAL_WIDTH, VIRTUAL_HEIGHT); // Create camera
		viewport = new ScalingViewport(scaling, VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera); // Create viewport
		camera.setToOrtho(false);
		camera.update(); // Initially, update camera
		player = new Player(0, -250); // Create player
		SaveGame saveGame = new SaveGame();
		saveGame.Load(0);
		Map.loadRooms(saveGame);
	}

	public void render () {
		MouseHandler.update(camera);
		switch(currentGameState) {
			case MAIN_MENU:
				
				break;
			case PAUSE_MENU:
				
				break;
			case PLAYING:
				Map.update(); // Update map (Rooms, items etc.)
				player.update(camera); // Update player and center camera
				break;
			case CREDITS:
				
				break;
		}
		
		camera.update();
		batch.setProjectionMatrix(camera.combined); // Set the projection matrix of the sprite batch
		
		clear();
		batch.begin(); // Begin rendering the scene
		
		switch(currentGameState) {
		case MAIN_MENU:
			MainMenu.update();
			break;
		case PAUSE_MENU:
			PauseMenu.update();
			break;
		case PLAYING:
			Map.render(batch); // Render map (Rooms, items etc.) 
			player.render(batch); // Render player
			break;
		case CREDITS:
			
			break;
		}
		
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
