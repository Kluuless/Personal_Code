/**
 * BinaryConversion - convert a number between decimal and binary.
 * 
 * @author Kyle Luu
 * @version 1.0
 */
public class BinaryConversion
{
    private String num; //The numeric value
    private int base;   //The base of the numeric value (10 or 2)

    /**
     * Constructor for objects of class BinaryDemo
     * 
     * @precondition – n is a non-negative integer in base 10
     */
    public BinaryConversion(int n)
    {
        num = n + "";
        base = 10;
    }

    /**
     * HELPER METHOD - turns any integer n into binary
     * 
     * @param   The number to be converted
     * 
     * @return  The number n in base 2 as a String
     */
    private static String toBinary(int n)
    {
        if (n == 0)
        {
            return "0";
        }
        else
        {
            String result = "";
            result += toBinary(n/2);
            result += n % 2;
            return result;
        }
    }

    /**
     * Convert to base 2
     * 
     * @precondition - the number is in base 10
     * @postcondition - update the base to 2
     * @return - true if the precondition is met, false otherwise
     */
    public boolean toBase2()
    {
        if (base != 10)
        {
            return false;
        }
        else
        {
            num = toBinary(Integer.parseInt(num)).substring(1);
            if (num.length() == 0)
            {
                num = "0";
            }
            base = 2;
            return true;
        }
    }

    private static String reverseDigits(String n)
    {
        String result = "";
        for (int i = n.length() - 1; i >= 0; i--)
        {
            result += n.charAt(i);
        }
        return result;
    }
    
    private static int toBaseTen(String n)
    {
        String reverseN = reverseDigits(n);
        int result = 0;
        for (int i = 0; i < ("" + reverseN).length(); i++)
        {
            if (reverseN.charAt(i) == '1')
            {
                result += (int)Math.pow(2, i);
            }
        }
        return result;
    }

    /**
     * Convert to base 10
     * 
     * @precondition - the number is in base 2
     * @postcondition - update the base to 10      
     * @return - true if the precondition is met, false otherwise
     */
    public boolean toBase10()
    {
        if (base != 2)
        {
            return false;
        }
        else
        {
            num = "" + toBaseTen(num);
            base = 10;
            return true;
        }
    }

    public String toString()
    {
        return num + " in base " + base;
    }
}

