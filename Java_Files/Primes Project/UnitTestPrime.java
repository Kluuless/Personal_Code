import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UnitTestPrime.
 *
 * @author  Mr. Funk
 * @version 1.0
 */
public class UnitTestPrime
{
    /**
     * Default constructor for test class UnitTestPrime
     */
    public UnitTestPrime()
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
    public void TestIsPrime()
    {
        assertEquals(true, Primes.isPrime(2));
        assertEquals(false, Primes.isPrime(1));
        assertEquals(false, Primes.isPrime(0));
        assertEquals(false, Primes.isPrime(-103));
        assertEquals(false, Primes.isPrime(1349656));
        assertEquals(true, Primes.isPrime(104729));
    }
        
    @Test
    public void TestCountPrime()
    {
        assertEquals(95, Primes.countPrime(500));
        assertEquals(3, Primes.countPrime(5));
        assertEquals(168, Primes.countPrime(1000));
    }

    @Test
    public void TestSumPrime()
    {
        assertEquals(1593, Primes.sumPrime(30));
        assertEquals(111587, Primes.sumPrime(200));
        assertEquals(2, Primes.sumPrime(1));
        assertEquals(0, Primes.sumPrime(-1));
    }
    
    @Test
    public void TestAvePrime()
    {       
        assertEquals(5.6, Primes.avePrime(5), 0.001);
        assertEquals(3682.913, Primes.avePrime(1000), 0.001);
        assertEquals(23853.3433, Primes.avePrime(30000), 0.0001);
        assertEquals(15214.172324510932, Primes.avePrime(3476), 0.0000000001);        
    }
    
    @Test
    public void TestPrimeSpace()
    {           
        assertEquals(6, Primes.primeSpace(30));
        assertEquals(14, Primes.primeSpace(200));
        assertEquals(20, Primes.primeSpace(1000));
        assertEquals(72, Primes.primeSpace(50000));
    }
}
