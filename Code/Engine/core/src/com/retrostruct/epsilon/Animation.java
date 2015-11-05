package com.retrostruct.epsilon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Simon on 11/4/2015.
 */
public class Animation {
    Texture texture;
    int frameX, frameY, imgX, imgY, srcX, srcY, timer, interval;

    public Animation(String path, int frameX, int frameY, int interval) {
        this.frameX = frameX;
        this.frameY = frameY;
        this.interval = interval;
        texture = new Texture(path);
        imgX = texture.getWidth();
        imgY = texture.getHeight();
        srcX = 0;
        srcY = 0;
    }

    public void changeAnimation(int n) {
        srcX = 0;
        srcY = n - 1;
        timer = 0;
    }

    public void update(float dt) {
        timer++;
        if(timer >= interval) {
            timer = 0;
            srcX++;
            srcX %= imgX / frameX;
            System.out.println(srcX);
        }
    }

    public void draw(SpriteBatch batch, float x, float y) {
        batch.draw(texture, x, y, srcX * frameX, srcY * frameY, frameX, frameY);
    }
}
