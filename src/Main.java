public class Main {

	public static void main(String[] args) {

		JSONReader obj = new JSONReader();
		String[] test = null;
		obj.displayAllCards();

        System.out.println(obj.isCardValid("Dark Ritual"));
        System.out.println(obj.isCardValid("Roflcopter"));

		GUI gui = new GUI();
		gui.main(test);
	}

}
