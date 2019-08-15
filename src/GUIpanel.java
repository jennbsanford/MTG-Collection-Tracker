import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

public class GUIpanel extends JPanel implements ActionListener
{
    //master list of decks
    private MasterDecklist masterList;
    private MasterCollection collectionList;

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
    protected GUIaddToDeckSideButton addToSide;
    protected GUIremoveFromDeckButton removeFromDeck;
    protected GUIremoveFromDeckSideButton removeFromSide;
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

    GUIpanel(MasterDecklist deckLists, MasterCollection collectionLists) throws Exception
    {
        //setup panel layout
        super(new GridBagLayout());

        //gain access to the masterLists
        masterList = deckLists;
        collectionList = collectionLists;


        //ready constraints
        GridBagConstraints c = new GridBagConstraints();

        //initialize components and add to panel
        //user input field
        input = new GUIuserInputField(c);
        add(input, c);

        //collection field
        collection = new GUIcollectionField(c);
        collection.setText(collectionList.getString());
        JScrollPane colScroll = new JScrollPane(collection);
        colScroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        add(colScroll, c);

        //deck list field
        deck = new GUIdeckField(c);
        if(masterList.allDeckNames().size() == 0)
            masterList.createStandardDecklist("New Deck");
        deck.loadDeck(masterList.getString(masterList.allDeckNames().elementAt(0)));
        JScrollPane deckScroll = new JScrollPane(deck);
        deckScroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        add(deckScroll, c);

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
        add(addToCollection, c);

        //remove a card from the collection
        removeFromCollection = new GUIremoveFromCollectionButton(c);
        add(removeFromCollection, c);

        //add a card to the mainboard of the current deck
        addToDeck = new GUIaddToDeckButton(c);
        add(addToDeck, c);

        //add a card to the sideboard of the current deck
        addToSide = new GUIaddToDeckSideButton(c);
        add(addToSide, c);

        //remove a card from current mainboard
        removeFromDeck = new GUIremoveFromDeckButton(c);
        add(removeFromDeck, c);

        //remove a card from current sideboard
        removeFromSide = new GUIremoveFromDeckSideButton(c);
        add(removeFromSide, c);

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

        //action listeners
        //findCards.addActionListener(findCardsWindow);
        //newDeckInput.updater.addActionListener(deckNames);
        //newDeckInput.updater.addActionListener(this);
        //newDeckInput.copyDeck.addActionListener(this);

        collection.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    //finds line clicked by the user
                    super.mouseClicked(e);
                    int lineNum = collection.getLineOfOffset(collection.getCaretPosition());
                    int lineStart = collection.getLineStartOffset(lineNum);
                    int lineEnd = collection.getLineEndOffset(lineNum);
                    String cardName = collection.getDocument().getText(lineStart, (lineEnd - lineStart));

                    if(!cardName.isEmpty())
                        input.setText(cardName.substring(2).trim());
                } catch(Exception ex)
                {
                    System.out.println(ex + " collectionMouseListener");
                }
            }
        });

        deck.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    //finds line clicked by the user
                    super.mouseClicked(e);
                    int lineNum = deck.getLineOfOffset(deck.getCaretPosition());
                    int lineStart = deck.getLineStartOffset(lineNum);
                    int lineEnd = deck.getLineEndOffset(lineNum);
                    String cardName = deck.getDocument().getText(lineStart, (lineEnd - lineStart));

                    if(!cardName.isEmpty())
                        input.setText(cardName.substring(2).trim());
                } catch(Exception ex)
                {
                    System.out.println(ex + " deckMouseListener");
                }
            }
        });

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
                        }
                    }
                } catch(Exception ex)
                {
                    System.out.println(e + " PanelCopyDeck");
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
                    JFrame warning = new JFrame();

                    if(masterList.removeDecklist(deckToDelete) < 0)
                        JOptionPane.showMessageDialog(warning, "Deck couldn't be deleted.");
                    else
                        deckNames.loadNames(masterList.allDeckNames());
                }
                catch(Exception ex)
                {
                    System.out.println(e + " PanelDeleteDeck");
                }
            }
        });

        //adds the current text in the user input field to the collection
        addToCollection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    JFrame warning = new JFrame();
                    if(!input.getText().isEmpty())
                    {
                        int errorCode = collectionList.addCard(input.getText(), 1);
                        if (errorCode < 0)
                            JOptionPane.showMessageDialog(warning, "Card couldn't be added");
                        else
                            collection.setText(collectionList.getString());
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(e + "PanelCopyDeck");
                }
            }
        });

        //adds the current text in the user input field to the collection
        removeFromCollection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    JFrame warning = new JFrame();
                    if(!input.getText().isEmpty())
                    {
                        int errorCode = collectionList.removeCard(input.getText());
                        if (errorCode < 0)
                            JOptionPane.showMessageDialog(warning, "Card couldn't be removed");
                        else
                            collection.setText(collectionList.getString());
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(e + "PanelCopyDeck");
                }
            }
        });

        //adds the current text in the user input field to the mainboard
        addToDeck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    JFrame warning = new JFrame();
                    String deck = (String)deckNames.getSelectedItem();
                    if(!input.getText().isEmpty())
                    {
                        int errorCode = masterList.addCardToMain(deck, input.getText());
                        if (errorCode < 0)
                            JOptionPane.showMessageDialog(warning, "Card couldn't be added");
                        else if (errorCode == 0)
                            JOptionPane.showMessageDialog(warning, "Deck couldn't be found");
                        else
                            deckNames.setSelectedItem(deck);
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(e + " PanelRefreshButton");
                }
            }
        });

        //adds the current text in the user input field to the sideboard
        addToSide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String deck = (String)deckNames.getSelectedItem();
                    if(!input.getText().isEmpty()) {
                        int errorCode = masterList.addCardToSide(deck, input.getText());
                        if (errorCode < 0)
                            JOptionPane.showMessageDialog(new JFrame(), "Card couldn't be added");
                        else if (errorCode == 0)
                            JOptionPane.showMessageDialog(new JFrame(), "Deck couldn't be found");
                        else
                            deckNames.setSelectedItem(deck);
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(e + " PanelRefreshButton");
                }
            }
        });

        //removes the current text in the user input field from the mainboard
        removeFromDeck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String deck = (String)deckNames.getSelectedItem();
                    if(!input.getText().isEmpty()) {
                        int errorCode = masterList.removeCard(deck, input.getText(), "Main");
                        if (errorCode < 0)
                            JOptionPane.showMessageDialog(new JFrame(), "Card couldn't be added");
                        else if (errorCode == 0)
                            JOptionPane.showMessageDialog(new JFrame(), "Deck couldn't be found");
                        else
                            deckNames.setSelectedItem(deck);
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(e + " PanelRefreshButton");
                }
            }
        });

        //removes the current text in the user input field from the sideboard
        removeFromSide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String deck = (String)deckNames.getSelectedItem();
                    if(!input.getText().isEmpty())
                    {
                        int errorCode = masterList.removeCard(deck, input.getText(), "Side");
                        if (errorCode < 0)
                            JOptionPane.showMessageDialog(new JFrame(), "Card couldn't be added");
                        else if (errorCode == 0)
                            JOptionPane.showMessageDialog(new JFrame(), "Deck couldn't be found");
                        else
                            deckNames.setSelectedItem(deck);
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(e + " PanelRefreshButton");
                }
            }
        });

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
                    if(!input.getText().isEmpty())
                    {
                        String card = input.getText();
                        int numOwned = collectionList.numCopies(card);
                        findCardsWindow.findCard(card, numOwned, masterList.findCardEverywhere(card));
                        pack.doClick();
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(e + "findCardsButton");
                }
            }
        });
    }

    //----------------------------------------------------------------//

    /*private void updateRecentDeck()
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
    }*/

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
}
