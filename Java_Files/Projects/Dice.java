
/**
 * Simulates a dice roll
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Dice
{
    public static void d4()
    {
        System.out.println((int)(Math.random() * 4 + 1));
    }
    
    public static void d6()
    {
        System.out.println((int)(Math.random() * 6 + 1));
    }
    
    public static void d8()
    {
        System.out.println((int)(Math.random() * 8 + 1));
    }
    
    public static void d12()
    {
        System.out.println((int)(Math.random() * 12 + 1));
    }
    
    public static void d20()
    {
        System.out.println((int)(Math.random() * 20 + 1));
    }
    
    public static void percentage()
    {
        System.out.println((int)(Math.random() * 1000)/10);
    }
    
    private static int dInt(int numOfFaces)
    {
        return ((int)(Math.random() * numOfFaces + 1));
    }
    
    public static void multipleDice(int diceType, int amount)
    {
        int total = 0;
        for (int i = 0; i < amount; i++)
        {
            total += dInt(diceType);
        }
        System.out.println(total);
    }
}
