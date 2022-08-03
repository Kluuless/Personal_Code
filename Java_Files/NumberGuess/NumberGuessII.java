import java.util.Scanner;
/**
 * Guesses two numbers given their sum and product.
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class NumberGuessII
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Think of two integers, 1 to 1,000.");
        System.out.print("What is their sum? ");
        int sum = in.nextInt();
        System.out.print("What is the product? ");
        int product = in.nextInt();
        System.out.println();
        
        int num1 = 1;
        int num2 = 1;
        
        for (num1 = 1; num1 <= sum; num1++)
        {
            for (num2 = 1; num2 <= sum; num2++)
            {
                if (num1 + num2 == sum && num1 * num2 == product)
                {
                    break;
                }
            }
            if (num1 + num2 == sum && num1 * num2 == product)
                {
                    break;
                }
        }
        
        System.out.println("Your numbers are:");
        System.out.println("" + num1);
        System.out.println("" + num2);
    }
}
