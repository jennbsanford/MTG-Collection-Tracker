import java.util.Vector;

public class CollectedCard extends Card {

    private Vector<String> locations;

    public CollectedCard() {
        super();
        locations = new Vector<String>();
    }

    public CollectedCard(String cardname, int quantity) {
        super(cardname, quantity);
        locations = new Vector<String>();
    }

    public boolean setLocation(String setTo) {
        if (setTo == null)
            return false;

        locations.add(setTo);
        return true;
    }

}
