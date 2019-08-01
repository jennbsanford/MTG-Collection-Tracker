import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIframe extends JFrame implements ActionListener
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
        //mainPanel.createDeck.addActionListener(this);

        //show frame on screen
        pack();
        setResizable(false);//
        setVisible(true);
    }

    public static void main(String[] args)
    {
        System.out.print("Entered frame class main.");//////////
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("YOOOO");
    }
}
