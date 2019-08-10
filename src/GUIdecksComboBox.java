import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Vector;

public class GUIdecksComboBox extends JComboBox
{
    //private Vector<String> deckNames;//////////////
    protected String path = "Decks";//

    GUIdecksComboBox(GridBagConstraints c, Vector<String> deckNames)
    {
        c.gridwidth = 4;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridx = 18;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);

        loadNames(deckNames);

        //show default message and number of decks
        //insertItemAt("Select a deck (" + getItemCount() + ")", 0);
        //setSelectedIndex(0);
    }

    //loads deck names from master list
    protected void loadNames(Vector<String> deckNames)
    {
        //empty list first
        removeAllItems();

        for(int i = 0; i < deckNames.size(); i++)
            addItem(deckNames.elementAt(i));
    }

    //loads deck names from specified location
    /*protected void loadNames()
    {
        //File directory = new File("C:\\Users\\Dylan\\Desktop\\Decks");

        //empty list
        removeAllItems();

        File directory = new File(path);
        File[] fileNames = directory.listFiles();

        for(int i = 0; i < fileNames.length; i++)
            addItem(fileNames[i].getName());
    }*/
}
