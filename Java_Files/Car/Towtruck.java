
/**
 * Adds a car that can be towing another car.
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Towtruck extends Car
{
    Car towing;

    public Towtruck(double myEfficiency)
    {
        super(myEfficiency);
        towing = null;
    }

    /**
     * @return  true if car can be towed, false if towtruck is already occupied
     */
    public boolean tow(Car car)
    {
        if (towing == null)
        {
            towing = car;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * @return  the released car, or null if towtruck was empty
     */
    public Car release()
    {
        if (towing != null)
        {
            Car released = towing;
            towing = null;
            return released;
        }
        else
        {
            return null;
        }
    }
    
    public boolean isTowing()
    {
        if (towing == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public Car getVehicle()
    {
        return towing;
    }
    
    public String toString()
    {
        String result = super.toString() + ", is towing ";
        if (isTowing())
        {
            result += towing;
        }
        else
        {
            result += "nothing";
        }
        return result;
    }
}
