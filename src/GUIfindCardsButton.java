import javax.swing.*;
import java.awt.*;

public class GUIfindCardsButton extends JButton
{
    protected String path = "Decks";

    GUIfindCardsButton(GridBagConstraints c)
    {
        //super("<html>Find All<p>Copies</html>");
        super("Find Copies");
        setToolTipText("Find all copies of the entered card");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 22;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 2, 5,2);
    }
}
