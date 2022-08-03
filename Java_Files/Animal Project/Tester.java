import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests classes Animal, FarmAnimal, Human, and Pet
 *
 * @author  Kyle Luu
 * @version 1.0
 */
public class Tester
{
    /**
     * Default constructor for test class Tester
     */
    public Tester()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void TestAnimal() //tests toString(), compareTo(), and equals()
    {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        
        assertEquals(true, animal1.equals(animal2));
        assertEquals(0, animal1.compareTo(animal2));
        assertEquals("Species: Dog\nWeight: 15.0", animal1.toString());
        
        Animal animal3 = new Animal("Dog", 20);
        assertEquals(false, animal3.equals(animal1));
        assertEquals(1, animal3.compareTo(animal1));
        Animal animal4 = new Animal("Cat", 15);
        assertEquals(false, animal4.equals(animal1));
        assertEquals(0, animal4.compareTo(animal1));
        assertEquals(-1, animal4.compareTo(animal3));
    }
    
    @Test 
    public void TestPet()
    {
        Human owner1 = new Human(120, "Bob", 32);
        Human owner2 = new Human(130, "Joe", 48);
        
        Pet pet1 = new Pet("Dog", 16, "Mr. Peanutbutter", owner1, 4);
        Pet pet2 = new Pet("Dog", 16, "Mr. Peanutbutter", null, 4);
        Pet pet3 = new Pet("Cat", 9, "Ms. Jelly", null, 6);
        //test equals()
        assertEquals(true, pet1.getName().equals("Mr. Peanutbutter"));
        assertEquals(true, pet2.getName().equals("Mr. Peanutbutter"));
        assertEquals(false, pet3.getName().equals("Fido"));
        //test getOwner()
        assertEquals(true, pet1.getOwner().equals(owner1));
        assertEquals(true, pet2.getOwner() == null);
        assertEquals(true, pet3.getOwner() == null);
        pet3.setOwner(owner2);
        assertEquals(true, pet3.getOwner().equals(owner2));
        assertEquals(false, pet1.getOwner().equals(pet2.getOwner()));
        //test getAge()
        assertEquals(true, pet1.getAge() == 4);
        assertEquals(false, pet2.getAge() == 3);
        assertEquals(true, pet3.getAge() == 6);
        //test isHungry()
        assertEquals(false, pet1.isHungry());
        assertEquals(false, pet2.isHungry());
        assertEquals(true, !(pet3.isHungry()));
        //test daysSinceFed()
        assertEquals(0, pet3.daysSinceFed());
        assertEquals(0, pet3.daysSinceFed());
        pet3.nextDay();
        pet3.nextDay();
        pet3.nextDay();
        pet3.nextDay();
        assertEquals(true, pet3.isHungry());
        assertEquals(4, pet3.daysSinceFed());
        assertEquals(11, (int)pet3.getWeight());
        pet3.feed();
        assertEquals(false, pet3.isHungry());
        assertEquals(0, pet3.daysSinceFed());
        //test equals()
        assertEquals(false, pet1.equals(pet2));
        pet2.setOwner(owner1);
        assertEquals(true, pet1.equals(pet2));
        assertEquals(false, pet2.equals(pet3));
        //test toString()
        assertEquals("Species: Cat\nWeight: 11.0\nName: Ms. Jelly\nAge: 6\nOwned by: Joe", pet3.toString());
    }
    
    @Test
    public void TestHuman()
    {
        Human owner1 = new Human(120, "Bob", 32);
        Human owner2 = new Human(130, "Joe", 48);
        Human owner3 = new Human(120, "Bob", 32);
        
        Pet pet1 = new Pet("Dog", 16, "Mr. Peanutbutter", null, 4);
        Pet pet2 = new Pet("Cat", 9, "Ms. Jelly", null, 6);
        //test getName()
        assertEquals(true, owner1.getName().equals("Bob"));
        assertEquals(true, owner2.getName().equals("Joe"));
        assertEquals(false, owner3.getName().equals("Joe"));
        //test getPets(), addPet(Pet pet), and removePet(Pet pet)
        ArrayList<Pet> emptyList = new ArrayList<Pet>();
        assertEquals(emptyList, owner1.getPets());
        assertEquals(emptyList, owner2.getPets());
        assertEquals(emptyList, owner3.getPets());
        owner2.addPet(pet1);
        owner2.addPet(pet2);
        ArrayList<Pet> list1 = new ArrayList<Pet>();
        list1.add(pet1);
        list1.add(pet2);
        assertEquals(list1, owner2.getPets());
        list1.remove(pet1);
        owner2.removePet(pet1);
        assertEquals(list1, owner2.getPets());
        //test age(int years)
        owner2.age(1);
        assertEquals(49, owner2.getAge());
        assertEquals(7, owner2.getSpecificPet(0).getAge());
        //test equals()
        assertEquals(true, owner1.equals(owner3));
        assertEquals(false, owner1.equals(owner2));
        owner1.addPet(pet1);
        assertEquals(false, owner1.equals(owner3));
        //test toString()
        assertEquals("Species: Human\nWeight: 120.0\nName: Bob\nAge: 32\nPets: Mr. Peanutbutter", owner1.toString());
    }

    @Test
    public void TestFarmAnimal()
    {
        Human human1 = new Human(120, "Bob", 32);
        Human human2 = new Human(130, "Joe", 46);
        
        FarmAnimal farmAnim1 = new FarmAnimal("Cow", 302, human1);
        FarmAnimal farmAnim2 = new FarmAnimal("Cow", 302, null);
        FarmAnimal farmAnim3 = new FarmAnimal("Pig", 150, null);
        //test getOwner()
        assertEquals(human1, farmAnim1.getOwner());
        assertEquals(null, farmAnim2.getOwner());
        assertEquals(null, farmAnim3.getOwner());
        farmAnim3.setOwner(human2);
        assertEquals(human2, farmAnim3.getOwner());
        //test getWeight(), feed(), and nextDay()
        farmAnim3.nextDay();
        farmAnim3.nextDay();
        farmAnim3.nextDay();
        farmAnim3.nextDay();
        assertEquals(125.0, farmAnim3.getWeight(), 0.1);
        farmAnim3.feed();
        farmAnim3.nextDay();
        assertEquals(130, farmAnim3.getWeight(), 0.1);
        //test equals()
        assertEquals(false, farmAnim3.equals(farmAnim2));
        assertEquals(false, farmAnim1.equals(farmAnim2));
        farmAnim1.setOwner(null);
        assertEquals(true, farmAnim1.equals(farmAnim2));
        farmAnim1.setOwner(human1);
        farmAnim2.setOwner(human1);
        assertEquals(true, farmAnim2.equals(farmAnim1));
        //test toString()
        assertEquals("Species: Cow\nWeight: 302.0\nOwned by: Bob", farmAnim1.toString());
    }
}


