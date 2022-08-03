import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BowlingTester.
 *
 * @author Bushell and Funk
 * @version 2.0
 */
public class BowlingUnitTestVersion2
{
    /**
     * Default constructor for test class BowlingTester
     */
    public BowlingUnitTestVersion2()
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
      
      assertTrue(bowlingGame1.isValidGame());
      assertEquals(168,bowlingGame1.getScore());
    }
    
    @Test
    public void testValidGame2()
    {
      String [] game2 = {"X","7/","9-","X","-8","8/","-6","X","X","X81"}; //valid game
      
      BowlingScore bowlingGame2 = new BowlingScore("Greg",game2);
      
      assertTrue(bowlingGame2.isValidGame());
      assertEquals(167,bowlingGame2.getScore());    
    }
    
    @Test
    public void testValidGame3()
    {
      String [] game3 = {"X","X","X","X","X","X","X","X","X","XXX"};
      
      BowlingScore bowlingGame3 = new BowlingScore("Greg",game3);
      
      assertTrue(bowlingGame3.isValidGame());
      assertEquals(300,bowlingGame3.getScore());
        
    }
    
    @Test
    public void testValidGame4()
    {
      String [] game4 = {"--","--","--","--","--","--","--","--","--","--"};
      
      BowlingScore bowlingGame4 = new BowlingScore("Greg",game4);
      
      assertTrue(bowlingGame4.isValidGame());
      assertEquals(0,bowlingGame4.getScore());
        
    }
    @Test
    public void testValidGame5()
    {
        String [] game5 = {"X","3/","61","X","X","X","2/","90","7/","XXX"};
        BowlingScore bowlingGame5 = new BowlingScore("Greg", game5);
        assertTrue(bowlingGame5.isValidGame());
        assertEquals(193,bowlingGame5.getScore());
        
    }
    
    @Test
    public void testValidGame6()
    {
        String [] game6 = {"3-","5/","X","--", null,null,null,null,null,null};
        BowlingScore bowlingGame6 = new BowlingScore("Greg", game6);
        assertTrue(bowlingGame6.isValidGame());
        assertEquals(-1,bowlingGame6.getScore());
    }
    
    @Test
    public void testInvalidGame1()
    {
        String [] inValidGame1 = {"X","/3","3-","X","61","X","3/","X","2/","72"};
        BowlingScore bowlingGame1 = new BowlingScore("Greg",inValidGame1);
        assertFalse(bowlingGame1.isValidGame());
        /*
         *  frame 2 is invalid
         */
    }
    
    @Test
    public void testInvalidGame2()
    {
        String [] inValidGame2 = {"X","3/","3-","X5","62","X","3/","X","2/","72"};
        BowlingScore bowlingGame2 = new BowlingScore("Greg",inValidGame2);
        assertFalse(bowlingGame2.isValidGame());
        /*
         * frame 4 is invalid
         */
    }
    
    @Test
    public void testInvalidGame3()
    {
        String [] inValidGame3 = {"X","3/","3-","X","67","X","3/","X","2/","X52"};
        BowlingScore bowlingGame3 = new BowlingScore("Greg",inValidGame3);
        assertFalse(bowlingGame3.isValidGame());
        /*
         * frame 5 is invalid
         */
    }
    
    @Test
    public void testInvalidGame4()
    {
        String [] inValidGame4 = {"34","5/","6-","8","X","42","4/","17","32","X25"};
        BowlingScore bowlingGame4 = new BowlingScore("Greg",inValidGame4);
        assertFalse(bowlingGame4.isValidGame());
        /*
         * frame 4 is invalid
         */
    }
    
    @Test
    public void testInvalidGame5()
    {
        String [] inValidGame5 = {"34","5/","6-","82","X","42","4/","17","32","X25"};
        BowlingScore bowlingGame5 = new BowlingScore("Greg",inValidGame5);
        assertFalse(bowlingGame5.isValidGame());
        /*
         * frame 4 is invalid
         */
        
    }
    
    @Test
    public void testInvalidGame6()
    {
        String [] inValidGame6 = {"34","5/","6-","8/","X","42","4/","17","32","X/5"};
        BowlingScore bowlingGame6 = new BowlingScore("Greg",inValidGame6);
        assertFalse(bowlingGame6.isValidGame());
        /*
         * Frame 10 is invalid
         */
        
    }
    
    @Test
    public void testaddFrame()
    {
        BowlingScore bowlingGame1 = new BowlingScore("Greg");
        assertFalse(bowlingGame1.addFrame("X","3"));
        assertTrue(bowlingGame1.addFrame("X",""));
        assertFalse(bowlingGame1.addFrame("2","3","4"));
        assertTrue(bowlingGame1.addFrame("3","/"));
        assertTrue(bowlingGame1.addFrame("-","4"));
        assertTrue(bowlingGame1.addFrame("0","/"));
        assertFalse(bowlingGame1.addFrame("/","5"));
        assertFalse(bowlingGame1.addFrame("7","8"));
        assertTrue(bowlingGame1.addFrame("X",""));
        assertTrue(bowlingGame1.addFrame("6","/"));
        assertTrue(bowlingGame1.addFrame("-","5"));
        assertTrue(bowlingGame1.addFrame("6","-"));
        assertTrue(bowlingGame1.addFrame("X",""));
        assertFalse(bowlingGame1.addFrame("/","3","4"));
        assertTrue(bowlingGame1.addFrame("4","/","6"));
    }
    
    @Test
    public void testCompareTo()
    {
        String [] game1 = {"X","3/","61","X","X","X","2/","90","7/","XXX"}; //Score is 193
        String [] game2 = {"3/","X","32","X","X","7/","X","71","X","XXX"};  //Score is 193
        String [] game3 = {"5-","3/","X","52",null,null,null,null,null,null};
        String [] game4 = {"7/","X","8/","2-","X","6/",null,null,null,null};
        String [] game5 = {"8/","54","9-","X","X","5/","53","63","9/","9/X"}; //Score is 149
        String [] game6 = {"5-","3/","X","5X",null,null,null,null,null,null}; //not Valid
        
        BowlingScore bowlingGame1 = new BowlingScore("Greg", game1);
        BowlingScore bowlingGame2 = new BowlingScore("Greg", game2);  
        BowlingScore bowlingGame3 = new BowlingScore("Greg", game3);
        BowlingScore bowlingGame4 = new BowlingScore("Greg", game4);
        BowlingScore bowlingGame5 = new BowlingScore("Greg", game5);  
        BowlingScore bowlingGame6 = new BowlingScore("Mr. Funk", game1);
        BowlingScore bowlingGame7 = new BowlingScore("Mr. Funk", game1);  
        BowlingScore bowlingGame8 = new BowlingScore("Mr. Funk", game4);  
        BowlingScore bowlingGame9 = new BowlingScore("Mr. Funk", game4); 
        BowlingScore bowlingGame10 = new BowlingScore("Mr. Funk", game6); 
        BowlingScore bowlingGame11 = new BowlingScore("Mr. Funk", game6);  
        
        assertTrue(bowlingGame1.compareTo(bowlingGame2) == 0);     
        assertTrue(bowlingGame3.compareTo(bowlingGame4) < 0);
        assertTrue(bowlingGame5.compareTo(bowlingGame1) < 0);
        assertTrue(bowlingGame1.compareTo(bowlingGame5) > 0);
        // System.out.println(bowlingGame3.getOpenFrame() + "\t" + bowlingGame5.getOpenFrame());
        assertTrue(bowlingGame3.compareTo(bowlingGame5) < 0);
        assertTrue(bowlingGame5.compareTo(bowlingGame3) > 0);

        assertTrue(bowlingGame2.equals(bowlingGame2));
        assertTrue(bowlingGame3.equals(bowlingGame3));        
        assertTrue(bowlingGame6.equals(bowlingGame7));
        assertTrue(bowlingGame6.equals(bowlingGame6));
        assertTrue(bowlingGame8.equals(bowlingGame9));
        assertTrue(!(bowlingGame8.equals(bowlingGame4)));
        assertTrue(!(bowlingGame1.equals(bowlingGame2)));
        assertTrue(!(bowlingGame2.equals(bowlingGame1)));   
        assertTrue(!(bowlingGame1.equals(bowlingGame6)));
        assertTrue(!(bowlingGame6.equals(bowlingGame2)));
        assertTrue(!(bowlingGame6.equals(bowlingGame1)));
        assertTrue(!(bowlingGame3.equals(bowlingGame4)));   
        assertTrue(!(bowlingGame4.equals(bowlingGame3)));      
        assertTrue(bowlingGame10.equals(bowlingGame11));      //invalid games can be equal
        assertFalse(bowlingGame11.equals(bowlingGame3));      //invalid games can be equal    
        
        bowlingGame1.print();
        System.out.println();
        bowlingGame2.print();
        System.out.println();
        bowlingGame3.print();
        System.out.println();
        bowlingGame4.print();
        System.out.println();
        bowlingGame5.print();
        System.out.println();
        bowlingGame6.print();        
    }
}
