import java.util.Vector;
import java.util.Iterator;

public class EDHList extends Decklist {

    private Vector<Card> cardList;
    private String commander;

    public EDHList() {
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

    public boolean addCommander(String commander) {
        if (commander == null)
            return false;
        this.commander = commander;
        return true;
    }


    public void print() {
        super.print();
        System.out.println("Commander: " + commander);
        System.out.println("Decklist: ");
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
        this.commander = ((EDHList)copyFrom).commander;
        cardList = (Vector<Card>) ((EDHList)copyFrom).cardList.clone();
    }

    public String getType() {
        return "EDHList";
    }

    public String toString() {
        String result = new String();
        result += "Commander: " + commander;
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
