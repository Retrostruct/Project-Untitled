package retrostruct.epsilon.handlers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import retrostruct.epsilon.Log;
import retrostruct.epsilon.Room;
import retrostruct.epsilon.entities.Player;

public class SaveGame implements Serializable {
	private static final long serialVersionUID = 217231781995547266L;
	
	public static final String SAVE_GAME_PATH = "Saves/";
	public static final String NEW_GAME_PATH = "Saves/NewGame/";

	private Room[] rooms;
	private Player player;
	
	public void setRooms(Room[] rooms) { this.rooms = rooms; }
	public void setPlayer(Player player) { this.player = player; }
	
	public Room[] getRooms() { return rooms; }
	public Player getPlayer() { return player; }
	
	public void Save(int id) {
		try {
			String path = SAVE_GAME_PATH + "save" + id;
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
			System.out.println("Done!");
		} catch(IOException i) {
			i.printStackTrace();
		}
		
		Log.print("Game saved id:" + id);
	}
	
	public SaveGame Load(int id) {
		SaveGame s = null;
		try {
			FileInputStream fileIn = new FileInputStream("Saves/save" + id);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			s = (SaveGame)in.readObject();
			in.close();
			fileIn.close();
		} catch(IOException i) {
			i.printStackTrace();
		} catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		
		Log.print("Save game loaded id:" + id);
		
		return s;
	}

}
