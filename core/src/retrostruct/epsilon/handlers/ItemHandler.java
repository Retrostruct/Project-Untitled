package retrostruct.epsilon.handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import retrostruct.epsilon.debug.Log;
import retrostruct.epsilon.entities.Player;
import retrostruct.epsilon.enums.Verbs;
import retrostruct.epsilon.interfaces.Interactable;
import retrostruct.epsilon.interfaces.Renderable;
import retrostruct.epsilon.items.Item;

public class ItemHandler {
	
	private static Item[] items;
	
	public static void setItems(Item[] newItems) {
		// Add item to list
		items = newItems;
		for(int i = 0; i < items.length; i++) {
			Log.print("Added item \"" + items[i].getName() + "\"");
		}
	}
	
	public static boolean interact(int x, int y, Verbs verb, Player player) {
		// Loop through all elements
		for(Item item: items) {
			// Check for intersection and if item is interactable
			if(item.intersects(x, y) && item instanceof Interactable) {
				// Cast to interactable and interact 
				player.say(((Interactable)item).interact(verb));
				// Since only one item can be interacted with at a time, return
				return true;
			}
		}
		return false;
	}
	
	public static void render(SpriteBatch batch) {
		for(Item item: items) {
			if(item instanceof Renderable) {
				((Renderable)item).render(batch);
			}
		}
	}

}