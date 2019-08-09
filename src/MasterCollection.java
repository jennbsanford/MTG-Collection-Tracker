import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


public class MasterCollection {

    private TreeSet<CollectedCard> collection;

    public MasterCollection() {
        collection = new TreeSet<CollectedCard>(new cardCompare());
    }

    public int addCard(String cardname, int quantity) {
        if (cardname == null || quantity < 1) {
            return -1;
        }
        CollectedCard card = new CollectedCard();
        card.setCard(cardname, quantity);
        boolean rc = collection.add(card);
        if (rc == false) {
            card = collection.floor(card);
            card.setQuantity(quantity);
            return 0;
        }
        return 1;
    }

    public int removeCard(String cardname) {
        if (cardname == null) {
            return -1;
        }
        boolean rc = collection.remove(new CollectedCard(cardname, 1));
        if (rc == false) {
            return 0;
        }
        else
            return 1;
    }

    public String getString() {
        Iterator iter = collection.iterator();
        String result = new String();
        while(iter.hasNext()) {
            CollectedCard current = (CollectedCard) iter.next();
            result += current.getQuantity() + " ";
            result += current.getName() + "\n";
        }
        return result;
    }

    public int numCopies(String cardName) {
        if (cardName == null)
            return -1;
        Iterator iter = collection.iterator();
        while(iter.hasNext()) {
            CollectedCard current = (CollectedCard) iter.next();
            if (current.getName().equals(cardName)) {
                return current.getQuantity();
            }
        }
        return 0;
    }

    public void displayAll() {
        Iterator iter = collection.iterator();
        while(iter.hasNext()) {
            CollectedCard current = (CollectedCard) iter.next();
            current.print();
            System.out.println();
        }
    }

}

class cardCompare implements Comparator<CollectedCard> {

    public int compare(CollectedCard first, CollectedCard second) {
        return first.getName().compareTo(second.getName());
    }

}