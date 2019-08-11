import javax.swing.*;
import java.awt.*;

public class GUIaddToDeckSideButton extends JButton
{
    GUIaddToDeckSideButton(GridBagConstraints c)
    {
        super("+ Side");
        setToolTipText("Add entered card to the sideboard");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 19;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 2, 5,2);
    }
}