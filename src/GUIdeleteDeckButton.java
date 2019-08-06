import javax.swing.*;
import java.awt.*;

public class GUIdeleteDeckButton extends JButton
{
    GUIdeleteDeckButton(GridBagConstraints c)
    {
        super("-");
        setToolTipText("Delete the current deck");
        //c.gridwidth = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        //c.gridheight = GridBagConstraints.NORTH;
        c.gridx = 3;
        c.gridy = 3;
        //c.fill = GridBagConstraints.NONE;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 1, 5,1);
    }
}
