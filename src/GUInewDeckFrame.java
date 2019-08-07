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
    protected JButton copyDeck;
    protected String copyName;
    //protected JLabel errorMessage;
    //protected String path = "Decks//";//
    protected String path = "Decks/";//
    private boolean makeCopy = false;

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
        saveName.addActionListener(this);
        panel.add(saveName, c);

        updater = new JButton("temp");
        copyDeck = new JButton("temp");

        //errorMessage = new JLabel();
        //c.gridy = 4;
        //panel.add(errorMessage, c);

        add(panel);
        pack();
        setResizable(false);//
        setLocationRelativeTo(null);
    }

    /*Boolean duplicate(String name)
    {

        return false;
    }*/

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            //System.out.println(e.getClass());

            //find type of object that performed the action
            String ObjType = e.getSource().getClass().getName();
            System.out.println(ObjType);/////

            //user pressed new deck button
            if(ObjType == "GUIcreateDeckButton")
            {
                inputField.setText("");
                makeCopy = false;
                setVisible(true);
                inputField.requestFocusInWindow();
            }

            if(ObjType == "GUIcopyDeckButton")
            {
                inputField.setText("");
                makeCopy = true;
                setVisible(true);
                inputField.requestFocusInWindow();
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
                    String location = inputField.getText() + ".txt";
                    File newDeck = new File(path + location);
                    if(!newDeck.createNewFile())
                        JOptionPane.showMessageDialog(warning, "File couldn't be created.");
                    else
                    {
                        this.setVisible(false);
                        if(makeCopy == true)
                        {
                            copyName = location;
                            copyDeck.doClick();
                        }
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
