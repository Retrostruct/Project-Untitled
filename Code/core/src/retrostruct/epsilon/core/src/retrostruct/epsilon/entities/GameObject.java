package retrostruct.epsilon.entities;

import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
	
	protected Vector2 position;
	
	public float getX() { return position.x; }
	public float getY() { return position.y; }
	
	public GameObject(float x, float y) { 
		position = new Vector2(x, y);
	}
}
