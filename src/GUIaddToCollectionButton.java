import javax.swing.*;
import java.awt.*;

public class GUIaddToCollectionButton extends JButton
{
    GUIaddToCollectionButton(GridBagConstraints c)
    {
        super("+ Collection");
        setToolTipText("Add the entered card to your collection");
        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 2, 5,2);
    }
}
