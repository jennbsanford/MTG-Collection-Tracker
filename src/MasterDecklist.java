import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class MasterDecklist {


    private ArrayList<Decklist> masterList;

    public MasterDecklist() {
        masterList = new ArrayList<Decklist>();
    }

    public Vector<String> allDeckNames() {
        Vector<String> result = new Vector<String>();

        Iterator iter = masterList.iterator();
        while (iter.hasNext()) {
            Decklist deck = (Decklist) iter.next();
            result.add(deck.getName());
        }

        return result;
    }

    public int createStandardDecklist(String deckname) {
        if (deckname == null)
            return -1;

        if (findDeck(deckname) != null) {
            return 0;
        }

        StandardList deck = new StandardList();
        deck.changeName(deckname);

        masterList.add(deck);
        return 1;
    }

    public int removeDecklist(String deckname) {
        if (deckname == null)
            return -1;

        Decklist found = findDeck(deckname);
        if (found != null) {
            masterList.remove(found);
            return 1;
        }
        else
            return 0;
    }

    public int copyDecklist(String original, String copy) {
        if (original == null || copy == null) {
            return -1;
        }

        Decklist copyFrom = findDeck(original);

        if (copyFrom == null) {
            return 0;
        }
        else if (copyFrom.getType().equals("StandardList")) {
            StandardList deck = new StandardList();
            deck.copyHere(copyFrom);
            deck.changeName(copy);
            masterList.add(deck);
        }
        else if (copyFrom.getType().equals("EDHList")) {
            EDHList deck = new EDHList();
            deck.copyHere(copyFrom);
            deck.changeName(copy);
            masterList.add(deck);
        }
        else if (copyFrom.getType().equals("CubeList")) {
            CubeList deck = new CubeList();
            deck.copyHere(copyFrom);
            deck.changeName(copy);
            masterList.add(deck);
        }

        return 1;

    }

    public String getString(String deckName) {
        if (deckName == null)
            return null;
        Decklist deck = findDeck(deckName);
        if (deck == null) {
            return null;
        }
        return deck.toString();
    }

    public int addCardToMain(String deckname, String cardname) {
        if (deckname == null || cardname == null)
            return -1;

        StandardList found = (StandardList) findDeck(deckname);
        if (found == null)
            return 0;

        found.addCard(cardname, 1, "Main");
        return 1;
    }

    public int addCardToSide(String deckname, String cardname) {
        if (deckname == null || cardname == null)
            return -1;

        StandardList found = (StandardList) findDeck(deckname);
        if (found == null)
            return 0;

        found.addCard(cardname, 1, "Side");
        return 1;
    }

    public int removeCard(String deckname, String cardname, String MainOrSide) {
        if (deckname == null || cardname == null)
            return -1;

        StandardList found = (StandardList) findDeck(deckname);
        if (found == null)
            return 0;

        found.removeCard(cardname, 1, MainOrSide);
        return 1;
    }

    private Decklist findDeck(String toFind) {

        Iterator iter = masterList.iterator();
        while (iter.hasNext()) {
            Decklist deck = (Decklist) iter.next();
            if (deck.getName().equals(toFind)) {
                return deck;
            }
        }
        return null;
    }

    public boolean addDeck(Decklist toAdd) {
        if (toAdd == null)
            return false;

        else {
            masterList.add(toAdd);
            return true;
        }
    }

    public void display() {
        Iterator iter = masterList.iterator();
        while (iter.hasNext()) {
            Decklist deck = (Decklist) iter.next();
            deck.print();
            System.out.println("\n\n");
        }
    }

}
