def removeDup(l):
    skip = 0
    i = 1
    while i+skip+1 < len(l):
        print(l)
        if l[i] <= l[i-1]:
            skip += 1
            temp = l[i]
            l[i] = l[i+skip]
            l[i+skip] = temp
        else: i += 1
    return l

l1 = [1,2,3,3,4,5]
print(l1)
print(removeDup(l1))
print()
l2 = [1,2,3,3,4,5,5,5,6,7,9]
print(l2)
print(removeDup(l2))
