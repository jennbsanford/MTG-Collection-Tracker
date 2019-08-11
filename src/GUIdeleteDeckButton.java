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
        //c.gridheight = GridBagConstraints.NORTH;
        c.gridx = 3;
        c.gridy = 3;
        //c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        c.weighty = 0;
        c.insets = new Insets(5, 1, 5,1);
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            //System.out.println(e.getClass());

            //find type of object that performed the action
            String ObjType = e.getSource().getClass().getName();
        }
        catch(Exception ex)
        {
            System.out.println(ex + "deleteDeckButton");//////
        }
    }
}
