import javax.swing.*;
import java.awt.*;

public class GUIpanel extends JPanel
{
    protected JTextArea collection;
    protected JTextArea deck;

    GUIpanel()
    {
        //setup panel layout
        super(new GridBagLayout());

        //setup text boxes
        collection = new JTextArea(10, 20);
        collection.setEditable(false);
        deck = new JTextArea(10, 20);

        //setup scroll bars for text boxes
        //JScrollPane scrollColl = new JScrollPane(collection);
        //JScrollPane scrollDeck = new JScrollPane(deck);

        //set constraint settings
        GridBagConstraints constraints = new GridBagConstraints();
        //constraints.gridwidth = GridBagConstraints.REMAINDER;

        //constraints.fill = GridBagConstraints.VERTICAL;

        //add components to panel
        constraints.gridwidth = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        //constraints.anchor = GridBagConstraints.WEST;
        collection.append("collection here");
        add(new JScrollPane(collection), constraints);

        constraints.gridwidth = GridBagConstraints.EAST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 18;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
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
