import javax.swing.*;

//public class GUIframe
public class GUIframe extends JFrame
{
    protected GUIpanel mainPanel = new GUIpanel();
    //protected static JFrame mainFrame = new JFrame("MTG Collection Tracker");

    public GUIframe()
    {
        super("MTG Collection Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private static void initFrame()
    {
        //set program to exit when window is closed
        //mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create and add panel
        //GUIpanel mainPanel = new GUIpanel();
        //mainFrame.add(mainPanel);
    }

    public static void main(String[] args)
    {
        System.out.print("Entered frame class main.");//////////
        //initFrame();

    }
}
