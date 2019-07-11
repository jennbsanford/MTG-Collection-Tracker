import javax.swing.*;
import java.awt.*;

public class GUIpanel extends JPanel
{
    protected JTextField collection;
    protected JTextField deck;

    public static void initPanel()
    {
        super(new GridBagLayout());
    }

    public static void main(String[] args)
    {
        System.out.print("Entered panel class main.");//////////
        initPanel();

    }
}
