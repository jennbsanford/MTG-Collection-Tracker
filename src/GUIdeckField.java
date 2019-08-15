import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIdeckField extends JTextArea
{
    private Boolean defaultMessage = true;
    protected String currentDeck = "";
    protected String path = "Decks/";

    GUIdeckField(GridBagConstraints c)
    {
        super(20,25);
        setToolTipText("Click a card name to enter it above");
        c.gridwidth = 5;
        c.gridheight = 8;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 18;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);

        setEditable(false);
    }

    //displays selected deck in deck field
    protected void loadDeck(String list) throws Exception
    {
        //display deck list in field
        setText(list);
        setCaretPosition(0);
    }
}
