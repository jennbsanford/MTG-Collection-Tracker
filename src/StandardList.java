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

        Card obj = new Card();
        obj.setCard(cardName, quantity);
        Card toFind;
        if (mainOrSide.equals("Main"))
            toFind = findCardMain(cardName);
        else
            toFind = findCardSide(cardName);

        if (toFind == null)
        {
            if (mainOrSide.equals("Main"))
                maindeck.add(obj);
            else
                sideboard.add(obj);
        }
        else {
            toFind.incrementQuantity();
        }

        return true;
    }

    public boolean removeCard(String cardName, int quantity, String mainOrSide) {
        if (cardName == null || quantity < 1)
            return false;

        Card obj;

        if (mainOrSide.equals("Main"))
            obj = findCardMain(cardName);
        else
            obj = findCardSide(cardName);

        if (obj == null) {
            return false;
        }
        if (obj.getQuantity() > 1) {
            obj.decrementQuantity();
            return true;
        }
        else if (mainOrSide.equals("Main"))
            maindeck.remove(obj);
        else
            sideboard.remove(obj);
        return true;

    }

    public Card findCardMain(String cardName) {

        Iterator iter = maindeck.iterator();
        while (iter.hasNext()) {
            Card mycard = (Card) iter.next();
            if (mycard.getName().equals(cardName)) {
                return mycard;
            }
        }
        return null;
    }

    public Card findCardSide(String cardName) {

        Iterator iter2 = sideboard.iterator();
        while (iter2.hasNext()) {
            Card mycard = (Card) iter2.next();
            if (mycard.getName().equals(cardName)) {
                return mycard;
            }
        }
        return null;
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

        System.out.println("\nSideboard:");
        iter = sideboard.iterator();
        while (iter.hasNext())
        {
            Card mycard = (Card) iter.next();
            mycard.print();
            System.out.println();
        }
    }

    public void copyHere(Decklist copyFrom) {
        changeName(copyFrom.getName());
        maindeck = (Vector<Card>) ((StandardList)copyFrom).maindeck.clone();
        sideboard = (Vector<Card>) ((StandardList)copyFrom).maindeck.clone();
    }

    public String getType() {
        return "StandardList";
    }

    public String toString() {
        String result = new String();
        result += "\nMainboard:\n";
        Iterator iter = maindeck.iterator();
        while (iter.hasNext())
        {
            Card mycard = (Card) iter.next();
            result += mycard.getQuantity() + " ";
            result += mycard.getName() + "\n";
        }

        result += "\nSideboard:\n";
        iter = sideboard.iterator();
        while (iter.hasNext())
        {
            Card mycard = (Card) iter.next();
            result += mycard.getQuantity() + " ";
            result += mycard.getName() + "\n";
        }

        return result;
    }

}
