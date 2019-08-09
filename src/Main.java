import java.util.Vector;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		// parse all data decklist and collection data from .txt files
		MasterDecklist masterDecklist = new MasterDecklist();
		MasterCollection masterCollection = new MasterCollection();
		ListParser parse = new ListParser();
		Vector list = parse.parseMasterList();
		masterDecklist = parse.parseAllDecklists(list);
		masterCollection = parse.parseMasterCollection();


		masterDecklist.createStandardDecklist("Boros Burn");
		Vector<String> a = masterDecklist.allDeckNames();
		Iterator iter = a.iterator();
		while (iter.hasNext()) {
			String str = (String) iter.next();
			System.out.println(str);
		}

		// INSERT YOUR CODE HERE DYLAN!

		try
		{
			GUIframe frame = new GUIframe(masterDecklist);
		}
		catch(Exception e)
		{
			System.out.println(e + " Main");
		}

	}
}
