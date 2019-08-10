import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIframe extends JFrame implements ActionListener
{
    protected GUIpanel mainPanel;
    //protected MasterDecklist masterList;

    public GUIframe(MasterDecklist master) throws Exception
    {
        //set title and have program exit when window is closed
        super("MTG Collection Tracker");

        //masterList = master;
        //masterList.createStandardDecklist("deckA");
        //masterList.createStandardDecklist("deckB");
        //for(int i = 0; i < masterList.allDeckNames().size(); i++)
        //    System.out.println(masterList.allDeckNames().elementAt(i) + "frame");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try
        {
            //create panel and add to frame
            mainPanel = new GUIpanel(master);
            add(mainPanel);
            mainPanel.pack.addActionListener(this);
        }
        catch(Exception e)
        {
            System.out.println(e + " howdy");
            pack();
        }

        //show frame on screen
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        //signal was sent to pack the window
        mainPanel.pack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.print("Entered frame class main.");
                pack();
            }
        });
    }

    public static void main(String[] args)
    {
        System.out.print("Entered frame class main.");//////////
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("FrameAction");
    }
}
