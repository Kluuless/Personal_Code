
/**
 * Write a description of class HomeworkHelper here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HomeworkHelper
{
    public static void main(String[] args)
    {
        Animal spot = new Dog();
        System.out.println(spot.speak());
        
    }

    public static int countDuplicates(String word)
    {
        int duplicate = 0;
        for (int i = 1; i < word.length(); i++)
        {
            if (word.charAt(i) == word.charAt(i-1))
            {
                duplicate++;
            }
        }
        return duplicate;

    }
}
