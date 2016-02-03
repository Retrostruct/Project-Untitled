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

import retrostruct.epsilon.debug.Log;
import retrostruct.epsilon.entities.Player;
import retrostruct.epsilon.entities.Room;
import retrostruct.epsilon.enums.GameStates;
import retrostruct.epsilon.handlers.MathHandler;
import retrostruct.epsilon.handlers.RoomHandler;
import retrostruct.epsilon.handlers.SaveGame;
import retrostruct.epsilon.input.MouseHandler;
import retrostruct.epsilon.items.Background;
import retrostruct.epsilon.items.Handbag;
import retrostruct.epsilon.items.Item;
import retrostruct.epsilon.menus.MainMenu;
import retrostruct.epsilon.menus.PauseMenu;

public class GdxGame extends ApplicationAdapter {
	public static final int VIRTUAL_WIDTH = 1280;
	public static final int VIRTUAL_HEIGHT = 720;

	private GameStates currentGameState = GameStates.PLAYING;

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

		player = new Player(0, 0);

		viewport = new ScalingViewport(scaling, VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera); // Create viewport
		camera.setToOrtho(false);
		camera.update(); // Initially, update camera

		Room room = new Room();
		room.setId(1);
		room.setName("Debug");

		Item[] items = new Item[] {new Background("map.png", 1, 0,0), new Handbag(0, 0, 0)};

		room.setItems(items);

		Room[] rooms = new Room[] {room};

		SaveGame saveGame = new SaveGame();
		saveGame.setRooms(rooms);
		//saveGame.Load(0);
		RoomHandler.loadAllRooms(saveGame);

	}

	public void render () {
		MouseHandler.update(camera);
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

				break;
		}

		camera.position.x = MathHandler.clamp(camera.position.x, 0, RoomHandler.getCurrentRoomDimensions().x - viewport.getScreenWidth());
		camera.update();
		batch.setProjectionMatrix(camera.combined); // Set the projection matrix of the sprite batch

		clear();
		batch.begin(); // Begin rendering the scene

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
