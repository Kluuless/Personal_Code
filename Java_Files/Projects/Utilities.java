import java.util.ArrayList;

/**
 * A bunch of utility static methods
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Utilities
{
    public static void randomNumber(int max)
    {
        System.out.println((int)(Math.random() * max) + 1);
    }
    
    public static boolean intListContains(int num, ArrayList<Integer> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) == num)
            {
                return true;
            }
        }
        return false;
    }
    
    public static String listToString(ArrayList<String> letters)
    {
        String result = "";
        for (int i = 0; i < letters.size(); i++)
        {
            result += letters.get(i) + ", ";
        }
        result = result.substring(0,result.length()-2);
        return result;
    }
    
    public static boolean stringListContains(String string, ArrayList<String> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).equalsIgnoreCase(string))
            {
                return true;
            }
        }
        return false;
    }
}
