import javax.swing.*;
import java.awt.*;

public class GUIfindCardsButton extends JButton
{
    protected String path = "Decks";

    GUIfindCardsButton(GridBagConstraints c)
    {
        super("Find");
        setToolTipText("Find all copies of the entered card");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 21;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);
    }
}
