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
        collection = new JTextArea(5, 20);
        collection.setEditable(false);
        deck = new JTextArea(10, 20);

        //setup scroll bars for text boxes
        JScrollPane scrollColl = new JScrollPane(collection);
        JScrollPane scrollDeck = new JScrollPane(deck);

        //set constraint settings
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        //constraints.fill = GridBagConstraints.VERTICAL;

        //add components to panel
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 1;
        collection.append("coll");
        add(collection, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 2;
        constraints.gridy = 1;
        deck.append("deck");
        add(deck, constraints);

    }

    public static void main(String[] args)
    {
        System.out.print("Entered panel class main.");//////////
        //initPanel();

    }
}
