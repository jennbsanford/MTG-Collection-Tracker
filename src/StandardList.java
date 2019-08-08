import java.util.Vector;
import java.util.Iterator;

public class StandardList extends Decklist {

    private Vector<Card> maindeck;
    private Vector<Card> sideboard;

    public StandardList() {
        super();
        maindeck = new Vector<>();
        sideboard = new Vector<>();
    }

    public boolean addCard(String cardName, int quantity, String mainOrSide) {
        if (cardName == null || quantity < 1)
            return false;
        else {
            Card obj = new Card();
            obj.setCard(cardName, quantity);
            if (mainOrSide.equals("Main"))
                maindeck.add(obj);
            else
                sideboard.add(obj);
            return true;
        }
    }

    public void print() {
        super.print();
        System.out.println("Mainboard:");
        Iterator iter = maindeck.iterator();
        while (iter.hasNext())
        {
            Card mycard = (Card) iter.next();
            mycard.print();
            System.out.println();
        }

        System.out.println("\nSideboard: ");
        iter = sideboard.iterator();
        while (iter.hasNext())
        {
            Card mycard = (Card) iter.next();
            mycard.print();
            System.out.println();
        }
    }
}
