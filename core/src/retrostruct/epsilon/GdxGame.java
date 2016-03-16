package retrostruct.epsilon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import retrostruct.epsilon.debug.Log;
import retrostruct.epsilon.entities.Player;
import retrostruct.epsilon.enums.GameStates;
import retrostruct.epsilon.handlers.MathHandler;
import retrostruct.epsilon.handlers.RoomHandler;
import retrostruct.epsilon.input.MouseHandler;
import retrostruct.epsilon.menus.MainMenu;
import retrostruct.epsilon.menus.PauseMenu;

/* Here is the main class of the game
 * Everything gets loaded and initialized in this class
 * This class is also used for testing
 */
public class GdxGame extends ApplicationAdapter {
	public static final int VIRTUAL_WIDTH = 1280; // Width of window
	public static final int VIRTUAL_HEIGHT = VIRTUAL_WIDTH / 16 * 9; // Calculate the height to 16:9 aspect ratio

	private GameStates currentGameState = GameStates.PLAYING; // Initially, set the game state

	private SpriteBatch batch; // Sprite batch
	private Color clear = new Color(1, 1, 1, 1); // Clear color
	private OrthographicCamera camera; // Main camera, we should probably be good with only one
	private Viewport viewport; // Main viewport
	private Scaling scaling = Scaling.fill; // This is the scaling method which will be used to render the game
	
	private Player player;

	public void create () {
		Log.DEBUG_MODE = true; // Print debug information
		batch = new SpriteBatch(); // Create sprite batch
		camera = new OrthographicCamera(VIRTUAL_WIDTH, VIRTUAL_HEIGHT); // Create camera

		player = new Player(300, 0); // Set player position here

		viewport = new ScalingViewport(scaling, VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera); // Create viewport
		camera.setToOrtho(false); // Set to non orthographic camera
		camera.update(); // Initially, update camera
		
		RoomHandler.loadAllRooms(RoomHandler.newGame()); // Load a new game
	}

	public void render () {
		MouseHandler.update(camera); // Update the mouse handler
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) 
			Gdx.app.exit();
		
		/* Here are the game states
		 * Update in the corresponding case 
		 */
		switch(currentGameState) {
			case MAIN_MENU:
				MainMenu.render(batch);
				break;
			case PAUSE_MENU:
				PauseMenu.render(batch);
				break;
			case PLAYING:
				RoomHandler.update(); // Update map (Rooms, items etc.)
				player.update(camera); // Update player and center camera
				break;
			case INVENTORY:

				break;
			case CREDITS:
				// TODO: The game should probably end after the credits?
				break;
		}

		// Calculate the camera position corresponding to the players position and the room size
		camera.position.x = MathHandler.clamp(camera.position.x, viewport.getScreenWidth()/2, RoomHandler.getCurrentRoomDimensions().x - viewport.getScreenWidth() / 2);
		camera.update();
		batch.setProjectionMatrix(camera.combined); // Set the projection matrix of the sprite batch

		clear(); // Clear the screen
		batch.begin(); // Begin rendering the scene

		/* Here is the rendering of the different game states
		 * Do the same as in update
		 * The main and pause menu has its own cases
		 */
		switch(currentGameState) {
		case MAIN_MENU:
			switch(MainMenu.update()) {
			case NONE:
				break;
			case NEW_GAME:

				break;
			case LOAD_GAME:

				break;
			case SETTINGS:

				break;
			case EXIT:
				// Save
				// Exit
				break;
			}
			break;
		case PAUSE_MENU:
			switch(PauseMenu.update()) {
			case NONE:
				break;
			case CONTINUE:
				currentGameState = GameStates.PLAYING;
				break;
			case SAVE_GAME:

				break;
			case LOAD_GAME:

				break;
			case SETTINGS:
				// PC master race only
				break;
			case EXIT_TO_MAIN_MENU:
				// Should probably ask to save here...
				currentGameState = GameStates.MAIN_MENU;
				break;
			}
			break;
		case PLAYING:
			RoomHandler.render(batch); // Render map (Rooms, items etc.)
			player.render(batch); // Render player
			break;
		case INVENTORY:
			
			break;
		case CREDITS:

			break;
		}

		batch.end(); // End the sprite batch
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
