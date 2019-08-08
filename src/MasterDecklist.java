import java.util.ArrayList;

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

}
