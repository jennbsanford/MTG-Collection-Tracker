import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GUIpanel extends JPanel implements ActionListener
{
    //text fields
    protected JTextField input;
    protected GUIcollectionField collection;
    protected GUIdeckField deck;

    //menus
    protected GUIdecksComboBox deckNames;

    //buttons
    protected GUIaddToCollectionButton addToCollection;
    protected GUIremoveFromCollectionButton removeFromCollection;
    protected GUIaddToDeckButton addToDeck;
    protected GUIremoveFromDeckButton removeFromDeck;
    protected GUIcreateDeckButton createDeck;
    protected GUIcopyDeckButton copyDeck;
    protected GUIdeleteDeckButton deleteDeck;
    protected GUIsaveAllButton saveAll;
    protected GUIfindCardsButton findCards;



    //windows
    private GUInewDeckFrame newDeckInput;

    protected String path = "Decks/";

    //protected JButton temp;//
    //protected JButton temp2;//

    GUIpanel() throws Exception
    {
        //setup panel layout
        super(new GridBagLayout());

        //ready constraints
        GridBagConstraints c = new GridBagConstraints();

        //initialize components and add to panel
        //user input field
        input = new GUIuserInputField(c);
        add(input, c);

        //collection field
        collection = new GUIcollectionField(c);
        add(new JScrollPane(collection), c);

        //deck list field
        deck = new GUIdeckField(c);
        add(new JScrollPane(deck), c);

        //deck list drop down menu
        deckNames = new GUIdecksComboBox(c);
        deckNames.addActionListener(deck);
        //newDeckInput.updater.addActionListener(deckNames);
        add(deckNames, c);

        //create new deck button
        createDeck = new GUIcreateDeckButton(c);
        //createDeck.addActionListener(createDeck);
        add(createDeck, c);


        //add a card to the collection
        addToCollection = new GUIaddToCollectionButton(c);
        //add(addToCollection, c);

        //remove a card from the collection
        removeFromCollection = new GUIremoveFromCollectionButton(c);
        //add(removeFromCollection, c);

        //add a card from the collection to the current deck
        addToDeck = new GUIaddToDeckButton(c);
        //add(addToDeck, c);

        //remove a card from current deck and put it back into the collection
        removeFromDeck = new GUIremoveFromDeckButton(c);
        //add(removeFromDeck, c);

        //copy the current deck with a new name
        copyDeck = new GUIcopyDeckButton(c);
        add(copyDeck, c);

        //delete the current deck
        deleteDeck = new GUIdeleteDeckButton(c);
        add(deleteDeck, c);

        //save all changes to decks and the collection
        saveAll = new GUIsaveAllButton(c);
        //add(saveAll, c);

        //find all copies of the card name in the input field
        findCards = new GUIfindCardsButton(c);
        add(findCards, c);

        //window for entering a name for a new deck
        newDeckInput = new GUInewDeckFrame();
        createDeck.addActionListener(newDeckInput);
        copyDeck.addActionListener(newDeckInput);
        //deleteDeck.addActionListener(deleteDeck);
        //newDeckInput.updater.addActionListener(this);
        //newDeckInput.copyDeck.addActionListener(this);
        //newDeckInput.updater.addActionListener(deckNames);



        //user input field
        /*input = new JTextField(40);
        c.gridwidth = 20;
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);
        add(input, c);*/

        //action listeners
        //newDeckInput.updater.addActionListener(deckNames);
        //newDeckInput.updater.addActionListener(this);
        //newDeckInput.copyDeck.addActionListener(this);

        //invokes deck field update routine
        newDeckInput.updater.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    updateRecentDeck();
                }
                catch(Exception ex)
                {
                    System.out.println(e + "PanelCopyDeck");
                }
            }
        });

        /*//invokes deck field update routine
        deck.temp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    updateRecentDeck();
                }
                catch(Exception ex)
                {
                    System.out.println(e + "deckTempButton");
                }
            }
        });*/

        //action listener for when a deck needs to be copied
        newDeckInput.copyDeck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    //String src = path + deckNames.getSelectedItem();
                    //String des = path + newDeckInput.copyName;
                    //System.out.println(src + "  " + des);

                    FileInputStream is = new FileInputStream(path + deckNames.getSelectedItem());
                    FileOutputStream os = new FileOutputStream(path + newDeckInput.copyName);

                    //copy deck file from src to des
                    int curr;
                    while((curr = is.read()) != -1)
                        os.write(curr);

                    is.close();
                    os.close();
                }
                catch(Exception ex)
                {
                    System.out.println(e + "PanelCopyDeck");
                }
            }
        });

        //deletes the current deck
        deleteDeck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    File deleteFile = new File(path + deckNames.getSelectedItem());
                    if(!deleteFile.delete())
                        System.out.println("deck couldnt be deleted");
                    updateRecentDeck();
                }
                catch(Exception ex)
                {
                    System.out.println(e + "PanelCopyDeck");
                }
            }
        });

        /*temp = new JButton();
        c.gridwidth = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);
        temp.addActionListener(this);
        add(temp, c);

        temp2 = new JButton();
        c.gridwidth = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        c.gridx = 7;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);
        temp2.addActionListener(this);
        add(temp2, c);*/
    }

    //----------------------------------------------------------------//

    private void updateRecentDeck()
    {
        try
        {
            File directory = new File(path);
            File[] fileNames = directory.listFiles();

            File mostRecent = null;
            long mostRecentTime = 0;
            for (int i = 0; i < fileNames.length; i++) {
                if (fileNames[i].lastModified() > mostRecentTime) {
                    mostRecent = fileNames[i];
                    mostRecentTime = fileNames[i].lastModified();
                }
            }

            //update components
            deck.loadDeck(mostRecent.getName());
            deckNames.loadNames();
            deckNames.setSelectedItem(mostRecent.getName());
        }
        catch(Exception e)
        {
            System.out.println(e + "PanelUpdaterRoutine");
        }
    }

    //createDeck.addActionListener(new ActionListener() {
     //   public void actionPerformed(ActionEvent e) {
      //  }
    //});

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            //System.out.println(e.getClass());

            //find type of object that performed the action
            String ObjType = e.getSource().getClass().getName();

            //set deck field and drop down box to most recently made deck
            /*if(ObjType == "javax.swing.JButton")
            {
                //
                System.out.println("entered general Panel actionPerformed routine");
                //updateRecentDeck();
            }*/
        }
        catch(Exception ex)
        {
            System.out.println(ex + "deckField");//////
        }
    }

    public static void main(String[] args)
    {

        System.out.print("Entered panel class main.");//////////
    }
}
