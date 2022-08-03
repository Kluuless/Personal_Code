/**
 * Orange - a citrus fruit
 * 
 * @author Mr. Funk 
 * @version October 1, 2007
 */
public class Orange extends Fruit
{
    private double acidity;

    /**
     * Constructor for objects of class Orange
     */
    public Orange (String variety, double weight, double acidity)
    {
        super(variety, weight);
        this.acidity = acidity;
    }  

    public String toString()
    {
        return "Orange: " + super.toString() + ", acidity " + acidity;
    }    

    public boolean equals(Object obj)
    {
        if (obj instanceof Orange)
        {
            Orange other = (Orange)obj;
            if (other.getWeight() == this.getWeight() && other.getVariety() == this.getVariety())
            {
                if (other.acidity == this.acidity)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
