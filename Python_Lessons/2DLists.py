a = ["abc",123,True,[1.2,2.3,3.4]]
b = [1.2,2.3,3.4]
#since a[3] == b,
#b[0] == a[3][0]

c = [[1,2,3,4,5],
     [6,7,8,9,10],
     [11,12,13,14,15]]

def printList():
    for row in c:
        for num in row:
            if num < 10:
                print(num,end="  ")
            else:
                print(num,end=" ")
        print()

def printTriangle(num):
    for row in range(num):
        for col in range(row+1):
            print("*",end="")
        print()

def printDiamond(num):
    #print top half
    for row in range(num):
        #print out the spaces
        for i in range(num-row-1):
            print(" ",end="")
        #print asterisks
        for i in range(row * 2 + 1):
            print("*",end="")
        print()
    #print bottom half
    for row in range(num-1):
        #print out the spaces
        for i in range(row+1):
            print(" ",end="")
        #print asterisks
        for i in range((num-row-1)*2-1):
            print("*",end="")
        print()
