package com.retrostruct.epsilon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

/**
 * Created by Simon on 11/4/2015.
 */
public class Player {
    List<Animation> animations;
    Vector2 position, velocity, direction;
    int moveX, moveY;
    float speed = 1;

    public Player() {

    }

    public void load(Vector2 position, Vector2 direction) {
        this.position = position;
        this.direction = direction;
    }

    public void move(int x, int y) {
        moveX = x;
        moveY = y;
    }

    public void update(float dt) {
        position.x += velocity.x * speed * dt;
        position.y += velocity.y * speed * dt;
    }

    public void draw(SpriteBatch batch) {
        for (Animation a:
             animations) {
            a.draw(batch, position.x, position.y);
        }
    }
}
