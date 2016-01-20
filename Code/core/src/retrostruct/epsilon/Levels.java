package retrostruct.epsilon;

import retrostruct.epsilon.handlers.ItemHandler;
import retrostruct.epsilon.items.Handbag;

public class Levels {
	
	public static void bathroom() {
		ItemHandler.AddItem(new Handbag(0, 0));
		System.out.println("Well, this works");
	}

}
