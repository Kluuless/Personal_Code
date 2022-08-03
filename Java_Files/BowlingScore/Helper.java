
/**
 * Write a description of class Helper here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Helper
{
    public static void main(String[] args)
    {
        String [] game5 = {"X","3/","61","X","X","X","2/","90","7/","XXX"};
        BowlingScore bowlingGame5 = new BowlingScore("Greg", game5);
        bowlingGame5.print();
    }
}
