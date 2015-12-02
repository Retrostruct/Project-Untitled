package com.retrostruct.epsilon;

import java.io.File;

/**
 * Created by kasper.esbjornsson on 12/2/2015.
 */
public class DialogueReader {

    File file;

    public DialogueReader(String dialogueFile){
        file = new File("Assets/" + dialogueFile + ".xml");


    }


}
