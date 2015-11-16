/**
 * Created by kasper.esbjornsson on 11/4/2015.
 */
public class NPC extends Interactable{

    String name;
    //Dialogue tree? Dialogue file? How will we handle dialogues?

    public NPC() {

    }

    public void create(String name, String examine){
        this.name = name;
        this.examine = examine;
    }
}
