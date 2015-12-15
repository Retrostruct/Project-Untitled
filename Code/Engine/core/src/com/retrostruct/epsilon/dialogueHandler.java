package com.retrostruct.epsilon;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;

/**
 * Created by sebastian.fransson on 2015-12-11.
 */
public class dialogueHandler {
    dialogue firstDialogue;
    dialogue[] nextDialogue;
    Choice choice;
    public boolean done;


    public dialogueHandler(dialogue firstDialogue, dialogue[] nextDialogue, Choice choice, BitmapFont font){
        this.firstDialogue = firstDialogue;
        this.choice = choice;

        this.nextDialogue = nextDialogue;
    }

    public void Render(SpriteBatch spriteBatch, BitmapFont font, Stage stage){
        if(!firstDialogue.done)
            firstDialogue.Render(spriteBatch, font);

        if(firstDialogue.done && !choice.activated)
            choice.Render(spriteBatch, font, stage);

        if(choice.activated && !nextDialogue[choice.selected].done)
            nextDialogue[choice.selected].Render(spriteBatch, font);
    }
}
