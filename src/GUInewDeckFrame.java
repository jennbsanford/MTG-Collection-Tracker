import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUInewDeckFrame extends JFrame implements ActionListener
{
    protected JPanel panel;
    protected JTextField inputField;
    protected JButton saveName;
    protected JButton updater;
    //protected JLabel errorMessage;
    //protected String path = "Decks//";//
    protected String path = "Decks/";//

    GUInewDeckFrame()
    {
        super("New Deck");

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        inputField = new JTextField(30);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        panel.add(inputField, c);

        saveName = new JButton("Save");
        c.gridx = 2;
        saveName.addActionListener(this);
        panel.add(saveName, c);

        updater = new JButton("temp");

        //errorMessage = new JLabel();
        //c.gridy = 4;
        //panel.add(errorMessage, c);

        add(panel);
        pack();
        setResizable(false);//
    }

    Boolean duplicate(String name)
    {

        return false;
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            //System.out.println(e.getClass());

            //find type of object that performed the action
            String ObjType = e.getSource().getClass().getName();
            System.out.println(ObjType);

            //user pressed new deck button
            if(ObjType == "GUIcreateDeckButton")
            {
                inputField.setText("");
                setVisible(true);
            }

            //user pressed save button
            if(ObjType == "javax.swing.JButton")
            {
                //System.out.println(inputField.getText() + "hello");
                //errorMessage.setText("Name already in use!");
                JFrame warning = new JFrame();

                if(inputField.getText().isEmpty())
                    JOptionPane.showMessageDialog(warning, "Name cannot be blank.");

                /*else if(duplicate(inputField.getText()))
                {
                    JOptionPane.showMessageDialog(warning, "Name already in use.");
                }*/

                else
                {
                    File newDeck = new File(path + inputField.getText() + ".txt");
                    if(!newDeck.createNewFile())
                        JOptionPane.showMessageDialog(warning, "File couldn't be created.");
                    else
                    {
                        this.setVisible(false);
                        updater.doClick();  //sends signal to update deck field and drop down menu
                    }
                }

                //JOptionPane.showMessageDialog(warning, "Name already in use.");
            }
        }
        catch(Exception ex)
        {
            //System.out.println(ex + "deckField");//////
        }
    }
}
