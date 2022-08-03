
/**
 * Uses random numbers to try to calculate pi
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Pi
{
    private static int amountIn = 0;
    private static int total = 0;
    public static double iteration()
    {
        double x = Math.random() * 100000 - 50000;
        double y = Math.random() * 100000 - 50000;
        //System.out.println("X: " + x + " Y: " + y);
        //System.out.println("Distance: " + Math.sqrt(x * x + y * y));
        return (Math.sqrt(x * x + y * y));
    }
    
    public static void count()
    {
        double num = iteration();
        if (num < 50000)
        {
            amountIn++;
        }
        total++;
        //System.out.println("In: " + amountIn + ", Total: " + total);
    }
    
    public static double calculate()
    {
        //System.out.println("In: " + amountIn + " Out: " + (total - amountIn));
        return ((double)amountIn/total * 4);
    }
    
    public static double run(int calculations)
    {
        for (int i = 0; i < calculations; i++)
        {
            count();
        }
        return calculate();
    }
    
    public static boolean clearCounts()
    {
        amountIn = 0;
        total = 0;
        // System.out.println("Cleared");
        return true;
    }
}

