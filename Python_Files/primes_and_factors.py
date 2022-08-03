from datetime import datetime
def isPrime(n):
    for i in range(2,int(n**0.5)+1):
        if n%i == 0: return False
    return True

def getNextPrime(n):
    if n % 2 == 0: nextp = n + 1
    else: nextp = n + 2
    while not isPrime(nextp):
        nextp += 1
    return nextp

def listPrimes(n):
    if n <= 0: print("Please enter a positive number")
    else:
        start = datetime.now()
        number = 1
        for i in range(n):
            number = getNextPrime(number)
            print(number)
        
        print("It took " + str(datetime.now()-start)[5:15] + " seconds.")

def listPrimes2(n):
    if n <= 0: print("Please enter a positive number")
    else:
        start = datetime.now()
        number = 1
        primes = []
        for i in range(n):
            number = getNextPrime(number)
            primes.append(number)
        print(primes)
        print("It took " + str(datetime.now()-start)[5:15] + " seconds.")


def primeFactors(n):
    if n < 2: print("Please enter a number greater than 1.")
    else:
        number = n
        factors = []
        current_prime = 2
        while number != 1:
            if number%current_prime == 0:
                factors.append(current_prime)
                number //= current_prime
            else:
                current_prime = getNextPrime(current_prime)
        factors.append(0)
        current_factor = factors[0]
        count = 1
        factorization = ""
        for i in range(len(factors)):
            if factors[i] == 0: pass
            elif factors[i] == factors[i+1]:
                count += 1
            else:
                factorization += str(current_factor)
                if count > 1: factorization += "^" + str(count)
                factorization += " * "
                current_factor = factors[i+1]
                count = 1
        print(n,factorization[:-3],sep=': ')

def listFactors(n, printRes=True):
    if n == 0: print(0)
    else:
        factors = []
        
        for i in range(1,int(abs(n)**0.5)+1):
            if n%i == 0:
                factors.append(i)
                if i != n and n//i not in factors: factors.append(n//i)
                if n < 0:
                    factors.append(i*-1)
                    if i != n: factors.append(n//i*-1)
        factors.sort()
        result = str(n) + ": "
        for i in factors:
            result += str(i) + ", "
        
        if printRes: print(result[:-2])
        else: return result[:-2]
    
#def listCompositeNumbers(n):

def isHighlyComposite(n):
    nFactors = len(listFactors(n,False))
    for i in range(n-1,1,-1):
        if len(listFactors(i,False)) >= nFactors: return False
    return True

def getNextHighlyComposite(n):
    nxt = n + 1
    while not isHighlyComposite(nxt):
        nxt = nxt + 1
    return nxt
