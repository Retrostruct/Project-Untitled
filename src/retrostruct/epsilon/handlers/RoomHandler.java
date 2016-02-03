package retrostruct.epsilon.handlers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import retrostruct.epsilon.entities.Room;

public class RoomHandler {
	public static int[][] map = new int[][] {
		{0, 1, 3, 0, 0, 0, 0, 0, 0, },
		{0, 2, 0, 0, 0, 0, 0, 0, 0, },
	};
	
	private static Room[] rooms;
	private static int currentRoom;
	
	public static void setCurrentRoom(int id) { currentRoom = id; }
	public static Room getCurrentRoom(int id) { return rooms[id]; }
	
	public static void loadAllRooms(SaveGame saveGame) {
		if(saveGame.getRooms() == null) {
			// Player has no save game, load default rooms
			loadDefaultRooms();
		} else {
			// Save game exists
			rooms = saveGame.getRooms();
		}
		for(int i = 0; i < rooms.length; i++) {
			// Load content of rooms (textures etc.)
			rooms[i].loadContent();
		}
	}
	
	public static Vector2 getCurrentRoomDimensions(){
		return rooms[currentRoom].getDimensions();
	}
	
	private static void loadDefaultRooms() {
		// Load the default rooms
		Room r;
		int nrOfRooms = 1;
		Room[] defaultRooms = new Room[nrOfRooms];
		for(int j = 0; j < nrOfRooms; j++) {
			try {
				r = null;
				FileInputStream fileIn = new FileInputStream(SaveGame.NEW_GAME_PATH + j);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				r = (Room)in.readObject();
				defaultRooms[j] = r;
				in.close();
				fileIn.close();
			} catch(IOException i) {
				i.printStackTrace();
			} catch(ClassNotFoundException c) {
				c.printStackTrace();
			}
		}
		rooms = defaultRooms;
	}
	
	public static void update() {
		rooms[currentRoom].update();
	}
	
	public static void render(SpriteBatch batch) {
		rooms[currentRoom].render(batch);
	}

}
