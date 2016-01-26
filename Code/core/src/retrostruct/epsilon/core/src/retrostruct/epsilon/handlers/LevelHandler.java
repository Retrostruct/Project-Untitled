package retrostruct.epsilon.handlers;

import java.lang.reflect.InvocationTargetException;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import retrostruct.epsilon.Levels;
import retrostruct.epsilon.Log;

public class LevelHandler {
	
	private static int currentId;
	private static int levelWidth;
	
	public static int getCurrentId() { return currentId; }
	public static int getLevelWidth() { return levelWidth; }
	
	public static void setLevel(int id) {
		currentId = id;
		ItemHandler.flush();
		try {
			levelWidth = (int)Levels.class.getMethods()[id].invoke(null);
			Log.print("Level " + id + " loaded successfully");
			return;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		Log.print("There was a problem loading level id:" + id + "");
	}

	public static void render(SpriteBatch batch) {
		ItemHandler.render(batch);
	}
}
