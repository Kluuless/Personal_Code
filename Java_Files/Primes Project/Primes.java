
/**
 * Prints and counts prime numbers.
 * 
 * @author Kyle Luu
 * @version 1.0
 */
public class Primes
{
    public static boolean isPrime(int p)
    {
        if(p <= 1) //returns false if less than 2
        {
            return false;
        }
        //returns false if the product of two numbers less than p equals p
        else
        {
            for (int i = 2; i < p; i++) //first number
            {
                if (p%i == 0)
                {
                    return false;
                }
            }
        }
        return true; //everything else is prime
    }

    public static void printPrimes()
    {
        for (int i = 2; i <= 100; i++) //goes through every number <= 100 and prints if prime
        {
            if (isPrime(i))
            {
                System.out.println(i);
            }
        }
    }

    public static void printPrimes(int n)
    {
        boolean stopper = true;
        if (n < 0) //number is not prime if negative
        {
            stopper = false;
            System.out.println("Error: input is negative.");
        }

        if(stopper) //goes through every number <= n and prints if prime
        {
            for (int i = 2; i <= n; i++)
            {
                if (isPrime(i))
                {
                    System.out.println(i);
                }
            }
        }
    }

    public static int countPrime(int n)
    {
        int count = 0;
        for (int i = 2; i <= n; i++) //goes through every number <= n and adds 1 to counter for every prime
        {
            if (isPrime(i))
            {
                count++;
            }
        }
        return count;
    }

    public static int sumPrime(int n)
    {
        int sum = 0;
        int prevPrime = 1;
        for(int i = 1; i <= n; i++) //finds the sum of the first n prime numbers
        {
            int j;
            for(j = prevPrime; !isPrime(j); j++) //sets j to the next prime number
            {}
            sum = sum + j; //adds j to the total
            prevPrime = j + 1; //stores the prime number and sets j equal to it for next round
        }
        return sum;
    }

    public static double avePrime(int n)
    {
        return (sumPrime(n)/(n * 1.0));
    }

    public static int primeSpace(int n)
    {
        int num1 = 0;
        int num2 = 0;
        int result1;
        int result2 = 0;
        int i;
        for(int k = n; k > 2; k--) //scans every number less than n and bigger than 1
        {
            //fnds the two highest prime numbers lower than k and subtracts them
            for(i = k; !isPrime(i); i--) //finds highest prime number lower than k
            {
                num1 = i;
            }
            i -= 1;
            for(i = i; !isPrime(i); i--) //finds second highest prime number lower than k
            {
                num2 = i;
            }
            result1 = num1 - num2;
            //if the result is higher than before, it sets the result equal to the newer one
            if(result1 > result2)
            {
                result2 = result1;
            }
        }
        return result2;
    }

    public static String factor(int n)
    {
        if (n < 2)
        {
            return "";
        }

        String primeFactorization = "";
        while (n > 1) //does loop until n = 1
        {
            for (int p = 2; p <= n; p++) //finds prime number p
            {
                while (n % p == 0) //divides n by p repeatedly until n is no longer divisible by p
                {
                    primeFactorization = (primeFactorization + p); //adds p to factorization
                    n = n / p;
                    primeFactorization = (primeFactorization + "*");
                }
            }
        }
        primeFactorization = primeFactorization.substring(0, (primeFactorization.length()-1));
        return primeFactorization;
    }

    public static int countTwinPrimes(int max)
    {
        int counter = 0;
        for (int n = 0; n <= max; n++) //scans every number < max for a prime number n
        {
            if (isPrime(n) && isPrime(n + 2)) //if n and (n + 2) are prime, add 1 to counter
            {
                counter++;
            }
        }
        return counter;
    }
}
