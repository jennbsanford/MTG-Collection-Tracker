import javax.swing.*;
import java.awt.*;

public class GUIcopyDeckButton extends JButton
{
    GUIcopyDeckButton(GridBagConstraints c)
    {
        super("+");
        setToolTipText("Create a new deck");
        //c.gridwidth = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        //c.gridheight = GridBagConstraints.NORTH;
        c.gridx = 3;
        c.gridy = 1;
        //c.fill = GridBagConstraints.NONE;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 1, 5,1);
    }
}
