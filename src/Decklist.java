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

}
