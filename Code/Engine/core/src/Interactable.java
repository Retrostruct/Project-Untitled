import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

/**
 * Created by kasper.esbjornsson on 11/4/2015.
 */
public abstract class Interactable {

    protected Interactions[] possibleInteractions = new Interactions[3];
    protected Vector2 position;
    protected Texture texture;
    protected String examine;

    public Interactable(){

    }

    public void onLoad(){

    }

    public Interactions[] getPossibleInteractions(){
        return possibleInteractions;
    }

    public void onInteract(Interactions interaction){

    }

    protected String onExamine(){
        return examine;
    }

    protected boolean interactionPossible(Interactions interaction){
        for(Interactions i: possibleInteractions) {
            if(interaction == i){
                return true;
            }
        }

        return false;
    }
}
