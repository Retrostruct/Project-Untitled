package com.retrostruct.epsilon;

import com.badlogic.gdx.Gdx;

/**
 * Created by kasper.esbjornsson on 11/4/2015.
 */
public abstract class GameObject extends Interactable {

    public GameObject(){

    }

    @Override
    public void onInteract(Interactions interaction) {
        super.onInteract(interaction);
    }

    protected void impossibleInteraction(String currentObject){
        try{
            throw new Exception("Tried interaction not viable for " + currentObject + ".");
        }
        catch (Exception e){
            Gdx.app.debug("Non possible interaction: ", e.toString() + " No action will be taken.");
        }
    }

}
