import java.io.File;

public class Installer {

    public String path;

    //checks current directory for files and folders and creates them if needed
    Installer()
    {
        try {
            path = System.getProperty("user.dir");
            File decks = new File(path + "/Decks");
            File masterList = new File(path + "/Decks/MasterDecklist.txt");
            File collection = new File(path + "/Decks/Collection.txt");

            if (!decks.exists() || !decks.isDirectory())
                decks.mkdir();

            if(!masterList.exists())
                masterList.createNewFile();

            if (!collection.exists())
                collection.createNewFile();

        }
        catch(Exception e)
        {
            System.out.println(e + " Installer");
        }
    }
}
