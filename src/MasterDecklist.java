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

        StandardList deck = new StandardList();
        deck.changeName(deckname);
        masterList.add(deck);
        return 1;
    }

    public int removeDecklist(String deckname) {
        if (deckname == null)
            return -1;

        boolean found = false;
        Iterator iter = masterList.iterator();
        while (iter.hasNext() && !found) {
            Decklist deck = (Decklist) iter.next();
            if (deck.getName().equals(deckname)) {
                found = true;
                masterList.remove(deck);
            }
        }
        if (found) {
            return 1;
        }
        else
            return 0;
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
