import javax.swing.*;
import java.awt.*;

public class GUIaddToDeckButton extends JButton
{
    GUIaddToDeckButton(GridBagConstraints c)
    {
        super("+");
        setToolTipText("Create a new deck");
        //c.gridwidth = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        //c.gridheight = GridBagConstraints.NORTH;
        c.gridx = 18;
        c.gridy = 0;
        //c.fill = GridBagConstraints.NONE;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 1, 5,1);
    }
}
