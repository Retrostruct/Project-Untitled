package retrostruct.epsilon.handlers;

import java.lang.reflect.InvocationTargetException;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import retrostruct.epsilon.Levels;

public class LevelHandler {
	
	public static int currentId;
	
	public static void setLevel(int id) {
		currentId = id;
		ItemHandler.flush();
		try {
			Levels.class.getMethods()[id].invoke(null);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void render(SpriteBatch batch) {
		ItemHandler.render(batch);
	}
}
