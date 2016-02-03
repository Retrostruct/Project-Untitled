package retrostruct.epsilon.handlers;


import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;


/**
 * Created by sebastian.fransson on 2015-11-18.
 */

public class Choice {

    Choices[] choices;
    String[] text;
    public boolean activated = false;
    int selected = 0;

    public Choice(String[] text){

        this.text = text;
        choices = new Choices[text.length];

        for (int i = 0; i < text.length; i++){
            choices[i] = new Choices(new Vector2(0,80 * i), new Vector2(1920, 80), text[i], i);
        }



    }

    public void Render(SpriteBatch spriteBatch, BitmapFont font, Stage stage){


        for (int i = 0; i < choices.length; i++){
            choices[i].Render(spriteBatch, stage, font);
            if(choices[i].activated){
                selected = choices[i].number;
                activated = true;
            }

        }

    }
}
