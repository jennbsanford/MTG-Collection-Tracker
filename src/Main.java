import java.util.Vector;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		// parse all data decklist and collection data from .txt files
		MasterDecklist masterDecklist = new MasterDecklist();
		ListParser parse = new ListParser();
		Vector list = parse.parseMasterList();
		masterDecklist = parse.parseAllDecklists(list);
		//masterCollectionList = parse.parseCollection();
		//masterDecklist.removeDecklist("Boros Burn");

		masterDecklist.display();
		masterDecklist.copyDecklist("Azami, Lady of Scrolls", "Big Dummy Dumb Dumb");
		masterDecklist.display();

		// INSERT YOUR CODE HERE DYLAN!
	}
}
