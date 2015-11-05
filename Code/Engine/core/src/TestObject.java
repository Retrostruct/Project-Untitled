/**
 * Created by Kasper on 11/5/2015.
 */
public class TestObject extends GameObject {

    public TestObject(){
        possibleInteractions[0] = Interactions.Use;
        possibleInteractions[1] = Interactions.Use.PickUp;
        possibleInteractions[2] = Interactions.Push;
    }

    @Override
    public void onInteract(Interactions interaction) {
        int indexCheck = 0;

        //Run through all the interactions avalible as possible interactions
        for (Interactions i:
             possibleInteractions) {

            //If the interaction the program tries to perform is possible check which of the actions it is an run the appropriate code
            if(interaction == i){

                if(indexCheck == 0){
                    //Run code for USE
                }
                if(indexCheck == 1){
                    //Run code for PICK UP
                }
                if(indexCheck == 2){
                    //Run code for PUSH
                }

            }

            indexCheck++;
        }
    }
}
