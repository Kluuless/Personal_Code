/**
 * Fruit
 * 
 * @author Mr. Funk 
 * @version October 1, 2007
 */
public class Fruit implements Comparable<Fruit>
{
    private String variety;
    private double weight;//not a calculator (no need for EPSILON)

    public Fruit(String variety, double weight)
    {
        this.variety = variety;
        this.weight = weight;
    } 

    public double getWeight()
    {
        return weight;
    }

    public String getVariety()
    {
        return variety;
    }

    public int compareTo(Fruit myFruit)
    {
        double otherWeight = 0.0;

        if(myFruit instanceof Fruit) 
        {
            if (this.weight < ((Fruit)myFruit).getWeight())
            {
                return -1;
            }
            else if(this.weight > ((Fruit)myFruit).getWeight())
            {
                return 1;
            }
        }
        return 0;
    }   

    public String toString()
    {
        return variety + " weighing " + weight;
    }
}
