import java.util.ArrayList;
import java.util.Iterator;

public class MasterDecklist {

    private ArrayList<Decklist> masterList;

    public MasterDecklist() {
        masterList = new ArrayList<Decklist>();
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
