import java.util.Scanner;
/**
 *  A program that gets a set of numbers as an input and outputs the certain information.
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Calculate
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        double[] temp = {0};
        Numbers nums = new Numbers(temp);
        
        boolean running = true;
        boolean first = true;
        while (running)
        {
            System.out.print("Please enter a number, or x to stop: ");
            String input = in.nextLine();
            if (input.equals("x"))
            {
                running = false;
            }
            else if (first)
            {
                double doubleValue = Double.valueOf(input);
                nums.setValue(0,doubleValue);
                first = false;
            }
            else
            {
                double doubleValue = Double.valueOf(input);
                nums.addValue(doubleValue);
            }
        }
        
        String stringRep = nums.toString();
        stringRep = stringRep.substring(1,stringRep.length()-1);
        Numbers numsOrdered = new Numbers(nums.inOrder());
        String orderString = numsOrdered.toString();
        orderString = orderString.substring(1,orderString.length()-1);
        
        System.out.println();
        System.out.println("Your inputs are: " + stringRep);
        System.out.println("In numerical order, they are: " + orderString);
        System.out.println("The biggest value is: " + nums.biggest());
        System.out.println("The smallest value is: " + nums.smallest());
        System.out.println("The sum of the numbers is: " + nums.sum());
        System.out.println("The difference between the biggest number and the rest is: " + nums.biggestDiff());
        System.out.println("The difference between the first number and the rest is: " + nums.orderDiff());
        System.out.println("The product of the numbers is: " + nums.product());
        System.out.println("The biggest number divided by the rest is: " + nums.biggestQuotient());
        System.out.println("The first number divided by the rest is: " + nums.orderQuotient());
        System.out.println("The average (arithmetic mean) of the numbers is: " + nums.average());
        System.out.println("The median of the numbers is: " + nums.median());
        System.out.println("The range of the numbers is: " + nums.range());
        System.out.println("The mode of the numbers is: " + nums.mode());
    }
}
