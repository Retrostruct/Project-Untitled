package retrostruct.epsilon.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import retrostruct.epsilon.enums.Verbs;
import retrostruct.epsilon.interfaces.Interactable;
import retrostruct.epsilon.interfaces.Renderable;
import retrostruct.epsilon.interfaces.Updateable;

public class Door extends Item implements Updateable, Renderable, Interactable {

	private static final long serialVersionUID = -7282199966294906443L;

	public Door(String name, int id, float x, float y, int width, int height) {
		super(name, id, x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void loadContent() {
		
	}

	@Override
	public String interact(Verbs verb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}

}
