import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BowlingTester.
 *
 * @author Messers. Bushell and Funk
 * @version 1.0
 */
public class BowlingUnitTestVersion1
{
    /**
     * Default constructor for test class BowlingTester
     */
    public BowlingUnitTestVersion1()
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
    public void testValidGame1()
    {
        String [] game1 = {"X","7/","72","9/","X","X","X","23","6/","7/3"}; //valid game

        BowlingScore bowlingGame1 = new BowlingScore("Greg",game1);
        assertEquals(168,bowlingGame1.getScore());
    }

    @Test
    public void testValidGame2()
    {
        String [] game2 = {"X","7/","9-","X","-8","8/","06","X","X","X81"}; //valid game

        BowlingScore bowlingGame2 = new BowlingScore("Greg",game2);
        assertEquals(167,bowlingGame2.getScore());    
    }

    @Test
    public void testValidGame3()
    {
        String [] validGame = {"X","X","X","X","X","X","X","X","X","XXX"};

        BowlingScore bowlingGame3 = new BowlingScore("Greg",validGame);
        assertEquals(300,bowlingGame3.getScore());

    }

    @Test
    public void testValidGame4()
    {
        String [] validGame = {"--","--","--","--","--","--","--","--","--","--"};

        BowlingScore bowlingGame4 = new BowlingScore("Greg",validGame);
        assertEquals(0,bowlingGame4.getScore());

    }
    
    @Test
    public void testValidGame5()
    {
        String [] validGame = {"14","7/","X","X","72","-8","45","--",null,null};

        BowlingScore bowlingGame5 = new BowlingScore("Mr. Funk",validGame);
        assertEquals(-1,bowlingGame5.getScore());
        assertEquals(9,bowlingGame5.getOpenFrame());
        assertEquals(true,bowlingGame5.addFrame("3","5"));
        assertEquals(10,bowlingGame5.getOpenFrame());        
        assertEquals(-1,bowlingGame5.getScore());
        assertEquals(true,bowlingGame5.addFrame("3","/","X")); 
        assertEquals(125,bowlingGame5.getScore());
        assertEquals(-1,bowlingGame5.getOpenFrame());          
        assertEquals(false,bowlingGame5.addFrame("4","5")); 

    }    
}
