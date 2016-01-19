package retrostruct.epsilon.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import retrostruct.epsilon.enums.Verbs;
import retrostruct.epsilon.interfaces.Interactable;
import retrostruct.epsilon.interfaces.Renderable;

public class Handbag extends Item implements Interactable, Renderable {
	
	String[] interactDefault = new String[] {
			"0", // First element holds how many times a message has been returned
			"Hmm, that don't seem to work...",
			"No, still doesn't work!",
			"..."
	};
	
	String[] pickUp = new String[] {
			"0",
			"Hey, I could use this handbag for storage!",
			""
	};
	
	Texture texture; // Can be replaced with an animation or whatever
	
	public Handbag() {
		super("Handbag", 0, 0, 512, 512);
		texture = new Texture("handbag.png");
	}

	public String interact(Verbs verb) {
		switch(verb) {
		case PICK_UP:
			return getMessage(pickUp);
			default: return getMessage(interactDefault);
		}
	}
	
	private String getMessage(String[] array) {
		// Parse the first element of array
		int i = Integer.parseInt(array[0]);
		// Check if array contains more messages
		if(i <= array.length - 2) i++;			
		// Put back the (new) value
		array[0] = "" + i;
		// Return message
		return array[i];
	}

	public void render(SpriteBatch batch) {
		batch.draw(texture, position.x, position.y);
	}
	
}
