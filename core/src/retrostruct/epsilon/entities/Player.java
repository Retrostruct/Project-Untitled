package retrostruct.epsilon.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

import retrostruct.epsilon.enums.Verbs;
import retrostruct.epsilon.graphics.Animation;
import retrostruct.epsilon.handlers.ItemHandler;
import retrostruct.epsilon.handlers.MathHandler;
import retrostruct.epsilon.input.MouseHandler;

public class Player extends Character {
	private static final long serialVersionUID = -5509279692571456935L;
	
	private Vector2 direction = new Vector2();
	private int targetX; // The x-position of the target(mouse position)
	private int targetY; // The y-position of the target(mouse position)
	private int floorHeight = 150; // Height of the floor, this is used so the player can walk along the y-axis
	private float speed = 200.0f; // General player movment speed
	private int[] storage = new int[8]; // Create an inventory with 8 slots
	
	public int getItemIdFromStorage(int i) { return storage[i]; } // TODO: Should probably check for array out of bounds exception...

	public Player(float x, float y) {
		super(x, y);
		animation = new Animation("badlogic.jpg", 256, 256); // Load the animation
		// Set target to initial position in order to prevent movement at first
		targetX = (int)x;
		targetY = (int)y;
	}
	
	public void update(OrthographicCamera camera) {
		if(MouseHandler.isPressed()) {
			// If nothing is pressed, instead set the target
			if(!ItemHandler.interact(MouseHandler.getX(), MouseHandler.getY(), Verbs.PICK_UP, this)) // TODO: Not sure why interact is used here...
				targetX = MouseHandler.getX();
				targetY = MouseHandler.getY();
		}
		
		// Reset direction
		direction.x = targetX - position.x;
		direction.y = targetY - position.y;
		
		direction.nor();
		
		System.out.println(direction.toString());
		
		float velocityx = direction.x * speed * Gdx.graphics.getDeltaTime();
		
		float velocityy = direction.y * speed * Gdx.graphics.getDeltaTime();
		
		if(targetX > position.x) position.x = MathHandler.clamp(position.x + velocityx, position.x, targetX);
		else if(targetX < position.x) direction.x = position.x = MathHandler.clamp(position.x + velocityx, targetX, position.x);
		
		if(targetY > position.y) position.y = MathHandler.clamp(position.y + velocityy, position.y, targetY);
		else if(targetY < position.y) direction.y = position.y = MathHandler.clamp(position.y + velocityy, targetY, position.y);
		
		
		camera.position.x = position.x + this.animation.getWidth() / 2;
		camera.translate(velocityx, 0);
		
		position.y = MathHandler.clamp(position.y, (float)(0), (float)(floorHeight));
	}
	

}