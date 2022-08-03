import primes_and_factors as primes

def nextIter(n):
    if n%2 == 0: return n // 2
    else: return 3 * n + 1

def runLoop(n):
    num = n
    path = []
    while (num != 1):
        path.append(num)
        num = nextIter(num)
    path.append(1)
    return path

def ask():
    print(runLoop(int(input("What number to test? "))))

def loopN(n):
    for i in range(1,n+1):
        print(str(i) +  ":", runLoop(i))

def loopNPrimes(n):
    nPrimes = []
    a = 0
    while len(nPrimes) < n:
        a = primes.getNextPrime(a)
        nPrimes.append(a)
    for p in nPrimes:
        pPath = runLoop(p)
        print(str(p), "(" + str(len(pPath)) + "):", pPath)
        print()
        
def loopNComposites(n):
    nComps = []
    a = 0
    while len(nComps) < n:
        a = primes.getNextHighlyComposite(a)
        nComps.append(a)
    for c in nComps:
        cPath = runLoop(c)
        print(str(c), "(" + str(len(cPath)) + "):", cPath)
        print()
