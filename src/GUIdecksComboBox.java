import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GUIdecksComboBox extends JComboBox
{
    GUIdecksComboBox(GridBagConstraints c, Vector<String> deckNames)
    {
        c.gridwidth = 5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridx = 18;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);

        loadNames(deckNames);
    }

    @SuppressWarnings("unchecked")
    //loads deck names from master list
    protected void loadNames(Vector<String> deckNames)
    {
        //empty list first
        removeAllItems();

        for(int i = 0; i < deckNames.size(); i++)
            addItem(deckNames.elementAt(i));
    }
}
