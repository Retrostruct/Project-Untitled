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
	private int targetX;
	private int targetY;
	private int floorHeight = 150;
	private float speed = 200.0f;
	private int[] storage = new int[8]; // Create an inventory with 8 slots
	
	public int getItemIdFromStorage(int i) { return storage[i]; } // Should probably check for array out of bounds exception...

	public Player(float x, float y) {
		super(x, y);
		animation = new Animation("badlogic.jpg", 256, 256);
		targetX = (int)x;
		targetY = (int)y;
	}
	
	public void update(OrthographicCamera camera) {
		if(MouseHandler.isPressed()) {
			// If nothing is pressed, instead set the target
			if(!ItemHandler.interact(MouseHandler.getX(), MouseHandler.getY(), Verbs.PICK_UP, this))
				targetX = MouseHandler.getX();
				targetY = MouseHandler.getY();
		}
		
		// Reset direction
		direction.x = 0;
		direction.y = 0;
		
		if(targetX > position.x) direction.x = 1;
		else if(targetX < position.x) direction.x = -1;
		
		if(targetY > position.y) direction.y = 1;
		else if(targetY < position.y) direction.y = -1;
		
		float velocityx = direction.x * speed * Gdx.graphics.getDeltaTime();
		
		float someValue = 1.0f; // TODO: Make this value depend on the direction vector which should be normalized
		float velocityy = direction.y * speed * Gdx.graphics.getDeltaTime() * someValue;
		
		if(targetX > position.x) position.x = MathHandler.clamp(position.x + velocityx, position.x, targetX);
		else if(targetX < position.x) direction.x = position.x = MathHandler.clamp(position.x + velocityx, targetX, position.x);
		
		if(targetY > position.y) position.y = MathHandler.clamp(position.y + velocityy, position.y, targetY);
		else if(targetY < position.y) direction.y = position.y = MathHandler.clamp(position.y + velocityy, targetY, position.y);
		
		
		camera.position.x = position.x + this.animation.getWidth() / 2;
		camera.translate(velocityx, 0);
		
		position.y = MathHandler.clamp(position.y, (float)(0), (float)(floorHeight));
	}
	

}