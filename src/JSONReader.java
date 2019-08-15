/*import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;///////////

public class JSONReader {
    @SuppressWarnings("unchecked")

    private JSONObject masterList;

    public static void main(String[] args)
    {
    }

    public JSONReader() {

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/AllCards.json"))
        {
            //Read JSON file
            masterList = (JSONObject) jsonParser.parse(reader);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public boolean isCardValid(String cardname) {
        if (masterList.get(cardname) == null)
            return false;
        else
            return true;
    }

    public void displayAllCards() {
        //https://stackoverflow.com/questions/9151619/how-to-iterate-over-a-jsonobject
        //masterList.keySet().forEach(cardName ->
        //    System.out.println("name: " + cardName)
        //);
        masterList.keySet().forEach(cardName ->
                System.out.println("name: " + cardName));
    }

    // returns valid String on success, null otherwise
    public String getCardDetails(String cardname, String details) {

        JSONObject result = (JSONObject) masterList.get(cardname);
        if (result == null)
            return null;

        return result.get(details).toString();

    }

    //test to display all cards in window
    /*public void displayAllCards(JTextArea ta) {
        //https://stackoverflow.com/questions/9151619/how-to-iterate-over-a-jsonobject
        jsonObject.keySet().forEach(keyStr ->
                ta.append("\n"+ keyStr)
        );
    }*/

//}

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
