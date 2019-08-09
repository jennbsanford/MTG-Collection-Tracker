public class Decklist {

    private String listName;

    public Decklist() {
        listName = null;
    }

    public boolean changeName(String changeTo) {
        if (changeTo == null)
            return false;
        listName = changeTo;
        return true;
    }

    public String getName() {
        return listName;
    }

    public void print() {
        System.out.println(listName);
    }

    public Decklist copy(Decklist copyFrom) {return null;}

    public Card findCard(String cardName) {
        return null;
    }

    public String getType() {
        return "Decklist";
    }

    public String toString() {
        return listName;
    }

}
