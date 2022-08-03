/**
 * CombinationDemo – a collection of Locker combinations
 * 
 * @author Kyle Luu
 * @version November 27, 2017
 */
public class CombinationDemo
{
    public static void main(String[] args)
    {
        /**
         * In this main method:
         * 
         * 1. Create an array to hold 20 lockers combinations
         *
         * 2. Print the list of the 20 locker combinations the print a        
         *    blank line
         *
         * 3. Re-print out the first combination labelled “first: ”
         *
         * 4. Re-print out the last combination labelled “last: ”
         *
         * 5. Count how many of them are combinations in sequential 
         *    order and print the result labelled “sequential: ” 
         *
         * 6. Count how many of them are in reverse sequential order
         *    and print the result labelled “reverse: ” 
         *
         * 7. Skip a line, then print “contains single digit”.  Then 
         *    print (and count) how many combinations contain at least
         *    one single digit as part of the combination.
         *    Then print out the total labelled “single digit:” 
         */

        // Part 1
        Combination[] lockers = new Combination[20]; //makes a new array lockers[] that has length of 20
        
        for(int i = 0; i < lockers.length; i++) //for every index in lockers[],
        {
            lockers[i] = new Combination(); //make a new random combination
        }

        
        // Part 2 (uncomment inside for loop and replace println with print to print it all in one line
        for(int i = 0; i < lockers.length; i++) //for every index in lockers[],
        {
            // if (i < lockers.length-1)
            // {
                System.out.println(lockers[i]); //print the combination
            // }
            // else
            // {
                // System.out.print(lockers[i]);
            // }
        } 
        
        System.out.println(); //blank line
        

        // Part 3
        System.out.println("first: " + lockers[0]); //prints the first locker combination

        
        // Part 4
        System.out.println("last: " + lockers[lockers.length-1]); //prints the last locker combination

        
        // Part 5
        int amountSequential = 0;
        //initializes a variable that will be used to count the amount of sequential combos
        
        for(int i = 0; i < lockers.length; i++) //for every index,
        {
            //if the third number - the second number is positive AND the second number - the first is positive,
            if ( (lockers[i].get(2) - lockers[i].get(1) > 0) && (lockers[i].get(1) - lockers[i].get(0) > 0))
            {
                amountSequential++; //increase amountSequential by one
            }
        }
        
        System.out.println("sequential: " + amountSequential); //print out the amount sequential.

        
        // Part 6
        int amountReverse = 0;
        //initializes a variable that will be used to count the amount of reverse sequential combos
        
        for(int i = 0; i < lockers.length; i++) //for every index,
        {
            //if the third number is less than the second AND the second is less than the first,
            if ( (lockers[i].get(2) - lockers[i].get(1) < 0) && (lockers[i].get(1) - lockers[i].get(0) < 0))
            {
                amountReverse++; //increase amountReverse by one.
            }
        }
        
        System.out.println("reverse: " + amountReverse); //print out the amount of reverse sequentials
        

        // Part 7
        System.out.println(); //blank line
        
        final int DOUBLE_DIGIT = 10; //10 is the first int with 2 digits
        
        int singleDigits = 0;
        //initializes a variable that counts how many combinations with a single digit there are
        
        for(int i = 0; i < lockers.length; i++)
        {
            //if any of the numbers in the combo have one digit,
            if ( (lockers[i].get(0) < DOUBLE_DIGIT) || (lockers[i].get(1) < DOUBLE_DIGIT) || (lockers[i].get(2) < DOUBLE_DIGIT) )
            {
                System.out.println(lockers[i]); //print it out
                singleDigits++; //and increase singleDigits by one.
            }
        }
        
        System.out.println("single digit: " + singleDigits); //print out the total combos with at least 1 single digit.
    }
}
