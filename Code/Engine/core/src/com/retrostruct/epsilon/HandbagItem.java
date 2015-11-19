package com.retrostruct.epsilon;

/**
 * Created by kasper.esbjornsson on 11/18/2015.
 */
public class HandbagItem extends GameObject {
    public HandbagItem(){
        possibleInteractions[0] = Interactions.PickUp;
        possibleInteractions[1] = Interactions.TalkTo;
        possibleInteractions[2] = Interactions.Use;
        examine = new String[5];

        examine[0] = "It's a handbag";
        examine[1] = "Yep... Still a handbag";
        examine[2] = "Maybe if I keep staring at it it will turn into something else?";
        examine[3] = "I think it's working... No wait... No it isn't";
        examine[4] = "Should I take it? I mean, it doesn't seem as if anyone else wants it?";
    }

    @Override
    public void onInteract(Interactions interaction, Player player) {
        int indexCheck = 0;

        boolean interacted = false;

        //Run through all the interactions avalible as possible interactions
        for (Interactions i:
                possibleInteractions) {

            //If the interaction the program tries to perform is possible check which of the actions it is an run the appropriate code
            if(interaction == i){

                if(indexCheck == 0){
                    //Run code for Pick up

                    break;
                }
                if(indexCheck == 1){
                    //Run code for Talk To

                    break;
                }
                if(indexCheck == 2){
                    //Run code for Use

                    break;
                }

                interacted = true;
            }

            indexCheck++;

        }

        if(!interacted) {
            impossibleInteraction(this.toString());
        }
    }

    @Override
    public String onExamine() {
        return super.onExamine();
    }
}
