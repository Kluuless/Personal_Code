

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FilmTest.
 *
 * @author  Bushell
 * @version 1.0
 */
public class FilmTest
{
    /**
     * Default constructor for test class FilmTest
     */
    public FilmTest()
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
    public void testFilmConstructorAndGetters()
    {
        Film f1 = new Film(1986,"Top Gun");
        assertEquals(1986,f1.getYear());
        assertTrue(f1.getTitle().equals("Top Gun"));
    }
    
    @Test
    public void testFilmToString()
    {
        Film f1 = new Film(2015, "Star Wars: The Force Awakens");
        assertEquals("2015\tStar Wars: The Force Awakens",f1.toString());
    }
    
    @Test
    public void testCompare()
    {
        Film f1 = new Film(2013, "Frozen");
        Film f2 = new Film(2007, "Juno");
       
        Film.compareByYear();
        assertTrue(Film.compareByYear);
        assertEquals(6,f1.compareTo(f2));
        assertEquals(-6,f2.compareTo(f1));
        
        Film.compareByTitle();
        assertFalse(Film.compareByYear);
        assertEquals(-4,f1.compareTo(f2));
        assertEquals(4,f2.compareTo(f1));
        
    }
    
    @Test
    public void testTitleContainsTheWord()
    {
        Film f1 = new Film(1999,"The Sixth Sense");
        Film f2 = new Film(1990, "The Hunt for Red October");
        Film f3 = new Film(1992, "Aladdin");
          
        assertTrue(f1.titleContainsTheWord("The"));
        assertTrue(f1.titleContainsTheWord("Sixth"));
        assertTrue(f1.titleContainsTheWord("Sense"));
        assertFalse(f1.titleContainsTheWord("Great"));
        
        assertTrue(f2.titleContainsTheWord("The"));
        assertTrue(f2.titleContainsTheWord("Red"));
        assertTrue(f2.titleContainsTheWord("October"));
        assertTrue(f2.titleContainsTheWord("Hunt"));
        assertFalse(f2.titleContainsTheWord("November"));
        
        assertTrue(f3.titleContainsTheWord("Aladdin"));
        assertFalse(f3.titleContainsTheWord("Cars"));       
    }
}
