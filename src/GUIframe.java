import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

//public class GUIframe
public class GUIframe extends JFrame
{
    protected GUIpanel mainPanel;
    protected GUIcontainer contentPane;/////

    public GUIframe() throws Exception
    {
        //set title and have program exit when window is closed
        super("MTG Collection Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //create panel and add to frame
        mainPanel = new GUIpanel();
        add(mainPanel);


        //contentPane = new GUIcontainer();
        //add(contentPane);

        //////////////
        mainPanel.deck.currentDeck = "C:\\Users\\Dylan\\Desktop\\Decks\\deck1.txt";
        try {
            mainPanel.deck.loadDeck();
        }
        catch(Exception e)
        {
            System.out.println(e + "hello");
        }//////////////

        //show frame on screen
        pack();
        setVisible(true);
    }
    /*private static void initFrame()
    {
        //set program to exit when window is closed
        //mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create and add panel
        //GUIpanel mainPanel = new GUIpanel();
        //mainFrame.add(mainPanel);
    }*/

    public static void main(String[] args)
    {
        System.out.print("Entered frame class main.");//////////
        //GUIpanel mainPanel = new GUIpanel();
        //initFrame();

    }
}
