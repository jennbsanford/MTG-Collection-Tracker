import javax.swing.*;
import java.awt.*;

public class GUIfindCardsButton extends JButton
{
    GUIfindCardsButton(GridBagConstraints c)
    {
        super("Find Copies");
        setToolTipText("Find all copies of the entered card");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 2, 5,2);
    }
}
