
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class FilmsTest.
 *
 * @author  Bushell
 * @version 1.0
 */
public class FilmsTest
{
    /**
     * Default constructor for test class FilmsTest
     */
    public FilmsTest()
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
    public void testConstructorAndGetter()
    {
        /**
         * This test requires that your Film toString() method to be working properly. 
         * Make sure you have tested it!
         */
        Films list1 = new Films("");
        assertEquals("1928\tSunrise Wings",list1.getData().get(0).toString());
        assertEquals("1975\tOne Flew Over the Cuckoo\'s Nest",list1.getData().get(47).toString());
        assertEquals("2017\tThe Shape of Water",list1.getData().get(list1.getData().size() - 1).toString());
    }

    @Test
    public void testToString()
    {
        Films list1 = new Films("");
        String expected = "1928\tSunrise Wings\n1929\tThe Broadway Melody\n1930\tAll Quiet on the Western Front\n1931\tCimarron\n1932\tGrand Hotel\n1933\tCavalcade\n1934\tIt Happened One Night\n1935\tMutiny on the Bounty\n1936\tThe Great Ziegfeld\n1937\tThe Life of Emile Zola\n1938\tYou Can't Take It With You\n1939\tGone with the Wind\n1940\tRebecca\n1941\tHow Green Was My Valley\n1942\tMrs. Miniver\n1943\tCasablanca\n1944\tGoing My Way\n1945\tThe Lost Weekend\n1946\tThe Best Years of Our Lives\n1947\tGentleman's Agreement\n1948\tHamlet (1948)\n1949\tAll the King's Men\n1950\tAll about Eve\n1951\tAn American in Paris\n1952\tThe Greatest Show on Earth\n1953\tFrom Here to Eternity\n1954\tOn the Waterfront\n1955\tMarty\n1956\tAround the World in 80 Days\n1957\tThe Bridge on the River Kwai\n1958\tGigi\n1959\tBen-Hur\n1960\tThe Apartment\n1961\tWest Side Story\n1962\tLawrence of Arabia\n1963\tTom Jones\n1964\tMy Fair Lady\n1965\tThe Sound of Music\n1966\tA Man for All Seasons\n1967\tIn the Heat of the Night\n1968\tOliver!\n1969\tMidnight Cowboy\n1970\tPatton\n1971\tThe French Connection\n1972\tThe Godfather\n1973\tThe Sting\n1974\tThe Godfather Part II\n1975\tOne Flew Over the Cuckoo's Nest\n1976\tRocky\n1977\tAnnie Hall\n1978\tThe Deer Hunter\n1979\tKramer vs. Kramer\n1980\tOrdinary People\n1981\tChariots of Fire\n1982\tGandhi\n1983\tTerms of Endearment\n1984\tAmadeus\n1985\tOut of Africa\n1986\tPlatoon\n1987\tThe Last Emperor\n1988\tRain Man\n1989\tDriving Miss Daisy\n1990\tDances With Wolves\n1991\tThe Silence of the Lambs\n1992\tUnforgiven\n1993\tSchindler's List\n1994\tForrest Gump\n1995\tBraveheart\n1996\tThe English Patient\n1997\tTitanic (1997)\n1998\tShakespeare in Love\n1999\tAmerican Beauty\n2000\tGladiator\n2001\tA Beautiful Mind\n2002\tChicago\n2003\tThe Lord of The Rings: The Return of The King\n2004\tMillion Dollar Baby\n2005\tCrash\n2006\tThe Departed\n2007\tNo Country for Old Men\n2008\tSlumdog Millionaire\n2009\tThe Hurt Locker\n2010\tThe King's Speech\n2011\tThe Artist\n2012\tArgo\n2013\t12 Years a Slave\n2014\tBirdman\n2015\tSpotlight\n2016\tMoonlight\n2017\tThe Shape of Water";
        assertEquals(expected,list1.toString());
    }
    
    @Test
    public void testSearchForFilmByYear()
    {
        Films list1 = new Films("");
        assertEquals("Sunrise Wings",list1.searchForFilmByYear(1928));
        assertEquals("Spotlight",list1.searchForFilmByYear(2015));
        assertEquals("All about Eve",list1.searchForFilmByYear(1950));
        assertEquals("Mutiny on the Bounty", list1.searchForFilmByYear(1935));
        assertEquals("Braveheart",list1.searchForFilmByYear(1995));
        assertEquals("",list1.searchForFilmByYear(1927));
        assertEquals("",list1.searchForFilmByYear(2050));
    }
    
    @Test
    public void testSearchForFilmByTitle()
    {
        Films list1 = new Films("");
        assertEquals(1928,list1.searchForFilmByTitle("Sunrise Wings"));
        assertEquals(2015,list1.searchForFilmByTitle("Spotlight"));
        assertEquals(1972,list1.searchForFilmByTitle("The Godfather"));
        assertEquals(2005,list1.searchForFilmByTitle("Crash"));
        assertEquals(-1,list1.searchForFilmByTitle("The Fly"));
        assertEquals(-1,list1.searchForFilmByTitle("Apollo 13"));
    }
    
    @Test
    public void testMergeSort()
    {
        Films list1 = new Films("");
    
        Film.compareByTitle();
        list1.mergeSort();
        assertEquals("2013\t12 Years a Slave",list1.getData().get(0).toString());
        assertEquals("1938\tYou Can\'t Take It With You",list1.getData().get(list1.getData().size()-1).toString());
        assertEquals("2007\tNo Country for Old Men",list1.getData().get(list1.getData().size()/2).toString());
        
        Film.compareByYear();
        list1.mergeSort();
        assertEquals("1928\tSunrise Wings",list1.getData().get(0).toString());
        assertEquals("2017\tThe Shape of Water",list1.getData().get(list1.getData().size()-1).toString());
        assertEquals("1973\tThe Sting",list1.getData().get(list1.getData().size()/2).toString());
        assertEquals("1984\tAmadeus",list1.getData().get(56).toString());
        assertEquals("1932\tGrand Hotel",list1.getData().get(4).toString());
        
    }
    
    @Test
    public void testFilmsContainingTheWord()
    {
        Films list1 = new Films("");
      
        ArrayList<Film> contains1 = list1.filmsContainingTheWord("the");
        assertEquals(31,contains1.size());
      
        ArrayList<Film> contains2 = list1.filmsContainingTheWord("one");
        assertEquals(4,contains2.size());
        assertEquals("1934\tIt Happened One Night",contains2.get(0).toString());
        assertEquals("1939\tGone with the Wind",contains2.get(1).toString());
        assertEquals("1963\tTom Jones",contains2.get(2).toString());
        assertEquals("1975\tOne Flew Over the Cuckoo's Nest",contains2.get(3).toString());

        ArrayList<Film> contains3 = list1.filmsContainingTheWord("Jupiter");
        assertEquals(0,contains3.size());
          
    }

}