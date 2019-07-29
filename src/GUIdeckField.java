import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class GUIdeckField extends JTextArea implements ActionListener
{
    //private Object defaultMessage = "";
    private Boolean defaultMessage = true;
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
    }

    //activates when a deck is selected from drop down menu
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            //System.out.println(action.getClass());

            //find type of object that performed the action
            String ObjType = e.getSource().getClass().getName();

            //user selected a deck to load
            if(ObjType == "GUIdecksComboBox")
            {
                GUIdecksComboBox names = (GUIdecksComboBox)e.getSource();
                loadDeck((String)names.getSelectedItem());

                //once first deck is selected, remove default message on drop down menu
                if(defaultMessage == true)
                {
                    //defaultMessage = names.getItemAt(0);
                    names.removeItem(names.getItemAt(0));
                    defaultMessage = false;
                }
            }




            //load selected deck
            //String selection = (String)names.getSelectedItem();
            //loadDeck(selection);
        }
        catch(Exception ex)
        {
            System.out.println(ex + "deckField");//////
        }
    }
}
