import java.io.*;
import java.util.Iterator;
import java.util.Vector;

public class ListParser {

    public ListParser() {

    }

    public Vector<String> parseMasterList() {

        Vector<String> decks = new Vector<String>();

        try {
            // opens file to be read
            //File myFile = new File("C:\\Users\\Ryan\\IdeaProjects\\A4\\src\\com\\company\\dataFile.txt");
            File myFile = new File("MasterDecklist.txt");
            BufferedReader br = new BufferedReader(new FileReader(myFile));

            String str = new String();
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

        Iterator iter = decks.iterator();
        while (iter.hasNext()) {
            String deck = (String) iter.next();

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
            if (str == "Cube") {
                list = parseCubeList(br);
            } else if (str == "Standard" || str == "Modern" || str == "Legacy" || str == "Pauper") {
                list = parseStandardList(br);
            } else if (str == "EDH") {
                list = parseEDHList(br);
            }
            // get first line of file, which determines which list type it is
            // (EDH, standard, cube, etc)

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
        String mainOrSide = null;
        int quantity = 0;
        try {
            while (((str = br.readLine()) != null)) {
                if (str == "Main") {
                    mainOrSide = "Main";
                }
                else if (str == "Side") {
                    mainOrSide = "Side";
                }
                else {
                    quantity = Character.getNumericValue(str.charAt(0));
                    result.addCard(str.substring(2), quantity, mainOrSide);
                }
            }

            return result;
        } catch (IOException x) {
            System.out.println("Failed to read in parseCubeList");
            return null;
        }
    }

    private EDHList parseEDHList(BufferedReader br) {

        EDHList result = new EDHList();
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

}
