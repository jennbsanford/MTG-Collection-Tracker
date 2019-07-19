import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class GUIdeckField extends JTextArea
{

    protected String currentDeck = "";

    GUIdeckField(GridBagConstraints c)
    {
        super(20,25);
        c.gridwidth = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 18;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);
        setEditable(false);
        append("deck here");////////
    }

    public void loadDeck() throws Exception
    {
        //currentDeck should default to first list in deck folder/////
        if(currentDeck == "")/////////////
            return;

        File newFile = new File(currentDeck);
        BufferedReader reader = new BufferedReader(new FileReader(newFile));
        read(reader, newFile);

        //FileReader reader = new FileReader(currentDeck);
        //read(reader, currentDeck);
    }
}
