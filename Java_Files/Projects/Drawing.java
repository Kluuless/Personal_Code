import javax.swing.*;
import java.awt.*;

/**
 * Testing out drawing of shapes
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Drawing extends JFrame
{
    public Drawing()
    {
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String a[])
    {
        new Drawing();
    }
    
    public void paint(Graphics g)
    {
        g.setColor(Color.RED);
        
        g.drawOval(80,80,120,120);
        g.drawRect(80,80,200,200);
        g.drawArc(320,320,100,100,90,180);
        
        g.setColor(Color.BLUE);
        
        int[] xPoints = {100,400,300,400,100};
        int[] yPoints = {500,100,300,400,150};
        g.drawPolyline(xPoints,yPoints,5);
        
        g.draw3DRect(100,600,100,100,true);
        
        g.setColor(Color.BLACK);
        
        
    }
}