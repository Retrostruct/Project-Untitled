package retrostruct.epsilon.handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import retrostruct.epsilon.entities.Room;
import retrostruct.epsilon.items.Background;
import retrostruct.epsilon.items.Door;
import retrostruct.epsilon.items.Handbag;
import retrostruct.epsilon.items.Item;

public class RoomHandler {
	public static int[][] map = new int[][] {
		{0, 1, 3, 0, 0, 0, 0, 0, 0, },
		{0, 2, 0, 0, 0, 0, 0, 0, 0, },
	};
	
	private static Room[] rooms;
	private static int currentRoom = 0;
	
	public static void setCurrentRoom(int id) { currentRoom = id; }
	public static Room getCurrentRoom(int id) { return rooms[id]; }
	
	public static int getCurrentFloorHeight() { return rooms[currentRoom].getFloorHeight(); }
	
	public static boolean isRectangleColliding(Rectangle r) { return rooms[currentRoom].isRectangleColliding(r); }
	
	public static void loadAllRooms(SaveGame saveGame) {
		rooms = saveGame.getRooms();
		
		for(int i = 0; i < rooms.length; i++) {
			// Load content of rooms (textures etc.)
			rooms[i].loadContent();
		}
	}
	
	public static Vector2 getCurrentRoomDimensions(){
		return rooms[currentRoom].getDimensions();
	}
	
	public static void update() {
		rooms[currentRoom].update();
	}
	
	public static void render(SpriteBatch batch) {
		rooms[currentRoom].render(batch);
	}
	
	public static SaveGame newGame() {
		Item[] tempItems;
		SaveGame result;
		
		/* Added rooms:
		 * Bathroom
		 * 
		 * Rooms to be added:
		 * Hallway
		 * Tourist info
		 * Transit station
		 * Security
		 * Living quarters hallway
		 * Scientist room
		 * Players personal room
		 * Cafeteria
		 */
		
		// Bathroom
		Room bathroom = new Room(0, "Bathroom");
		tempItems = new Item[] {
				new Background("rooms/bathroom.png", 1, 0, 0),
				new Handbag(0, 1219 - 36 + 3, 720 - 226 - 105),
				new Door(1, 20, 85)
		};
		bathroom.setItems(tempItems);
		bathroom.setDimensions(2300, 720);
		bathroom.setFloorHeight(120);
		bathroom.addCollisionBox(275, 720 - 545 - 75, 884, 720);
		bathroom.addCollisionBox(1400, 0, 720, 720);
		
		/*Room hallway = new Room(1, "Hallway");
		tempItems = new Item[] {
				new Background("rooms/hallway.png", 1, 0, 0),
				new Door(2, 0, 0)
		};
		hallway.setItems(tempItems);
		hallway.setDimensions(100, 720);
		hallway.setFloorHeight(120); */
		
		// Load into new save game
		Room[] allRooms = new Room[] {
				bathroom//,
				//hallway
		};
		result = new SaveGame();
		result.setRooms(allRooms);
		return result;
	}

}
