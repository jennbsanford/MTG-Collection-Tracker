import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIdeleteDeckButton extends JButton implements ActionListener
{
    GUIdeleteDeckButton(GridBagConstraints c)
    {
        super("-");
        setToolTipText("Delete the current deck");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 4;
        c.gridy = 3;
        c.weightx = 0;
        c.weighty = 0;
        c.insets = new Insets(5, 1, 5,1);
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            String ObjType = e.getSource().getClass().getName();
        }
        catch(Exception ex)
        {
            System.out.println(ex + " deleteDeckButton");
        }
    }
}
