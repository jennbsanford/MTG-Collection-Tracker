import javax.swing.*;
import java.awt.*;

public class GUIcollectionField extends JTextArea
{

    GUIcollectionField(GridBagConstraints c)
    {
        super(20,25);
        //c.gridwidth = GridBagConstraints.WEST;
        c.gridheight = 5;
        c.gridwidth = 1;
        //c.gridheight = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);
        setEditable(false);
        //c.anchor = GridBagConstraints.WEST;
        append("collection here");////////
    }
}
