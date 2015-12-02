package com.retrostruct.epsilon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Kasper on 11/4/2015.
 */
public abstract class Interactable {

    protected Interactions[] possibleInteractions = new Interactions[3];
    protected Vector2 position;
    protected Texture texture;
    protected String[] examine;
    protected int timesExamined;

    public Interactable(){
        timesExamined = 0;
    }

    public void create(String assetName, int x, int y){
        texture = new Texture(assetName);
        position = new Vector2(x,y);
    }

    public void onLoad(){

    }

    public Interactions[] getPossibleInteractions(){
        return possibleInteractions;
    }

    public void onInteract(Interactions interaction, Player player){
        Gdx.app.debug("com.retrostruct.epsilon.Interactable used as child: ", "onInteract function is not defined for current object (" + this.toString() + ")");
    }

    /***onExamine should be run when player is examining the com.retrostruct.epsilon.Interactable**/
    public String onExamine(){
        if(timesExamined > examine.length + 1){
            timesExamined = examine.length + 1;
        }

        timesExamined++;

        return examine[timesExamined-1];
    }
}
