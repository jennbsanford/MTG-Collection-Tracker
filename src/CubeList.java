import java.util.Vector;
import java.util.Iterator;

public class CubeList extends Decklist {

    private Vector<Card> cardList;

    public CubeList() {
        super();
        cardList = new Vector<>();
    }

    public boolean addCard(String cardName, int quantity) {
        if (cardName == null || quantity < 1)
            return false;
        else {
            Card obj = new Card();
            obj.setCard(cardName, quantity);
            cardList.add(obj);
            return true;
        }
    }

    public Card findCard(String cardName) {
        Iterator iter = cardList.iterator();
        while (iter.hasNext()) {
            Card mycard = (Card) iter.next();
            if (mycard.getName().equals(cardName)) {
                return mycard;
            }
        }
        return null;
    }


    public void print() {
        super.print();
        Iterator iter = cardList.iterator();
        while (iter.hasNext())
        {
            Card mycard = (Card) iter.next();
            mycard.print();
            System.out.println();
        }
    }

    @SuppressWarnings("unchecked")
    public void copyHere(Decklist copyFrom) {
        changeName(copyFrom.getName());
        cardList = (Vector<Card>) ((CubeList)copyFrom).cardList.clone();
    }

    public String getType() {
        return "CubeList";
    }

    public String toString() {
        String result = new String();
        result += "\nDecklist:\n";
        Iterator iter = cardList.iterator();
        while (iter.hasNext())
        {
            Card mycard = (Card) iter.next();
            result += mycard.getQuantity() + " ";
            result += mycard.getName() + "\n";
        }

        return result;
    }

}
