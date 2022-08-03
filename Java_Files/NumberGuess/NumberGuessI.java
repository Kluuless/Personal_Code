import java.util.Scanner;
/**
 * Kyle's answer to hw 6.3.
 * 
 * @author Kyle Luu
 * @version October 25, 2017
 */
public class NumberGuessI
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Guess a number between 1 and 1,000,000, inclusive: ");
        String input = in.next();

        int guess;
        int numberOfGuesses = 0;
        int realNumber = (int) (Math.random() * 1000000) + 1;
        boolean stopper = true;
        //System.out.println(realNumber);
        while (stopper)
        {
            String firstCharacter = input.substring(0,1);
            //isolates the first character^

            if (firstCharacter.equals("Q"))
            {
                System.out.println("Game ends. The number was " + realNumber);

                //handles the singular/plural form of guesses.
                if (numberOfGuesses == 1)
                {
                    System.out.println("You've made 1 guess.");
                }
                else
                {
                    System.out.println("You've made " + numberOfGuesses + " guesses.");
                }

                stopper = false; //stops the program
            }
            else if ((firstCharacter.compareTo("9") > 0) || (firstCharacter.compareTo("0")<0))
            {   //detects if input is a number^
                System.out.print("Guess a NUMBER: ");
                input = in.next();
            }
            else
            {
                guess = Integer.parseInt(input);
                //turns the guess from String into int^
                
                if (guess > realNumber)
                {
                    System.out.print("Guess lower than " + guess + ": ");
                    input = in.next();
                    numberOfGuesses++;
                }
                else if (guess < realNumber)
                {
                    System.out.print("Guess higher than " + guess + ": ");
                    input = in.next();
                    numberOfGuesses++;
                }
                else
                {
                    System.out.println("You got it! The number is: " + realNumber + ".");

                    if (numberOfGuesses == 1)
                    {
                        System.out.println("You've made 1 guess!");
                    }
                    else
                    {
                        System.out.println("You've made " + numberOfGuesses + " guesses!");
                    }

                    stopper = false; //stops the program.
                }
            }
        }
    }
}
