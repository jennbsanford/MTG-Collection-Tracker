import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Vector;
import java.lang.Object;

public class ListParser {

    public ListParser() {

    }

    public Vector<String> parseMasterList() {

        Vector<String> decks = new Vector<String>();

        try {
            // opens file to be read
            //File myFile = new File("C:\\Users\\Ryan\\IdeaProjects\\A4\\src\\com\\company\\dataFile.txt");
            //Path filePath = Paths.get("file.txt");
            File myFile = new File("MasterDecklist.txt");
            BufferedReader br = new BufferedReader(new FileReader(myFile));

            String str;
            while (((str = br.readLine()) != null)) {
                decks.add(str);
            }
        } catch (IOException x) {
            System.out.println("Failed to open MasterDecklist.txt");
        }

        return decks;

    }

    public MasterDecklist parseAllDecklists(Vector<String> decks) {
        if (decks == null) {
            System.out.print("parseAllDecklists() received NULL argument!");
            return null;
        }

        MasterDecklist data = new MasterDecklist();
        Decklist current;

        Iterator iter = decks.iterator();
        while (iter.hasNext()) {
            String deck = (String) iter.next();
            current = parseDecklist(deck);
            current.changeName(deck);
            if (current == null)
                System.out.println("Failed to parse decklist: " + deck);
            data.addDeck(current);
        }

        return data;
    }

    private Decklist parseDecklist(String listName) {
        try {

            // opens file to be read
            File myFile = new File(listName + ".txt");
            BufferedReader br = new BufferedReader(new FileReader(myFile));
            Decklist list = null;

            String str = new String();
            str = br.readLine();
            if (str.equals("Cube")) {
                list = parseCubeList(br);
            } else if (str.equals("Standard") || str.equals("Modern") || str.equals("Legacy") || str.equals("Pauper")) {
                list = parseStandardList(br);
            } else if (str.equals("EDH") || str.equals("Commander")) {
                list = parseEDHList(br);
            }

            return list;
        } catch (IOException x) {
            System.out.println("Failed to open " + listName + ".txt");
            return null;
        }
    }

    private CubeList parseCubeList(BufferedReader br) {

        CubeList result = new CubeList();
        String str;
        try {
            while (((str = br.readLine()) != null)) {
                result.addCard(str, 1);
            }

            return result;
        } catch (IOException x) {
            System.out.println("Failed to read in parseCubeList");
            return null;
        }
    }

    private StandardList parseStandardList(BufferedReader br) {

        StandardList result = new StandardList();
        String str;
        String mainOrSide = "Main";
        int quantity = 0;
        try {
            while (((str = br.readLine()) != null)) {
                if (str.equals("Main")) {
                    mainOrSide = "Main";
                }
                else if (str.equals("Side")) {
                    mainOrSide = "Side";
                }
                else {
                    quantity = Character.getNumericValue(str.charAt(0));
                    result.addCard(str.substring(2), quantity, mainOrSide);
                }
            }

            return result;
        } catch (IOException x) {
            System.out.println("Failed to read in parseStandardList");
            return null;
        }
    }

    private EDHList parseEDHList(BufferedReader br) {

        EDHList result = new EDHList();
        String str;
        try {
            str = br.readLine();
            result.addCommander(str);
            while (((str = br.readLine()) != null)) {
                result.addCard(str, 1);
            }

            return result;
        } catch (IOException x) {
            System.out.println("Failed to read in parseEDHList");
            return null;
        }
    }

}
