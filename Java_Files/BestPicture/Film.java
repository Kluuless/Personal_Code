
/**
 * Represents a film
 * 
 * @author Kyle Luu
 * @version 1.0
 */
public class Film implements Comparable<Film>
{
    private int year;
    private String title;
    protected static boolean compareByYear = false;

    public Film(int year, String title)
    {
        this.year = year;
        this.title = title;
    }

    public int getYear()
    {
        return year;
    }

    public String getTitle()
    {
        return title;
    }

    public String toString()
    {
        return "" + year + "\t" + title;
    }

    public static void compareByYear()
    {
        compareByYear = true;
    }

    public static void compareByTitle()
    {
        compareByYear = false;
    }

    public int compareTo(Film other)
    {
        if (compareByYear)
        {
            return this.year - other.year;
        }
        else
        {
            return this.title.compareTo(other.title);
        }
    }
    
    public boolean titleContainsTheWord(String word)
    {
        return this.title.toUpperCase().indexOf(word.toUpperCase()) != -1;
    }
}
