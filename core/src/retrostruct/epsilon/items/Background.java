package retrostruct.epsilon.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import retrostruct.epsilon.interfaces.Renderable;

@SuppressWarnings("serial")
public class Background extends Item implements Renderable{

	Texture texture;
	
	public Background(String name, int id, float x, float y) {
		super(name, id, x, y, 0, 0);
	}

	@Override
	public void loadContent() {
		texture = new Texture(name);
		this.width = texture.getWidth();
		this.height = texture.getHeight();
	}
	
	
	@Override
	public void render(SpriteBatch batch) {
		
		batch.draw(texture, position.x, position.y);
	}	
	
}
