
/**
 * Subclass of Car: simulates a Limo
 * 
 * @author Kyle Luu
 * @version 1.0
 */
public class Limo extends Car
{
    public String driver;
    
    public Limo(String theDriver, double theEfficiency)
    {
        super(theEfficiency);
        driver = theDriver;
    }
    
    public boolean equals(Object obj)
    {
        if (obj instanceof Limo)
        {
            return super.equals(obj);
        }
        return false;
    }
    
    public String toString()
    {
        return super.toString() + ", driver: " + driver;
    }
}
