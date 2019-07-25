import javax.swing.*;

public class GUIframe extends JFrame
{
    protected GUIpanel mainPanel;

    public GUIframe() throws Exception
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

    public static void main(String[] args)
    {
        System.out.print("Entered frame class main.");//////////
    }
}
