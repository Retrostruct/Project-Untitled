package com.retrostruct.epsilon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by sebastian.fransson on 2016-01-26.
 */
public class GUI {

    public static Texture inventory;
    Vector2 position;
    Vector2[] slots = new Vector2[6];

    public GUI(){

        inventory = new Texture(Gdx.files.internal("inventory.png"));
        position = new Vector2(Gdx.graphics.getWidth()/2 - inventory.getWidth()/2, Gdx.graphics.getHeight()/2 - inventory.getHeight()/2);
        Gdx.graphics.getHeight();

        for(int i = 0; i < slots.length; i++) {
            if(i < 3) slots[i] = new Vector2(position.x +  50 * i, 500);
            if(i > 3) slots[i] = new Vector2(position.x - (50 * 3) + 0, 300);
        }

    }

    public void Render(SpriteBatch spriteBatch){


        spriteBatch.draw(inventory, position.x, position.y);
    }
}


