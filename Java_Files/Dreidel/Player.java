
/**
 * Player of a Dreidell game - Do not change this class
 *
 * @author Mr. Funk
 * @version 1.0
 */
public class Player
{
    private String name;
    private int gelt; //gelt is the amount of pieces the player has
    
    /**
     * Counstructor for objects of class Player
     */
    public Player(String name, int initialNumberOfPieces)
    {
        this.name = name;
        gelt = initialNumberOfPieces;
    }
    
    public void add(int count)
    {
        gelt += count;
    }
    
    
    public int shtel()
    {
        if(! isOut())
        {
            gelt--;
            return 1;
        }
        return 0;
    }
    
    public boolean isOut()
    {
        return (gelt == 0);
    }
    
    public String toString()
    {
        return name + ": " + gelt;
    }
}
