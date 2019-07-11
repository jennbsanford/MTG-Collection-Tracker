import javax.swing.*;
import java.awt.*;

public class GUIpanel extends JPanel
{
    protected JTextArea collection;
    protected JTextArea deck;
    protected JTextField input;

    GUIpanel()
    {
        //setup panel layout
        super(new GridBagLayout());

        //setup components
        collection = new JTextArea(10, 20);
        collection.setEditable(false);
        deck = new JTextArea(10, 20);
        deck.setEditable(false);
        input = new JTextField(40);


        //setup scroll bars for text boxes
        //JScrollPane scrollColl = new JScrollPane(collection);
        //JScrollPane scrollDeck = new JScrollPane(deck);

        //set constraint settings
        GridBagConstraints constraints = new GridBagConstraints();
        //constraints.gridwidth = GridBagConstraints.REMAINDER;

        //constraints.fill = GridBagConstraints.VERTICAL;

        //add components to panel
        constraints.gridwidth = 30;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(5, 5, 5,5);
        add(input, constraints);

        constraints.gridwidth = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(5, 5, 5,5);
        //constraints.anchor = GridBagConstraints.WEST;
        collection.append("collection here");
        add(new JScrollPane(collection), constraints);

        constraints.gridwidth = GridBagConstraints.EAST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 18;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(5, 5, 5,5);
        //constraints.anchor = GridBagConstraints.EAST;
        deck.append("deck here");
        add(new JScrollPane(deck), constraints);

    }

    public static void main(String[] args)
    {
        System.out.print("Entered panel class main.");//////////
        //initPanel();

    }
}
