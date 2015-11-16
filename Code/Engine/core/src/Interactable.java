import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

/**
 * Created by Kasper on 11/4/2015.
 */
public abstract class Interactable {

    protected Interactions[] possibleInteractions = new Interactions[3];
    protected Vector2 position;
    protected Texture texture;
    protected String examine;

    public Interactable(){

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

    public void onInteract(Interactions interaction){
        Gdx.app.debug("Interactable used as child: ", "onInteract function is not defined for current object (" + this.toString() + ")");
    }

    /***onExamine should be run when player is examining the Interactable**/
    protected String onExamine(){
        return examine;
    }
}
