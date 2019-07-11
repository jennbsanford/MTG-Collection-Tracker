import javax.swing.*;

//public class GUIframe
public class GUIframe extends JFrame
{
    protected GUIpanel mainPanel;

    public GUIframe()
    {
        //set title and have program exit when window is closed
        super("MTG Collection Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create panel and add to frame
        mainPanel = new GUIpanel();
        add(mainPanel);

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
