import java.util.Vector;

public class CollectedCard extends Card {

    private Vector<String> locations;

    public CollectedCard() {
        super();
        locations = null;
    }

    public boolean setLocation(String setTo) {
        if (setTo == null)
            return false;

        locations.add(setTo);
        return true;
    }

}
