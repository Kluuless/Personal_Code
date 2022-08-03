import java.util.Scanner;
/**
 * Runs many simulations and tests them
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Tester
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("How many times would you like to run the simulation? ");
        int times = scanner.nextInt();
        
        System.out.println("Running " + times + " simulations and averaging the results:");
        double[] results = new double[times];
        double amountRun = 0;
        for (int i = 0; i < times; i++)
        {
            results[i] = Pi.run(times);
            Pi.clearCounts();
            amountRun++;
            if ((amountRun/times*100)%10 == 0)
            {
                System.out.println((int)(amountRun/times*100) + "% finished");
            }
        }
        
        double total = 0;
        int count = 0;
        for (double x : results)
        {
            total += x;
            count++;
        }
        double piGuess = total/count;
        System.out.println("The result is: " + piGuess);
        System.out.println("The real value of pi is " + Math.PI);
        System.out.println("You were " + Math.abs(Math.PI - piGuess) + " off");
        System.out.println("You were " + (Math.abs(Math.PI - piGuess) / Math.PI / 100) + "% off");
    }
}
