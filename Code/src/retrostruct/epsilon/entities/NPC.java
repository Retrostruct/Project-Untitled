package retrostruct.epsilon.entities;

import retrostruct.epsilon.enums.Verbs;
import retrostruct.epsilon.interfaces.Interactable;

@SuppressWarnings("serial")
public abstract class NPC extends Character implements Interactable {

	public NPC(float x, float y) {
		super(x, y);
		
	}

	@Override
	public String interact(Verbs verb) {
		return null;
	}

}
