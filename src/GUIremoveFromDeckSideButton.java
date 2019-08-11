import javax.swing.*;
import java.awt.*;

public class GUIremoveFromDeckSideButton extends JButton
{
    GUIremoveFromDeckSideButton(GridBagConstraints c)
    {
        super("- Card");
        setToolTipText("Remove entered card from the sideboard");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 21;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 2, 5,2);
    }
}
