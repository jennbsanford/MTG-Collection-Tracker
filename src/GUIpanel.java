import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

public class GUIpanel extends JPanel implements ActionListener
{
    //master list of decks
    private MasterDecklist masterList;

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
    private GUIfindCardsFrame findCardsWindow;
    protected JButton pack;

    protected String path = "Decks/";

    //protected JButton temp;//
    //protected JButton temp2;//

    GUIpanel(MasterDecklist lists) throws Exception
    {
        //setup panel layout
        super(new GridBagLayout());

        //gain access to the masterList
        masterList = lists;

        //ready constraints
        GridBagConstraints c = new GridBagConstraints();

        //initialize components and add to panel
        //user input field
        input = new GUIuserInputField(c);
        add(input, c);

        //collection field
        collection = new GUIcollectionField(c);
        JScrollPane colScroll = new JScrollPane(collection);
        colScroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        add(colScroll, c);
        //add(new JScrollPane(collection), c);

        //deck list field
        deck = new GUIdeckField(c);
        deck.loadDeck(masterList.getString(masterList.allDeckNames().elementAt(0)));
        JScrollPane deckScroll = new JScrollPane(deck);
        deckScroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        add(deckScroll, c);
        //add(new JScrollPane(deck), c);

        //deck list drop down menu
        deckNames = new GUIdecksComboBox(c, masterList.allDeckNames());
        //deckNames.addActionListener(deck);
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
        //findCards.addActionListener(findCardsWindow);
        add(findCards, c);

        //window that shows all locations for entered card
        findCardsWindow = new GUIfindCardsFrame();

        //button that tells frame to pack
        pack = new JButton();

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
        //findCards.addActionListener(findCardsWindow);
        //newDeckInput.updater.addActionListener(deckNames);
        //newDeckInput.updater.addActionListener(this);
        //newDeckInput.copyDeck.addActionListener(this);

        //when user selects a deck it gets loaded
        deckNames.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    //load currently selected deck
                    deck.loadDeck(masterList.getString((String)deckNames.getSelectedItem()));
                }
                catch(Exception ex)
                {
                    System.out.println(e + "comboBoxSelectionPanel");
                }
            }
        });

        //creates a new deck when user presses save button
        newDeckInput.saveName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String newName = newDeckInput.inputField.getText();
                    JFrame warning = new JFrame();
                    if(newDeckInput.inputField.getText().isEmpty())
                        JOptionPane.showMessageDialog(warning, "Name cannot be blank.");

                    else if(!newDeckInput.makeCopy)
                    {
                        //attempt to create new deck with input name
                        if (masterList.createStandardDecklist(newName) < 0)
                            JOptionPane.showMessageDialog(warning, "File couldn't be created.");
                        else
                        {
                            //remove input frame and update deck field
                            newDeckInput.setVisible(false);
                            deckNames.loadNames(masterList.allDeckNames());
                            deckNames.setSelectedItem(newName);
                            pack.doClick();
                        }
                    }
                    else
                    {
                        //attempt to create a copy with the new name
                        if (masterList.copyDecklist((String)deckNames.getSelectedItem(), newName) < 0)
                            JOptionPane.showMessageDialog(warning, "File couldn't be created.");
                        else
                        {
                            //remove input frame and update deck field
                            newDeckInput.setVisible(false);
                            deckNames.loadNames(masterList.allDeckNames());
                            deckNames.setSelectedItem(newName);
                            pack.doClick();
                            //
                            //masterList.createStandardDecklist("temp");
                            //deck.loadDeck("temp");
                            //masterList.removeDecklist("temp");
                            //deckNames.setSelectedItem(newName);
                        }
                    }
                } catch(Exception ex)
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
                    String deckToDelete = (String)deckNames.getSelectedItem();
                    masterList.removeDecklist(deckToDelete);
                    deckNames.loadNames(masterList.allDeckNames());
                    /*File deleteFile = new File(path + deckNames.getSelectedItem());
                    if(!deleteFile.delete())
                        System.out.println("deck couldnt be deleted");
                    updateRecentDeck();*/
                }
                catch(Exception ex)
                {
                    System.out.println(e + " PanelDeleteDeck");
                }
            }
        });

        //invokes deck field update routine
        /*refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    //System.out.println("findCardActionListener");
                    //findCardsWindow.findCard("DoomBlade");
                }
                catch(Exception ex)
                {
                    System.out.println(e + " PanelRefreshButton");
                }
            }
        });*/

        /*//repacks the screen
        newDeckInput.saveName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String newName = (String)deckNames.getSelectedItem();
                    System.out.println(newName);
                    masterList.createStandardDecklist("temp");
                    masterList.removeDecklist("temp");
                    deckNames.setSelectedItem(newName);
                    //deck.loadDeck(newName);
                    //pack.doClick();
                }
                catch(Exception ex)
                {
                    System.out.println(e + "comboBoxSelectionPanel");
                }
            }
        });*/

        //invokes deck field update routine
        /*newDeckInput.updater.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {

                }
                catch(Exception ex)
                {
                    System.out.println(e + "PanelCopyDeck");
                }
            }
        });*/

        //invokes deck field update routine
        findCards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    //System.out.println("findCardActionListener");
                    findCardsWindow.findCard("DoomBlade");
                }
                catch(Exception ex)
                {
                    System.out.println(e + "findCardsButton");
                }
            }
        });

        //invokes deck field update routine
        /*refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    //System.out.println("findCardActionListener");
                    //findCardsWindow.findCard("DoomBlade");
                }
                catch(Exception ex)
                {
                    System.out.println(e + " PanelRefreshButton");
                }
            }
        });*/

        //action listener for when a deck needs to be copied
        /*newDeckInput.copyDeck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
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
        });*/

        /*//deletes the current deck
        deleteDeck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String deckToDelete = (String)deckNames.getSelectedItem();
                    deckNames.loadNames(masterList.allDeckNames());
                    /*File deleteFile = new File(path + deckNames.getSelectedItem());
                    if(!deleteFile.delete())
                        System.out.println("deck couldnt be deleted");
                    updateRecentDeck();
                }
                catch(Exception ex)
                {
                    System.out.println(e + " PanelDeleteDeck");
                }
            }
        });*/

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
            //deckNames.loadNames();
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
            System.out.println(ex + " panelGeneralListener");//////
        }
    }

    public static void main(String[] args)
    {

        System.out.print("Entered panel class main.");//////////
    }
}
