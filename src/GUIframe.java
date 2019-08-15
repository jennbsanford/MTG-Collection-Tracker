import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIframe extends JFrame implements ActionListener
{
    protected GUIpanel mainPanel;
    //protected MasterDecklist masterList;

    public GUIframe(MasterDecklist masterD, MasterCollection masterC) throws Exception
    {
        //set title and have program exit when window is closed
        super("MTG Collection Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try
        {
            //create panel and add to frame
            mainPanel = new GUIpanel(masterD, masterC);
            add(mainPanel);
            mainPanel.pack.addActionListener(this);
        }
        catch(Exception e)
        {
            System.out.println(e + " framePanelCreation");
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
                System.out.print(e + " Entered frame class listener.");
                pack();
            }
        });
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("FrameAction");
    }
}
