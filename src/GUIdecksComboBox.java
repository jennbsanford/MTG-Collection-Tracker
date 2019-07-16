import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GUIdecksComboBox extends JComboBox {

    private Vector<String> deckNames;


    GUIdecksComboBox(GridBagConstraints c, Vector<String> names)
    {
        super(names);
        c.gridwidth = GridBagConstraints.EAST;
        //c.fill = GridBagConstraints.BOTH;
        c.gridx = 19;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);
        /*deckNames = names;
        deckNames.add("Storm");
        deckNames.add("Dredge");
        deckNames.add("Mid Dazzle");*/
    }
}
