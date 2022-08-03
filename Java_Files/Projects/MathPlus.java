
/**
 * Extra Math Functions.
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class MathPlus
{
    public static int factorial(int n)
    {
        if (n < 0)
        {
            return -1;
        }
        else if (n == 0)
        {
            return 1;
        }
        else
        {
            int total = 1;
            for (int i = 1; i <= n; i++)
            {
                total *= i;
            }
            return total;
        }
    }

    public static double cos(double num, int iterations)
    {
        double result = 0.0;
        for (int i = 0; i < iterations; i++)
        {
            if (i % 2 == 0)
            {
                result += (Math.pow(num,i*2)/factorial(i*2));
            }
            else
            {
                result -= (Math.pow(num,i*2)/factorial(i*2));
            }
        }
        return result;
    }
}
