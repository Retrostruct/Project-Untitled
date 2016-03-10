package retrostruct.epsilon.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
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
	private int floorHeight = 0;
	private List<Rectangle> collisionBoxes = new ArrayList<Rectangle>();
	//Texture bar;
	
	public void addCollisionBox(int x, int y, int w, int h) {
		collisionBoxes.add(new Rectangle(x, y, w, h));
	}
	
	public boolean isRectangleColliding(Rectangle r) {
		for(int i = 0; i < collisionBoxes.size(); i++) {
			if(collisionBoxes.get(i).overlaps(r))
				return true;
		}
		
		return false;
	}
	
	public void setFloorHeight(int height) { floorHeight = height; }
	public int getFloorHeight() { return floorHeight; }

	public void setName(String name) { this.name = name; }
	public void setId(int id) { this.id = id; }
	public void setItems(Item[] items) { this.items = items;}
	
	public String getName() { return name; }
	public int getId() { return id; }
	public Item getItem(int index) { return items[index]; }
	
	public void setDimensions(int x, int y) {
		dimensions.x = x;
		dimensions.y = y;
	}
	public Room() {
		dimensions = new Vector2();
		//bar = new Texture("blackBar.png");
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
		
		/*for(int i = 0; i < collisionBoxes.size(); i++) {
			batch.draw(bar, collisionBoxes.get(i).x,
							collisionBoxes.get(i).y,
							collisionBoxes.get(i).width,
							collisionBoxes.get(i).height);
		}*/
	}
	
	public String toString() {
		return "name: " + name + " id: " + id;
	}
}
