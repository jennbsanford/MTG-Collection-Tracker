public class Card {

    private String name;
    private int quantity;

    public Card() {

        name = null;
        quantity = 0;

    }

    // sets fields to the passed values
    // returns true on success (data changed)
    // return false on failure (data not changed b/c invalid)
    public boolean setCard(String name, int quantity) {
        if (name == null || quantity < 1)
            return false;
        else {
            this.name = name;
            this.quantity = quantity;
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void print() {
        System.out.print(quantity + " " + name);
    }

}
