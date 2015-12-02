package com.retrostruct.epsilon;

import java.io.File;

import javax.sql.rowset.spi.XmlReader;

import jdk.internal.org.xml.sax.XMLReader;

/**
 * Created by kasper.esbjornsson on 12/2/2015.
 */
public class DialogueReader {

    File file;

    public DialogueReader(String dialogueFile){
        file = new File("Assets/" + dialogueFile + ".xml");

        
    }


}
