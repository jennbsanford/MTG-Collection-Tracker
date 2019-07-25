import javax.swing.*;
import javax.tools.JavaCompiler;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class GUIdeckField extends JTextArea implements ActionListener
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

        append("Select a deck from above, or create a new one!");
    }

    //displays selected deck in deck field
    public void loadDeck(String filename) throws Exception
    {
        currentDeck = filename;
        //String location = "C:\\Users\\Dylan\\Desktop\\Decks\\" + filename;
        String location = "Decks/" + filename;

        File newFile = new File(location);
        BufferedReader reader = new BufferedReader(new FileReader(newFile));
        read(reader, newFile);

        //FileReader reader = new FileReader(currentDeck);
        //read(reader, currentDeck);
    }

    //activates when a deck is selected from drop down menu
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            JComboBox names = (JComboBox) e.getSource();
            String selection = (String) names.getSelectedItem();

            this.loadDeck(selection);
        }
        catch(Exception ex)
        {
            System.out.println(ex + "deckField");
        }

        //JComponent source = (JComponent)e.getSource();
        //System.out.println(selection);
        //e.paramString();
    }
}
