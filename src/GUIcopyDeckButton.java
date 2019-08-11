import javax.swing.*;
import java.awt.*;

public class GUIcopyDeckButton extends JButton
{
    GUIcopyDeckButton(GridBagConstraints c)
    {
        super("++");
        setToolTipText("Copy the current deck");
        //c.gridwidth = GridBagConstraints.WEST;
        //c.fill = GridBagConstraints.BOTH;
        //c.gridheight = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 2;
        //c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        c.weighty = 0;
        c.insets = new Insets(5, 1, 5,1);
    }
}
