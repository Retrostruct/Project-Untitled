package retrostruct.epsilon.input;

import java.io.Serializable;

import com.badlogic.gdx.Input.Keys;

public abstract class KeyBindings implements Serializable {
	private static final long serialVersionUID = 5813489845738905655L;
	
	public static int UP = Keys.W;
	public static int DOWN = Keys.S;
	public static int RIGHT = Keys.D;
	public static int LEFT = Keys.A;
	public static int ACTION = Keys.E;
	
	public static void rebindKey(int key, int newValue) {
		key = newValue;
	}

}
