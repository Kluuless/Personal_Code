
def make(r,odd=True):
    grid = []
    for i in range(2*r+odd):
        grid.append([])
        for j in range(2*r+odd):
            grid[i].append("_ ")

    for i in range(len(grid)):
        for j in range(len(grid)):
            x = i-r
            y = j-r
            if not odd:
                x += 0.5
                y += 0.5
            if (x**2+y**2)**0.5 <= r:
                grid[i][j] = 'X '

    for i in grid:
        for j in i:
            print(j,end="")
        print()
