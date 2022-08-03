import java.util.Scanner;
import java.util.ArrayList;
/**
 * Hangman Game
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Hangman
{
    private String word;
    
    public Hangman()
    {
        word = "JAZZ";
    }
    
    public Hangman(String theWord)
    {
        word = theWord.toUpperCase();
    }
    
    public String getWord()
    {
        return word;
    }
    
    public void display(ArrayList<Integer> revealed)
    {
        String result = "";
        for (int i = 0; i < word.length(); i++)
        {
            if (revealed.contains(i))
            {
                result += word.charAt(i);
            }
            else
            {
                result += "_";
            }
        }
        System.out.println(result);
    }
    
    public ArrayList<Integer> contains(String letter)
    {
        if (word.indexOf(letter) == -1)
        {
            return null;
        }
        else
        {
            ArrayList<Integer> correct = new ArrayList<Integer>();
            for (int i = 0; i < word.length(); i++)
            {
                if ((word.charAt(i) + "").equals(letter))
                {
                    correct.add(i);
                }
            }
            return correct;
        }
    }
    
    public void game()
    {
        game(5);
    }
    
    public void game(int guesses)
    {
        ArrayList<Integer> correct = new ArrayList<Integer>();
        ArrayList<String> guessed = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        boolean hasWon = false;
        
        display(correct);
        
        while (guesses > 0 && !hasWon)
        {
            if (correct.size() == word.length())
            {
                hasWon = true;
                System.out.println("You won! The word was: " + getWord().toLowerCase() + "!");
            }
            else
            {
                System.out.println("You have " + guesses + " guesses remaining.");
                System.out.print("Guess a letter: ");
                String attempt = in.next();
                attempt = attempt.toUpperCase();
                ArrayList<Integer> locations = contains(attempt);
                if (attempt.length() != 1)
                {
                    System.out.println("Please guess one letter at a time. Try again.");
                }
                else if (Utilities.stringListContains(attempt, guessed))
                {
                    System.out.println("You already guessed " + attempt + ". Try again.");
                }
                else if (locations == null)
                {
                    guessed.add(attempt);
                    System.out.println("Incorrect. " + attempt + " is not one of the letters.");
                    guesses--;
                    display(correct);
                }
                else
                {
                    guessed.add(attempt);
                    System.out.println("Correct!");
                    for (int j = 0; j < locations.size(); j++)
                    {
                        correct.add(locations.get(j));
                    }
                    display(correct);
                }
            }
            System.out.println();
        }
        if (guesses == 0)
        {
            System.out.println("Sorry, you lost! The word was: " + getWord().toLowerCase() + ".");
        }
    }
}
