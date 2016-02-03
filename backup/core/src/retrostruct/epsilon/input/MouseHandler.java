package retrostruct.epsilon.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;

public class MouseHandler {
	private static Vector3 position = new Vector3(0, 0, 0);
	private static boolean pressed, wasPressed;
	
	public static int getX() { return (int)position.x; }
	public static int getY() { return (int)position.y; }
	public static boolean isPressed() { return pressed && !wasPressed; }
	
	public static void update(Camera camera) {
		// Get screen coordinates
		position.x = Gdx.input.getX();
		position.y = Gdx.input.getY();
		
		// Check if left mouse button is pressed
		wasPressed = pressed;
		pressed = Gdx.input.isButtonPressed(Buttons.LEFT) || Gdx.input.isTouched();
		
		// Unproject to world coordinates
		camera.unproject(position);
	}
}
