import javax.swing.*;
import java.awt.*;

public class GUIremoveFromDeckButton extends JButton
{
    GUIremoveFromDeckButton(GridBagConstraints c)
    {
        super("- Main");
        setToolTipText("Remove entered card from the mainboard");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 20;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 2, 5,2);
    }
}
