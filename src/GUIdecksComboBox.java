import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GUIdecksComboBox extends JComboBox
{
    //private Vector<String> deckNames;//////////////
    protected String path = "Decks";//

    GUIdecksComboBox(GridBagConstraints c)
    {
        c.gridwidth = GridBagConstraints.EAST;
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridx = 18;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);

        loadNames();

        //show default message and number of decks
        insertItemAt("Select a deck (" + getItemCount() + ")", 0);
        setSelectedIndex(0);
    }

    //loads deck names from specified location
    protected void loadNames()
    {
        //File directory = new File("C:\\Users\\Dylan\\Desktop\\Decks");

        //empty list
        removeAllItems();

        File directory = new File(path);
        File[] fileNames = directory.listFiles();

        for(int i = 0; i < fileNames.length; i++)
            addItem(fileNames[i].getName());
    }
}
