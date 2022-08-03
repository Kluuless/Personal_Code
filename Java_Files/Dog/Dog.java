/**
 * Dog - represents a dog
 * 
 * @author Mr. Funk
 * @version Aug 28, 2015
 */
public class Dog
{
    // instance variables - the data the Dog requires
    private String name;
    private int age;

    /**
     * Constructor for objects of class Dog
     */
    //Default Constructor (no parameters)
    public Dog()
    {
        // initialize instance variables
        // reserve memory for the Dog object
        name = "Fido";
        age = 4;
    }

    //parameterized constructor
    public Dog(String myName, int myAge)
    {
        // initialize instance variables
        // reserve memory for the Dog object
        name = myName;
        age = myAge;
    }
    
    /**
     * Accessors for objects of class Dog
     */    
    public String getName()
    {
        return name;
    }
    
    public int getAge()
    {
        return age;
    }    
    
    public String toString()
    {
        return "Dog: name = " + name + ", age = " + age;
    }
    
    /**
     * Mutators for objects of class Dog
     */    
    public void setName(String myName)
    {
        name = myName;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }        
    
    public void older()
    {
        //age = age + 1;
        age++;
    }
}
