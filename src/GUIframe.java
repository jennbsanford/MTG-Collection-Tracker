import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class GUIframe extends JFrame
{
    protected GUIpanel mainPanel;
    //protected GUIcontainer contentPane;

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

        //show frame on screen
        pack();
        setVisible(true);
    }

    public static void main(String[] args)
    {
        System.out.print("Entered frame class main.");//////////
    }
}
