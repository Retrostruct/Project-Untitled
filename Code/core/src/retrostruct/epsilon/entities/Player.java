package retrostruct.epsilon.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

import retrostruct.epsilon.enums.Verbs;
import retrostruct.epsilon.graphics.Animation;
import retrostruct.epsilon.handlers.ItemHandler;
import retrostruct.epsilon.handlers.MouseHandler;

public class Player extends Character {
	
	private int direction = 0;
	private int target = 0;
	private float speed = 100.0f;
	private int[] storage = new int[8]; // Create an inventory with 8 slots
	
	public int getItemIdFromStorage(int i) { return storage[i]; } // Should probably check for array out of bounds exeption...

	public Player(float x, float y) {
		super(x, y);
		animation = new Animation("badlogic.jpg", 256, 256);
	}
	
	public void update(MouseHandler mouse, OrthographicCamera camera) {
		if(mouse.isPressed()) {
			// If nothing is pressed, instead set the target
			if(!ItemHandler.interact(mouse.getX(), mouse.getY(), Verbs.PICK_UP, this))
				target = mouse.getX();
		}
		
		// Reset direction
		direction = 0;
		
		// Get direction 
		if(target > position.x + speed) direction = 1;
		else if(target < position.x) direction = -1;
		
		// Calculate velocity with delta time
		float velocity = direction * speed * Gdx.graphics.getDeltaTime();
		
		// Translate camera and move player
		camera.translate(velocity, 0);
		camera.position.x = Math.max(0, Math.min(100, camera.position.x));
		position.x += velocity;
		
	}
}
