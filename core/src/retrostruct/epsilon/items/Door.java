package retrostruct.epsilon.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import retrostruct.epsilon.enums.Verbs;
import retrostruct.epsilon.graphics.Animation;
import retrostruct.epsilon.interfaces.Interactable;
import retrostruct.epsilon.interfaces.Renderable;
import retrostruct.epsilon.interfaces.Updateable;

public class Door extends Item implements Updateable, Renderable, Interactable {

	private static final long serialVersionUID = -7282199966294906443L;
	
	Animation animation;

	public Door(int id, float x, float y) {
		super("Door", id, x, y, 4096/10, 597);
	}
	
	public void loadContent() {
		animation = new Animation("door.png", 4096/10, 597);
		animation.setInterval(10);
	}

	@Override
	public String interact(Verbs verb) {
		return null;
	}

	@Override
	public void update() {
	}

	@Override
	public void render(SpriteBatch batch) {
		animation.render(batch, position);
	}

}