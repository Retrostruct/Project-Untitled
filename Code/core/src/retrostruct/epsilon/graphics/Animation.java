package retrostruct.epsilon.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Animation {
	
	private Texture sheet;
	private int x, y, frameX, frameY;
	private float timer, interval;
	
	public Animation(String path, int frameX, int frameY) {
		sheet = new Texture(path);
		this.frameX = frameX;
		this.frameY = frameY;
		x = 0;
		y = 0;
		timer = 0.0f;
		interval = 0.0f;
	}
	
	public void render(SpriteBatch batch, Vector2 position) {
		batch.draw(sheet, position.x, position.y, x * frameX, y * frameY, frameX, frameY);
		
		if(interval == 0.0f) return;
		
		timer += Gdx.graphics.getDeltaTime();
		if(timer >= interval) {
			timer = 0.0f;
			if((x + 1) * frameX < sheet.getWidth())	x++;
			else x = 0;
		}
	}

}
