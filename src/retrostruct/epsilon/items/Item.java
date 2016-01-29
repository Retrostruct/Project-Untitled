package retrostruct.epsilon.items;

import retrostruct.epsilon.entities.GameObject;

@SuppressWarnings("serial")
public abstract class Item extends GameObject {

	protected String name;
	protected int id;
	protected int width, height;
	
	public String getName() { return name; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	public boolean intersects(int x, int y) {
		return 	x > position.x && x < position.x + width &&
				y > position.y && y < position.y + height;
	}
	
	public Item(String name, int id, float x, float y, int width, int height) {
		super(x, y);
		this.name = name;
		this.id = id;
		this.width = width;
		this.height = height;
	}
	
	public abstract void loadContent();
}
