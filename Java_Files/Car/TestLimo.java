import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestLimo.
 *
 * @author  Mr. Funk
 * @version 1.0
 */
public class TestLimo
{
    /**
     * Default constructor for test class TestLimo
     */
    public TestLimo()
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
    public void TestLimo1()
    {
        Car car1 = new Car(45);
        Limo limo1 = new Limo("Ed", 12);
        assertEquals(false, limo1.equals(car1));
        Limo limo2 = new Limo("May", 45);
        assertEquals(true, car1.equals(limo2));
        assertEquals(false, limo2.equals(car1));
    }
    
    @Test
    public void TestToString()
    {
        Car car1 = new Car(45);
        Limo limo1 = new Limo("Ed", 12);
        assertEquals("car w/ 12.0 mpg, 0.0 gallons of fuel, 0.0 miles, driver: Ed", limo1.toString());
        assertEquals("car w/ 45.0 mpg, 0.0 gallons of fuel, 0.0 miles", car1.toString());
        Car car2 = new Car(40);
        car2.addGas(30);
        car2.drive(11);
        car2.drive(20);
        assertEquals("car w/ 40.0 mpg, 29.225 gallons of fuel, 31.0 miles", car2.toString());        
    }

    @Test
    public void TestLimoEquals()
    {
        Limo limo3 = new Limo("Ed", 12);
        Limo limo4 = new Limo("May", 12);
        Car car1 = new Car(12);
        Limo limo5 = new Limo("Mona", 15);
        assertEquals(false, limo4.equals(limo5));
        assertEquals(false, limo4.equals(car1));
        assertEquals(true, limo4.equals(limo3));
        assertEquals(true, car1.equals(limo3));
        assertEquals(true, car1.equals(limo4));
    }

    @Test
    public void TestTowTruck()
    {
        Towtruck towtruck1 = new Towtruck(12.5);
        assertEquals(false, towtruck1.isTowing());
        Car car1 = new Car(40);
        assertEquals(null, towtruck1.getVehicle());
        towtruck1.tow(car1);
        assertEquals(true, towtruck1.isTowing());
        assertEquals(car1, towtruck1.getVehicle());
        assertEquals(car1, towtruck1.release());
        assertEquals(false, towtruck1.isTowing());        
        Limo limo1 = new Limo("Ed", 15);
        towtruck1.tow(limo1);
        assertEquals(limo1, towtruck1.getVehicle());
    }
}
