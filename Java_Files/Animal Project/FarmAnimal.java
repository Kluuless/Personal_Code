
/**
 * Ownable, but don't have names
 * 
 * @author Daniel Maloney
 * @version 1.0
 */
public class FarmAnimal extends Animal implements Ownable
{
    /** ~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~ */
    private Human owner;
    private boolean isHungry;
    private int daysSinceFed;

    /** ~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~ */
    public FarmAnimal()
    {
        super("Cow", 250);
        owner = null;
        isHungry = false;
        daysSinceFed = 0;
    }

    public FarmAnimal(String species, double weight, Human owner)
    {
        super(species, weight);
        this.owner = owner;
        isHungry = false;
        daysSinceFed = 0;
    }

    /** ~~~~~~~~~~ ACCESSOR METHODS ~~~~~~~~~~ */
    public Human getOwner()
    {
        return owner;
    }

    public boolean isHungry()
    {
        return isHungry;
    }

    public int daysSinceFed()
    {
        return daysSinceFed;
    }

    /** ~~~~~~~~~~ MUTATOR METHODS ~~~~~~~~~~ */
    public void feed()
    {
        daysSinceFed = 0;
        isHungry = false;
    }

    public void setOwner(Human h)
    {
        owner = h;
    }

    /**
     * nextDay() - if it is hungry, it loses weight. if it is full, it gains weight.
     * If it has been 3 days since it was last fed, it is hungry
     */
    public void nextDay()
    {
        if(isHungry)
        {
            super.loseWeight(10);   
        }
        else
        {
            super.gainWeight(5);   
        }
        daysSinceFed++;
        if(daysSinceFed >= 1)
        {
            isHungry = true;
        }
    }

    /**
     * @return  true if the objects are the same
     * 
     * @param   any object
     */
    public boolean equals(Object obj)
    {
        if (obj instanceof FarmAnimal)
        {
            FarmAnimal other = (FarmAnimal)obj;
            
            if ((this.owner == null && other.getOwner() != null) || (this.owner != null && other.getOwner() == null))
            {
                return false;
            }
            else if (super.equals(other) && this.owner.equals(other.getOwner()) || this.owner == null && other.getOwner() == null)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * @return  the String representation of the Farm Animal
     */
    public String toString()
    {
        return super.toString() + "\nOwned by: " + owner.getName();    
    }
}
