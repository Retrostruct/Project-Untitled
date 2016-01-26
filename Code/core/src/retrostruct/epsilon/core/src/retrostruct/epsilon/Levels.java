package retrostruct.epsilon;

import retrostruct.epsilon.handlers.ItemHandler;
import retrostruct.epsilon.items.Handbag;

public class Levels {
	
	public static int bathroom() {
		ItemHandler.AddItem(new Handbag(0, 0));
		return 1280;
	}

}
