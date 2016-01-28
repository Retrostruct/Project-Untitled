package retrostruct.epsilon.handlers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import retrostruct.epsilon.Log;
import retrostruct.epsilon.entities.Player;
import retrostruct.epsilon.enums.Verbs;
import retrostruct.epsilon.interfaces.Interactable;
import retrostruct.epsilon.interfaces.Renderable;
import retrostruct.epsilon.items.Item;

public class ItemHandler {
	
	private static ArrayList<Item> items = new ArrayList<Item>();
	
	public static void AddItem(Item item) {
		// Add item to list
		items.add(item);
		Log.print("Added item \"" + item.getName() + "\"");
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
	
	public static void flush() {
		items.clear();
	}
	
	public static void render(SpriteBatch batch) {
		for(Item item: items) {
			if(item instanceof Renderable) {
				((Renderable)item).render(batch);
			}
		}
	}

}
