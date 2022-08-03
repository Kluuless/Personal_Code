def fact(n):
    if n == 0:
        return 1
    else:
        return n * fact(n-1)


for i in range(20):
    print(i, ": ", fact(i))
