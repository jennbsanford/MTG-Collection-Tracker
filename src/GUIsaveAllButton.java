import javax.swing.*;
import java.awt.*;

public class GUIsaveAllButton extends JButton
{
    GUIsaveAllButton(GridBagConstraints c)
    {
        super("+");
        setToolTipText("Create a new deck");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 3;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 1, 5,1);
    }
}
