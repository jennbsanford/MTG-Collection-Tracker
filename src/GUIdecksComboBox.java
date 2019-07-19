import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Vector;

public class GUIdecksComboBox extends JComboBox {

    private Vector<String> deckNames;


    //GUIdecksComboBox(GridBagConstraints c, Vector<String> names)
    GUIdecksComboBox(GridBagConstraints c)
    {
        //super();
        c.gridwidth = GridBagConstraints.EAST;
        //c.fill = GridBagConstraints.BOTH;
        c.gridx = 19;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);

        loadNames();
        //add(deckNames[1]);
        //for(int i = 0; i < deckNames.size(); i++)
            //addItem(deckNames.elementAt(i));

        /*deckNames = names;
        deckNames.add("Storm");
        deckNames.add("Dredge");
        deckNames.add("Mid Dazzle");*/
    }

    private void loadNames()
    {
        File directory = new File("C:\\Users\\Dylan\\Desktop\\Decks");
        File[] fileNames = directory.listFiles();

        for(int i = 0; i < fileNames.length; i++)
        {
            //deckNames.add(fileNames[i].getName());
            addItem(fileNames[i].getName());
        }
    }
}
