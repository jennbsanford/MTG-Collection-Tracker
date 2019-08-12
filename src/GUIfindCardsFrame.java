import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GUIfindCardsFrame extends JFrame
{
    protected JLabel text;
    protected JPanel panel;
    private int inCollection;
    private Vector<nameQuantity> inDecks;

    GUIfindCardsFrame()
    {
        super("Find Card");

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        /*c.gridwidth = GridBagConstraints.EAST;
        c.gridheight = 4;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 18;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 1;*/
        c.insets = new Insets(10, 10, 10,10);

        text = new JLabel();
        //text.setText("<html>Card: Doom Blade<p>You own 6 copies in your collection.");////
        //text.setText(text.getText() + "<p><p>1 in deckA");
        //text.setText(text.getText() + "<p>3 in deckB");
        //text.setText(text.getText() + "<p>2 in deckC</html>");
        //text.setVerticalTextPosition(JLabel.BOTTOM);
        //text.setHorizontalAlignment(JLabel.CENTER);

        panel.add(text, c);
        add(panel);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        //setVisible(false);
    }

    protected void findCard(String card, int numOwned, Vector<nameQuantity> numDecks)
    {
        setVisible(true);
        String copy;
        if(numOwned == 1)
            copy = "copy";
        else
            copy = "copies";

        //prints number of copies in collection
        text.setText("<html>Card: " + card + "<p>You have " + numOwned + " " + copy + " in your collection.<p>");

        //loops through decks finding all copies of entered card
        for(int i = 0; i < numDecks.size(); i++)
        {
            if(numDecks.elementAt(i).quantity == 1)
                copy = "copy";
            else
                copy = "copies";

            System.out.println("findcardsnow");
            text.setText(text.getText() + "<p>" + numDecks.elementAt(i).quantity + " " + copy + " in " + numDecks.elementAt(i).deckName + ".");
        }

        text.setText(text.getText() + "</html>");
        pack();
    }
}
