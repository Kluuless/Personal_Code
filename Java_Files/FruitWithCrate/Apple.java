/**
 * Apple - an fruit
 * 
 * @author Mr. Funk 
 * @version October 1, 2007
 */
public class Apple extends Fruit
{
    /**
     * Constructor for objects of class Apple
     */
    public Apple(String variety, double weight)
    {
        super(variety, weight);
    }

    public String toString()
    {
        return "Apple: " + super.toString();
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Apple)
        {
            Apple other = (Apple)obj;
            if (other.getWeight() == this.getWeight() && other.getVariety() == this.getVariety())
            {
                return true;
            }
        }
        return false;
    }
}
