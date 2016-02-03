package retrostruct.epsilon.entities;

import java.io.Serializable;

import com.badlogic.gdx.math.Vector2;

@SuppressWarnings("serial")
public abstract class GameObject implements Serializable {
	
	protected Vector2 position;
	
	public float getX() { return position.x; }
	public float getY() { return position.y; }
	
	public GameObject(float x, float y) { 
		position = new Vector2(x, y);
	}
}
