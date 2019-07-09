import java.awt.*;
import javax.swing.*;

public class GUI {

    ///////////////////////////////////////////////////////////////////////
    //TO DO: change this classes name to GUIframe and make GUIpanel class//
    ///////////////////////////////////////////////////////////////////////


    public static void createFrame() {

        //create new window
        JFrame mainFrame = new JFrame("MTG Collection Tracker");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*/mainFrame.setSize(2000,400); /////////just for tests
        JButton b = new JButton("YES");
        b.setBounds(50,100,100,50);
        mainFrame.add(b);
        mainFrame.setSize(2000,400);
        mainFrame.setLayout(null);
        */

        //just tests
        JPanel mainPanel = new JPanel(new GridBagLayout());
        JTextArea ta = new JTextArea(5,20);
        mainPanel.add(ta);
        mainFrame.add(mainPanel);

        //add objects to frame
        //info();

        //show frame on screen
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        System.out.print("Entered frame class main.");
        createFrame();
    }
}
