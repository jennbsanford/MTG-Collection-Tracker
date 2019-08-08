import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIfindCardsFrame extends JFrame implements ActionListener
{
    protected JLabel text;
    protected JPanel panel;

    GUIfindCardsFrame()
    {
        super("Locations of entered card");

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        /*c.gridwidth = GridBagConstraints.EAST;
        c.gridheight = 4;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 18;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 1;*/
        c.insets = new Insets(10, 10, 10,10);

        text = new JLabel();
        text.setText("<html>Card: Doom Blade<p>You own 6 copies in your collection.");////
        text.setText(text.getText() + "<p><p>1 in deckA");
        text.setText(text.getText() + "<p>3 in deckB");
        text.setText(text.getText() + "<p>2 in deckC</html>");
        //text.setVerticalTextPosition(JLabel.BOTTOM);
        //text.setHorizontalAlignment(JLabel.CENTER);

        panel.add(text, c);
        add(panel);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        //setVisible(false);
    }

    protected void findCard(String cardName)
    {
        System.out.println("findCardRoutine");
        setVisible(true);
    }

    //activates when a deck is selected from drop down menu
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            //System.out.println(action.getClass());

            //find type of object that performed the action
            String ObjType = e.getSource().getClass().getName();

            //user selected a deck to load
            //if(ObjType == "GUIfindCardsButton")
            //{
            //    System.out.println("newFrame");
            //    setVisible(true);
            //}
        }
        catch(Exception ex)
        {
            System.out.println(ex + "findCardsFrame");//////
        }
    }
}
