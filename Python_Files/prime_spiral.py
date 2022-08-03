
def isPrime(n):
    if n < 2: return False
    for i in range(2,int(n**0.5)+1):
        if n%i == 0: return False
    return True

def makeSpiral(n):
    if type(n) != type(0): print("Provide a positive odd integer.")
    elif n < 1: print("Enter a positive odd integer.")
    elif n%2 == 0: print("Enter an odd integer.")
    else:
        grid = []
        for i in range(n):
            grid.append([])
        for r in range(n):
            for c in range(n):
                grid[r].append(".")
        directions = [0,1,2,3]
        currentDirection = directions[0]
        moveAmount = 1
        moved = 1
        count = 1
        current = [n//2,n//2]
        increase = False
        while count <= n**2:
            if isPrime(count): grid[current[0]][current[1]] = "X"
            if currentDirection == 0: current[1] += 1
            elif currentDirection == 1: current[0] -= 1
            elif currentDirection == 2: current[1] -= 1
            else: current[0] += 1
            if moved >= moveAmount:
                if increase: moveAmount += 1; increase = False
                else: increase = True
                moved = 1
                currentDirection = directions[(currentDirection+1) % 4]
            else:
                moved += 1
            count += 1

        for i in range(n):
            for j in range(n):
                print(grid[i][j],end=" ")
            print()
