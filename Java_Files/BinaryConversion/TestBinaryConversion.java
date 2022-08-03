import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestBinaryConversion.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestBinaryConversion
{
    /**
     * Default constructor for test class TestBinaryConversion
     */
    public TestBinaryConversion()
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
    public void Test1()
    {
        BinaryConversion binaryCo1 = new BinaryConversion(34);
        assertEquals("34 in base 10", binaryCo1.toString());
        assertEquals(false, binaryCo1.toBase10());
        assertEquals(true, binaryCo1.toBase2());
        assertEquals("100010 in base 2", binaryCo1.toString());
        assertEquals(false, binaryCo1.toBase2());
        assertEquals(false, binaryCo1.toBase2());
        assertEquals(true, binaryCo1.toBase10());
        assertEquals("34 in base 10", binaryCo1.toString());
        assertEquals(false, binaryCo1.toBase10());
        assertEquals(false, binaryCo1.toBase10());
    }
    @Test    
    public void Test2()
    {
        BinaryConversion binaryCo2 = new BinaryConversion(1);
        assertEquals("1 in base 10", binaryCo2.toString());
        assertEquals(true, binaryCo2.toBase2());
        assertEquals("1 in base 2", binaryCo2.toString());
    }
    @Test    
    public void Test3()
    {
        BinaryConversion binaryCo3 = new BinaryConversion(0);
        assertEquals("0 in base 10", binaryCo3.toString());
        assertEquals(true, binaryCo3.toBase2());
        assertEquals("0 in base 2", binaryCo3.toString());
    }    

    @Test
    public void test4()
    {
        BinaryConversion binaryCo2 = new BinaryConversion(1049);
        assertEquals("1049 in base 10", binaryCo2.toString());
        //System.out.println(binaryCo2);
        // binaryCo2.toBase2();
        assertEquals(true, binaryCo2.toBase2());
        System.out.println(binaryCo2);
        assertEquals("10000011001 in base 2", binaryCo2.toString());
        //System.out.println("b");
        assertEquals(true, binaryCo2.toBase10());
        assertEquals("1049 in base 10", binaryCo2.toString());
    }

    @Test
    public void Test5()
    {
        BinaryConversion binaryCo1 = new BinaryConversion(957);
        assertEquals(false, binaryCo1.toBase10());
        assertEquals("957 in base 10", binaryCo1.toString());
        assertEquals(true, binaryCo1.toBase2());
        System.out.println(binaryCo1.toString());
        assertEquals("1110111101 in base 2", binaryCo1.toString());
        assertEquals(false, binaryCo1.toBase2());
        assertEquals(true, binaryCo1.toBase10());
        assertEquals("957 in base 10", binaryCo1.toString());
        assertEquals(false, binaryCo1.toBase10());
        assertEquals(true, binaryCo1.toBase2());
        assertEquals(true, binaryCo1.toBase10());
        assertEquals(true, binaryCo1.toBase2());
        assertEquals("1110111101 in base 2", binaryCo1.toString());
    }
}
