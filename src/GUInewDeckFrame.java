import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUInewDeckFrame extends JFrame implements ActionListener
{
    private JPanel panel;
    protected JTextField inputField;
    protected JButton saveName;
    protected boolean makeCopy = false;

    GUInewDeckFrame()
    {
        super("Enter new deck name");

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        inputField = new JTextField(30);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 5;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(3, 1, 3,1);
        panel.add(inputField, c);

        saveName = new JButton("Save");
        c.gridx = 3;
        c.gridy = 1;
        this.getRootPane().setDefaultButton(saveName);
        panel.add(saveName, c);

        add(panel);
        pack();
        setResizable(false);//
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            //find type of object that performed the action
            String ObjType = e.getSource().getClass().getName();

            //user pressed new deck button
            if(ObjType == "GUIcreateDeckButton")
            {
                inputField.setText("");
                makeCopy = false;
                setVisible(true);
                inputField.requestFocusInWindow();
            }

            else if(ObjType == "GUIcopyDeckButton")
            {
                inputField.setText("");
                makeCopy = true;
                setVisible(true);
                inputField.requestFocusInWindow();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex + " newDeckFrame");
        }
    }
}
