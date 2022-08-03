
/**
 * A door - can have either a sheep or a car behind it
 *
 * @author Kyle Luu
 * @version Xmas 2017
 */
public class Door
{
    // instance variables - replace the example below with your own
    private String behind;
    private boolean chosen;

    /**
     * Constructor for objects of class Door
     */
    public Door()
    {
        int rand = (int)(Math.random() * 3);
        if (rand == 0)
        {
            behind = "car";
        }
        else
        {
            behind = "sheep";
        }
        
        chosen = false;
    }
    
    public Door (String object)
    {
        behind = object;
        chosen = false;
    }

    /**
     * Methods
     */    

    public String getBehind()
    {
        return behind;
    }    
    
    public boolean isChosen()
    {
        return chosen;
    }
    
    public void setBehind(String object)
    {
        behind = object;
    }
    
    public String reveal()
    {
        if (behind.equals("car"))
        {
            return "";
        }
        else 
        {
            return "sheep";
        }
    }
    
    public void changeBehind()
    {
        if (behind.equals("car"))
        {
            behind = "sheep";
        }
        else
        {
            behind = "car";
        }
    }
    
    public boolean choose()
    {
        if (chosen == false)
        {
            chosen = true;
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public boolean unchoose()
    {
        if (chosen == true)
        {
            chosen = false;
            return true;
        }
        else
        {
            return false;
        }
    }
}
