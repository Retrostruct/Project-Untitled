package retrostruct.epsilon;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import retrostruct.epsilon.interfaces.Renderable;

public class Level implements Renderable {
	
	private int id;
	
	public int getId() { return id; }
	
	public Level(int id) {
		this.id = id;
	}

	public void render(SpriteBatch batch) {
		
	}

}
