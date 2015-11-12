package com.retrostruct.epsilon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Simon on 11/4/2015.
 */
public class Player {
	Animation ani;
    Vector2 pos, dir, origin;
    int w, h;
    float speed = 100;
    Texture collision;

    public Player(Vector2 pos) {
    	w = 50;
        h = 50;
        ani = new Animation("data/AnimationTest.png", w, h, 10);
        this.pos = new Vector2(pos.x - w / 2, pos.y - h / 2);
        dir = new Vector2(0, 0);
        origin = new Vector2(0, 0);
        
        collision = new Texture("data/collision.png");
    }

    public void move(Vector2 vec) {
    	if(vec == null) { return; }
    	float dx = vec.x - origin.x;
    	float dy = vec.y - origin.y;
    	if(Math.abs(dx) < 1) { dir.x = 0; } 
    	else { dir.x = dx; }
    	if(Math.abs(dy) < 1) { dir.y = 0; } 
    	else { dir.y = dy; }
        dir.nor();
    }
    
    public Boolean isMoving() {
    	return (dir.x != 0 && dir.y != 0);
    }

    public void update(float dt) {
    	if(isMoving() && ani.getCurrentAnimation() != 2) {
    		ani.changeAnimation(2);
    	} else if(!isMoving() && ani.getCurrentAnimation() != 1) {
    		ani.changeAnimation(1);
    	}
    	
        pos.x += dir.x * speed * dt;
        pos.y += dir.y * speed * dt;
        origin.x = pos.x + (w / 2);
        origin.y = pos.y + (h / 2);
        ani.update(dt);
    }

    public void draw(SpriteBatch batch) {
    	batch.draw(collision, 0, 0);
        ani.draw(batch, pos.x, pos.y);
    }
}
