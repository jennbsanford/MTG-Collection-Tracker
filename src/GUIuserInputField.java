import javax.swing.*;
import java.awt.*;

public class GUIuserInputField extends JTextField
{
    GUIuserInputField(GridBagConstraints c)
    {
        super(20);
        c.gridwidth = 20;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5,5);
    }
}
