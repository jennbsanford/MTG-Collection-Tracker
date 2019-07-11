import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONhelper {
    @SuppressWarnings("unchecked")

    private JSONObject jsonObject;
    private Object obj;

    public static void main(String[] args)
    {
    }

    public JSONhelper() {

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/AllCards.json"))
        {
            //Read JSON file
            obj = jsonParser.parse(reader);
            jsonObject = (JSONObject) obj;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public boolean isCardValid(String cardname) {

        if (jsonObject.get(cardname) == null)
            return false;
        else
            return true;

    }

    public void displayAllCards() {
        //https://stackoverflow.com/questions/9151619/how-to-iterate-over-a-jsonobject
        jsonObject.keySet().forEach(keyStr ->
        {
            System.out.println("name: "+ keyStr);
        });
    }

}

// https://howtodoinjava.com/library/json-simple-read-write-json-examples/
//String name = jsonObject.get("A Display of My Dark Power").toString();
//System.out.println(name);

//Map card = (Map) jsonObject.get("A Display of My Dark Power");
//String title = card.get("name").toString();
//System.out.println(title);

//JSONArray card = (JSONArray) jsonObject.get("A Display of My Dark Power");
//System.out.println();

// INSIDE THE FOR LOOP CODE!
//for nested objects iteration if required
//Object keyvalue = jsonObject.get(keyStr);
//if (keyvalue instanceof JSONObject)
//    printJsonObject((JSONObject)keyvalue);
//System.out.println("key: "+ keyStr + " value: " + keyvalue);