package com.retrostruct.epsilon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;

import java.util.List;

import javafx.concurrent.Task;

/**
 * Created by sebastian.fransson on 2015-12-09.
 */
public class dialogue {

    String[] strings;
    Texture image;
    float seconds = 0;
    float interval;
    GlyphLayout layout;
    int stringNumber = 0;
    public boolean done = false;


    public dialogue(String[] strings){
        this.strings = strings;
        image = new Texture(Gdx.files.internal("red.jpg"));
        layout = new GlyphLayout();
    }


    public void Render(SpriteBatch spriteBatch, BitmapFont font){

        layout.setText(font, strings[stringNumber]);//dont do this every frame! Store it as member

        float width = layout.width;// contains the width of the current set text
        float height = layout.height; // contains the height of the current set text

        font.draw(spriteBatch, strings[stringNumber], 400 - width/2,  500 + height/2);

        interval = strings[stringNumber].length() * 0.1f;//Sets the time for how long the set of text will be shown on the screen before the timer resets


        //timer
        if(stringNumber < strings.length){
            seconds += Gdx.graphics.getDeltaTime();
        }

        if(stringNumber == strings.length)
            seconds += Gdx.graphics.getDeltaTime();

        if(seconds >= interval && stringNumber < strings.length - 1){
            seconds = 0;
            stringNumber++;
        }

        if(seconds > interval && stringNumber == strings.length - 1){
            done = true;
        }

        if(done)
            font.draw(spriteBatch, Float.toString(1231f), 400,  100);


        font.draw(spriteBatch, Float.toString(seconds), 400,  400);
        font.draw(spriteBatch, Float.toString(interval), 800,  400);
        spriteBatch.draw(image, 400, 400);


    }

}

