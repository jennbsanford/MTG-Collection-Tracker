import javax.swing.*;
import java.awt.*;

public class GUIaddToDeckButton extends JButton
{
    GUIaddToDeckButton(GridBagConstraints c)
    {
        super("+ Main");
        setToolTipText("Add entered card to the mainboard");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 18;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 2, 5,2);
    }
}
