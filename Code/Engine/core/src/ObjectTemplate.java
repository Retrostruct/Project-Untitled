/**
 * Created by Kasper on 11/5/2015.
 * This should serve as the basic object set up.
 */
public class ObjectTemplate extends GameObject {

    public ObjectTemplate(){
        possibleInteractions[0] = Interactions.Use;
        possibleInteractions[1] = Interactions.Use.PickUp;
        possibleInteractions[2] = Interactions.Push;
    }

    public void create(Interactions[] possibleInteractions, String examinationString){
        this.possibleInteractions = possibleInteractions;
        this.examine = examinationString;
    }

    @Override
    public void onInteract(Interactions interaction) {
        int indexCheck = 0;

        boolean interacted = false;

        //Run through all the interactions avalible as possible interactions
        for (Interactions i:
             possibleInteractions) {

            //If the interaction the program tries to perform is possible check which of the actions it is an run the appropriate code
            if(interaction == i){

                if(indexCheck == 0){
                    //Run code for USE

                    break;
                }
                if(indexCheck == 1){
                    //Run code for PICK UP

                    break;
                }
                if(indexCheck == 2){
                    //Run code for PUSH

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
}