package retrostruct.epsilon.entities;

import java.io.Serializable;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import retrostruct.epsilon.interfaces.Renderable;
import retrostruct.epsilon.interfaces.Updateable;
import retrostruct.epsilon.items.Item;

public class Room implements Serializable {
	private static final long serialVersionUID = -4039790834758952049L;
	private String name;
	private int id;
	private Item[] items;
	private Vector2 dimensions; 

	public void setName(String name) { this.name = name; }
	public void setId(int id) { this.id = id; }
	public void setItems(Item[] items) { this.items = items;}
	
	public String getName() { return name; }
	public int getId() { return id; }
	public Item getItem(int index) { return items[index]; }
	
	public Room() {
		dimensions = new Vector2();
	}
	
	public void loadContent() {
		for(Item item: items) {
			item.loadContent();
		}		
		
		//Get room dimensions from background texture
		dimensions.x = items[0].getWidth();
		dimensions.y = items[0].getHeight();
	}
	
	public Vector2 getDimensions(){
		return dimensions;
	}
	
	public void update() {
		for(Item item: items) {
			if(item instanceof Updateable) {
				((Updateable)item).update();
			}
		}
	}
	
	public void render(SpriteBatch batch) {
		for(Item item: items) {
			if(item instanceof Renderable) {
				((Renderable)item).render(batch);
			}
		}
	}
	
	public String toString() {
		return "name: " + name + " id: " + id;
	}
}
