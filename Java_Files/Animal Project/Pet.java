
/**
 * Pet, owned by human, needs to be fed
 * 
 * @author Kyle Luu and Daniel Bologna
 * @version 1.0
 */
public class Pet extends Animal implements Ownable
{
    /** ~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~ */
    private String name;
    private Human owner;
    private int age;
    private boolean isHungry;
    private int daysSinceFed;

    /** ~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~ */
    public Pet()
    {
        super("Parrot", 25);
        name = "Squawk";
        owner = null;
        age = 4;
        isHungry = false;
        daysSinceFed = 0;
    }

    public Pet(String species, double weight, String name, Human owner, int age)
    {
        super(species,weight);
        this.name = name;
        this.owner = owner;
        this.age = age;
        daysSinceFed = 0;
    }

    /** ~~~~~~~~~~ ACCESSOR METHODS ~~~~~~~~~~ */
    public String getName()
    { 
        return name; 
    }

    public Human getOwner()
    { 
        return owner; 
    }

    public int getAge() 
    { 
        return age; 
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
    public void setOwner(Human theOwner) 
    { 
        this.owner = theOwner; 
    } 

    public void feed() 
    {
        isHungry = false; 
        daysSinceFed = 0; 
    }
    
    public void age(int years)
    {
        age += years;
    }

    /**
     * nextDay() - if it is hungry, it loses weight. if it is full, it gains weight.
     * If it has been 3 days since it was last fed, it is hungry
     */
    public void nextDay() 
    {  
        if(isHungry)
        {
            super.loseWeight();   
        }else{
            super.gainWeight();
        }
        daysSinceFed++; 
        if (daysSinceFed >= 3) 
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
        if (obj instanceof Pet)
        {
            Pet other = (Pet)obj;
            if ((this.owner == null && other.getOwner() != null) || (this.owner != null && other.getOwner() == null))
            {
                return false;
            }
            else if (super.equals(other) && this.name.equals(other.getName()))
            {
                if (this.owner.equals(other.getOwner())  || this.owner == null && other.getOwner() == null&& this.age == other.getAge())
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return the String representation of the Pet object
     */
    public String toString()
    {
        return super.toString() + "\nName: " + this.getName() + "\nAge: " + this.getAge() + "\nOwned by: " + this.owner.getName();   
    }
}
