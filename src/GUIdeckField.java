import javax.swing.*;
import java.awt.*;

public class GUIdeckField extends JTextArea {

    GUIdeckField(GridBagConstraints c)
    {
        super(20,25);
        c.gridwidth = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 18;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);
        setEditable(false);
        append("deck here");////////
    }
}
