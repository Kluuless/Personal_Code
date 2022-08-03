def Euclid(x,y,count=0):
    if (y == 0):
        return (x,count)
    else:
        return Euclid(y, x % y,count+1)

print(Euclid(24,18))
