import java.io.*;
import java.util.Iterator;
import java.util.Vector;

public class ListParser {

    public ListParser() { }

    public Vector<String> parseMasterList() {

        Vector<String> decks = new Vector<String>();

        try {

            // opens file to be read
            File myFile = new File("Decks/MasterDecklist.txt");
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

    public MasterCollection parseMasterCollection() {

        MasterCollection data = new MasterCollection();

        try {
            File myFile = new File("Decks/Collection.txt");
            BufferedReader br = new BufferedReader(new FileReader(myFile));

            String str;
            while (((str = br.readLine()) != null)) {
                String quantity = new String();
                int ctr = 0;
                while (str.charAt(ctr) != ' ')
                {
                    quantity += str.charAt(ctr);
                    ctr++;
                }
                int num = Integer.parseInt(quantity);
                data.addCard(str.substring(ctr+1), num);
            }
        } catch (IOException x) {
            System.out.println("Failed to open Collection.txt");
        }

        return data;
    }

    private Decklist parseDecklist(String listName) {
        try {

            // opens file to be read
            File myFile = new File("Decks/" + listName + ".txt");
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
        try {
            while (((str = br.readLine()) != null)) {
                if (str.equals("Main")) {
                    mainOrSide = "Main";
                }
                else if (str.equals("Side")) {
                    mainOrSide = "Side";
                }
                else {
                    String quantity = new String();
                    int ctr = 0;
                    while (str.charAt(ctr) != ' ')
                    {
                        quantity += str.charAt(ctr);
                        ctr++;
                    }
                    int num = Integer.parseInt(quantity);

                    result.addCard(str.substring(ctr+1), num, mainOrSide);
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
