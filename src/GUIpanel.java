import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIpanel extends JPanel implements ActionListener
{
    protected GUIcollectionField collection;
    protected GUIdeckField deck;
    protected GUIdecksComboBox deckNames;
    protected JTextField input;

    protected JButton temp;//
    protected JButton temp2;//

    GUIpanel()
    {
        //setup panel layout
        super(new GridBagLayout());

        //ready constraints
        GridBagConstraints c = new GridBagConstraints();

        //initialize components and add to panel
        //collection field
        collection = new GUIcollectionField(c);
        add(new JScrollPane(collection), c);

        //deck list field
        deck = new GUIdeckField(c);
        add(new JScrollPane(deck), c);

        //deck list drop down menu
        deckNames = new GUIdecksComboBox(c);
        deckNames.addActionListener(deck);
        add(deckNames, c);

        //user input field
        input = new JTextField(40);
        c.gridwidth = 30;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);
        add(input, c);

        temp = new JButton();
        c.gridwidth = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);
        temp.addActionListener(this);
        add(temp, c);

        temp2 = new JButton();
        c.gridwidth = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        c.gridx = 7;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);
        temp2.addActionListener(this);
        add(temp2, c);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("YOOOO");
    }

    public static void main(String[] args)
    {
        System.out.print("Entered panel class main.");//////////
    }
}
