package com.retrostruct.epsilon;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.awt.Rectangle;

import jdk.nashorn.internal.runtime.NumberToString;

/**
 * Created by sebastian.fransson on 2015-11-18.
 */
public class Choice {
    String text = "Hej";
    Vector2 position = new Vector2(150, 150);
    String[] choices;
    Texture img;
    Vector2 imgPosition;
    Rectangle rectangle;
    float stringHeight;

    public Choice(String[] choices){
        this.choices = choices;
        img = new Texture(Gdx.files.internal("blackBar.png"));
    }

    public void Render(SpriteBatch spriteBatch, BitmapFont font){

        stringHeight = font.getCapHeight();

        //spriteBatch.draw(img, 0, -1080 + (stringHeight) * choices.length);

        //spriteBatch.draw(img, 0, 500 - 53);




        //String height
        font.draw(spriteBatch, Float.toString(stringHeight), 0, 500);



        for(int i = 0; i < choices.length; i++){

            spriteBatch.draw(img, 0, 0 + ((stringHeight * 1.75f) * i), 2000f, (stringHeight * 1.75f));
            if(Gdx.input.isTouched()){
                font.setColor(Color.BLUE);
            }

            font.draw(spriteBatch, choices[i], 50, font.getLineHeight() + ((font.getLineHeight() + 10) * i));

        }


        //font.draw(spriteBatch, text, position.x, position.y);
    }
}
