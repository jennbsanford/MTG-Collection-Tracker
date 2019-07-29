import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Vector;

public class GUIdecksComboBox extends JComboBox {

    //private Vector<String> deckNames;//////////////

    GUIdecksComboBox(GridBagConstraints c)
    {
        c.gridwidth = GridBagConstraints.EAST;
        //c.fill = GridBagConstraints.BOTH;
        c.gridx = 19;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);

        loadNames();

        //show default message and number of decks
        int numItems = getItemCount();
        insertItemAt("Select a deck (" + numItems + ")", 0);
        setSelectedIndex(0);
    }

    //loads deck names from specified location
    private void loadNames()
    {
        //File directory = new File("C:\\Users\\Dylan\\Desktop\\Decks");
        File directory = new File("Decks");
        File[] fileNames = directory.listFiles();

        for(int i = 0; i < fileNames.length; i++)
        {
            addItem(fileNames[i].getName());
        }
    }
}
