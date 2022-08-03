import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Testing out ways to display different things
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Frames
{
    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel emptyLabel = new JLabel("Test");
        emptyLabel.setPreferredSize(new Dimension(175,100));
        frame.getContentPane().add(emptyLabel,BorderLayout.CENTER);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        }
        );
    }
}
