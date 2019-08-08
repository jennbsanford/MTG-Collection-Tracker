import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		MasterDecklist test = new MasterDecklist();
		ListParser parse = new ListParser();
		Vector list = parse.parseMasterList();
		test = parse.parseAllDecklists(list);
		test.display();
	}

}
