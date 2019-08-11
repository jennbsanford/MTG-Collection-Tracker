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
    //protected JButton temp;
    protected String currentDeck = "";
    protected String path = "Decks/";

    GUIdeckField(GridBagConstraints c)
    {
        super(20,25);
        c.gridwidth = 4;
        c.gridheight = 8;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 18;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);

        //temp = new JButton();
        setEditable(false);

        //append("Select a deck from above, or create a new one!");
    }

    //displays selected deck in deck field
    protected void loadDeck(String list) throws Exception
    {
        //display deck list in field
        setText(list);
        setCaretPosition(0);
    }

    //displays selected deck in deck field
    /*public void loadDeck(String filename) throws Exception
    {
        currentDeck = filename;
        //String location = "C:\\Users\\Dylan\\Desktop\\Decks\\" + filename;
        //String location = "Decks//" + filename;
        //String location = "Decks/" + filename;
        String location = path + filename;

        File newFile = new File(location);
        BufferedReader reader = new BufferedReader(new FileReader(newFile));
        this.read(reader, newFile);
        reader.close();
    }*/

    /*//looks through directory for the last modified deck and loads it
    protected void loadRecentDeck() throws Exception
    {
        File directory = new File(path);
        File[] fileNames = directory.listFiles();

        File mostRecent = null;
        long mostRecentTime = 0;
        for(int i = 0; i < fileNames.length; i++)
        {
            if (fileNames[i].lastModified() > mostRecentTime) {
                mostRecent = fileNames[i];
                mostRecentTime = fileNames[i].lastModified();
            }
        }

        //load most recent deck
        loadDeck(mostRecent.getName());
    }*/

    //activates when a deck is selected from drop down menu
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            /*//System.out.println(action.getClass());

            //find type of object that performed the action
            String ObjType = e.getSource().getClass().getName();

            //user selected a deck to load
            if(ObjType == "GUIdecksComboBox")
            {
                GUIdecksComboBox names = (GUIdecksComboBox)e.getSource();

                //remove default message
                //String defaultValue = (String)names.getSelectedItem();
                //if(defaultValue.contains("Select a deck (") || defaultMessage)
                /*if(defaultMessage)
                {
                    names.removeItem(names.getItemAt(0));
                    defaultMessage = false;
                }

                loadDeck((String)names.getSelectedItem());
            }

            //user pressed other button
            else if(ObjType == "javax.swing.JButton")
            {
                this.setText("otherButtonDeckField");
            }*/
        }
        catch(Exception ex)
        {
            //System.out.println(ex + " deckField");//////
        }
    }
}
