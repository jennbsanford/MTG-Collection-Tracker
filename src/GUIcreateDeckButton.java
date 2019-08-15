import javax.swing.*;
import java.awt.*;

public class GUIcreateDeckButton extends JButton
{
    protected String path = "Decks";//

    GUIcreateDeckButton(GridBagConstraints c)
    {
        super("+");
        setToolTipText("Create a new deck");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx = 4;
        c.gridy = 1;
        c.weightx = 0;
        c.weighty = 0;
        c.insets = new Insets(5, 3, 5,1);
    }
}
