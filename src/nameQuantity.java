public class nameQuantity {

    public int quantity;
    public String deckName;

    public nameQuantity() {
        deckName = new String();
        quantity = 0;
    }

    public void print() {
        System.out.println(deckName + " " + quantity);
    }

}
