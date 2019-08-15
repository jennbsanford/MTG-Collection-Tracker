import javax.swing.*;
import java.awt.*;

public class GUIremoveFromCollectionButton extends JButton
{
    GUIremoveFromCollectionButton(GridBagConstraints c)
    {
        super("- Collection");
        setToolTipText("Remove the entered card from your collection");
        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 2, 5,2);
    }
}
