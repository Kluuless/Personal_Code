import java.util.ArrayList;
/**
 * Represents a Bowling Scorecard
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class BowlingScore
{
    ArrayList<String> playerNames;
    Frame[][] scorecard;
    
    public BowlingScore(ArrayList<String> names)
    {
        playerNames = names;
        scorecard = new Frame[playerNames.size()][10];
        for (int i = 0; i < scorecard.length; i++)
        {
            for (int j = 0; j < scorecard[i].length; j++)
            {
                if (j < 9)
                {
                    scorecard[i][j] = new Frame("","", j + 1);
                }
                else
                {
                    scorecard[i][j] = new Frame("","","");
                }
            }
        }
    }
    
    public int getScore(String player)
    {
    
    }
    
    /**
     * for use with frames 1-9
     */
    public int setScore(String player, int frameNumber, String box1, String box2)
    {
    
    }
    
    /**
     * for use with tenth frame
     */
    public int setScore(String player, int frameNumber, String box1, String box2, String box3)
    {
        
    }
    
    public String getCurrentWinner()
    {
        
    }
}
