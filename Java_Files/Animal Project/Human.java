import java.util.ArrayList;
/**
 * Human, has pets (maybe), and is species human
 * 
 * @author Kyle Luu and Daniel Maloney
 * @version 1.0
 */
public class Human extends Animal
{
    /** ~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~ */
    private String name;
    private ArrayList<Pet> pets;
    private int age; //in years

    /** ~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~ */
    public Human()
    {
        super("Human", 120); //is a human that weighs 120lbs
        name = "Daniel Bologna";
        pets = new ArrayList<Pet>();
        age = 18;
    }

    public Human(double weight, String name, int age)
    {
        super("Human", weight);
        this.name = name;
        this.age = age;
        pets = new ArrayList<Pet>();
    }

    /** ~~~~~~~~~~ ACCESSOR METHODS ~~~~~~~~~~ */
    public String getName() 
    { 
        return name; 
    }

    public ArrayList<Pet> getPets() 
    { 
        return pets; 
    }

    public Pet getSpecificPet(int i)
    {
        return pets.get(i);
    }

    public int getAge()
    { 
        return age; 
    }

    /** ~~~~~~~~~~ MUTATOR METHODS ~~~~~~~~~~ */
    public boolean addPet(Pet pet) 
    { 
        if (pet.getOwner() == null)
        {
            pets.add(pet); 
            pet.setOwner(this);
            return true;
        }
        return false;
    }

    public boolean removePet(Pet pet) 
    { 
        boolean result = pets.remove(pet); 
        if (result = true)
        {
            pet.setOwner(null);
        }
        return result;
    }

    public void age(int years) 
    { 
        age += years; 
        for (int i = 0; i < pets.size(); i++)
        {
            pets.get(i).age(years);
        }
    }

    /**
     * @return  true if the objects are the same
     * 
     * @param   any object
     */
    public boolean equals(Object obj)
    {
        if (obj instanceof Human)
        {
            Human other = (Human)obj;
            if (super.equals(other) && this.name.equals(other.getName()))
            {
                if (this.pets.equals(other.getPets()) && this.age == other.getAge())
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return the string representation of the human
     */
    public String toString()
    {
        String petString = "";
        for (int i = 0; i < pets.size(); i++)
        {
            petString += ", " + pets.get(i).getName();
        }
        petString = petString.substring(2);
        return super.toString() + "\nName: " + name + "\nAge: " + age + "\nPets: " + petString;
    }
}
