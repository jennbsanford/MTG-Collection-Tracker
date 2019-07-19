import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GUIpanel extends JPanel implements ActionListener
{
    protected GUIcollectionField collection;
    protected GUIdeckField deck;
    protected GUIdecksComboBox deckNames;
    protected JTextField input;

    protected JButton temp;
    protected JButton temp2;

    GUIpanel()
    {
        //setup panel layout
        super(new GridBagLayout());

        //ready constraints
        GridBagConstraints c = new GridBagConstraints();

        //initialize components and add to panel
        collection = new GUIcollectionField(c);
        add(new JScrollPane(collection), c);

        deck = new GUIdeckField(c);
        add(new JScrollPane(deck), c);

        /////////////////////////////temp
        Vector<String> deckName = new Vector<String>();
        //deckName.add("Storm");
        //deckName.add("Dredge");
        //deckName.add("Amulet");
        ///////////////////////////////

        deckNames = new GUIdecksComboBox(c);
        add(deckNames, c);

        input = new JTextField(40);

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


        //setup scroll bars for text boxes
        //JScrollPane scrollColl = new JScrollPane(collection);
        //JScrollPane scrollDeck = new JScrollPane(deck);

        //set constraint settings
        //GridBagConstraints c = new GridBagConstraints();
        //c.gridwidth = GridBagConstraints.REMAINDER;

        //c.fill = GridBagConstraints.VERTICAL;

        //add components to panel
        c.gridwidth = 30;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);
        add(input, c);

        /*c.gridwidth = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);
        //c.anchor = GridBagConstraints.WEST;
        collection.append("collection here");
        add(new JScrollPane(collection), c);*/

        /*c.gridwidth = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 18;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);
        //c.anchor = GridBagConstraints.EAST;*/
        //deck.append("deck here");
        //add(new JScrollPane(deck), c);

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
