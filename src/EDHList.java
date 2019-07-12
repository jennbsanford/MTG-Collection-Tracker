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

    public boolean addCommander(String commander) {
        if (commander == null)
            return false;
        this.commander = commander;
        return true;
    }

    public void print() {
        System.out.println("Commander: commander\n");
        System.out.println("Mainboard: \n");
        Iterator iter = cardList.iterator();
        while (iter.hasNext())
        {
            Card mycard = (Card) iter.next();
            mycard.print();
            System.out.println();
        }
    }

}
