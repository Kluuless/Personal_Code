
/**
 * Generic Animal
 * 
 * @author Daniel Maloney
 * @version 1.0
 */
public class Animal implements Comparable<Animal>
{
    /** ~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~ */
    private String species;
    private double weight;

    /** ~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~ */
    public Animal()
    {
        species = "Dog";
        weight = 15.0;
    }

    public Animal(String species, double weight)
    {
        this.species = species;
        this.weight = weight;

    }

    /** ~~~~~~~~~~ ACCESSOR METHODS ~~~~~~~~~~ */
    public double getWeight()
    {
        return weight;   
    }

    public String getSpecies()
    {
        return species;   
    }

    /** ~~~~~~~~~~ MUTATOR METHODS ~~~~~~~~~~ */
    public void loseWeight()
    {
        this.weight--;   
    }

    public void gainWeight()
    {
        this.weight++;   
    }

    public void loseWeight(int amount)
    {
        this.weight -= amount;   
    }

    public void gainWeight(int amount)
    {
        this.weight += amount;   
    }

    /**
     * @return  the String representation of the animal
     */
    public String toString()
    {
        return "Species: " + species + "\nWeight: " + weight;
    }

    /**
     * @return  true if the object's weight is the same as the other
     * 
     * @param   any object
     */
    public boolean equals(Object obj)
    {
        if(obj instanceof Animal && ((Animal)obj).species.equals(this.species) && 
        ((Animal)obj).weight == this.weight)
        {
            return true;
        }
        return false;
    }

    /**
     * @return -1 if weighs less than the other
     * @return 0 if weighs the same as the other
     * @return 1 if weighs more than the other
     */
    public int compareTo(Animal a)
    {        
        if(this.weight == a.weight)
        {
            return 0;
        }
        else if(this.weight > a.weight)
        {
            return 1;
        }
        else
        {
            return -1;
        }       
    }
}
