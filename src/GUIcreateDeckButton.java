import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIcreateDeckButton extends JButton
{
    protected String path = "Decks";//

    GUIcreateDeckButton(GridBagConstraints c)
    {
        super("+");
        setToolTipText("Create a new deck");
        //c.gridwidth = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.gridheight = GridBagConstraints.NORTH;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx = 3;
        c.gridy = 1;
        c.weightx = 0;
        c.weighty = 0;
        c.insets = new Insets(5, 1, 5,1);
    }
}
