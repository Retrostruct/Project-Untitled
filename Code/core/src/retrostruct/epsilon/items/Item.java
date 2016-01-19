package retrostruct.epsilon.items;

import retrostruct.epsilon.entities.GameObject;

public abstract class Item extends GameObject {

	protected String name;
	protected int width, height;
	
	public String getName() { return name; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	public boolean intersects(int x, int y) {
		return 	x > position.x && x < position.x + width &&
				y > position.y && y < position.y + height;
	}
	
	public Item(String name, float x, float y, int width, int height) {
		super(x, y);
		this.name = name;
		this.width = width;
		this.height = height;
	}
}
