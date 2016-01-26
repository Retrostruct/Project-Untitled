package retrostruct.epsilon.handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;

public class MouseHandler {
	private Vector3 position;
	private boolean pressed, wasPressed;
	
	public int getX() { return (int)position.x; }
	public int getY() { return (int)position.y; }
	public boolean isPressed() { return pressed && !wasPressed; }
	
	public MouseHandler() {
		position = new Vector3(0, 0, 0);
	}
	
	public void update(Camera camera) {
		// Get screen coordinates
		position.x = Gdx.input.getX();
		position.y = Gdx.input.getY();
		
		// Check if left mouse button is pressed
		wasPressed = pressed;
		pressed = Gdx.input.isButtonPressed(Buttons.LEFT);
		
		// Unproject to world coordinates
		camera.unproject(position);
	}
}
