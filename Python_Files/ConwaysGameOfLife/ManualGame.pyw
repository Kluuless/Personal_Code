import tkinter as tk

##### =-=-=-=-=-= CONFIGS =-=-=-=-=-= #####
dimensions = (32,28)
simulationTime = 1000

##### =-=-=-=-=-= CREATE THE ROOT WINDOW =-=-=-=-=-= #####
win = tk.Tk()
win.geometry(str(dimensions[0]*22)+"x"+str(dimensions[1]*22+30))
win.title("Conway's Game of Life")

##### =-=-=-=-=-= INITIALIZE THE GRID =-=-=-=-=-= #####
grid = []
def cellClick(e):
    if e.widget.cget("bg") == "green":
        e.widget.config(bg="light gray")
    else:
        e.widget.config(bg="green")
    
for row in range(dimensions[0]):
    grid.append([])
    for col in range(dimensions[1]):
        grid[row].append(tk.Label(win,bg="light gray",width=2,height=1))
        grid[row][col].place(x=row*22,y=col*22)
        grid[row][col].bind("<Button>",cellClick)


##### =-=-=-=-=-= SIMULATION FUNCTIONS =-=-=-=-=-= #####
def isAlive(row,col):
    if grid[row][col].cget("bg") == "light gray":
        return False
    else:
        return True

def countNeighbors(row,col):
    alive = 0
    for r in range(-1,2):
        for c in range(-1,2):
            if r != 0 or c != 0:
                alive += int(isAlive((row+r+dimensions[0])%dimensions[0],\
                                     (col+c+dimensions[1])%dimensions[1]))
    return alive

def iterate(forceIteration=False):
    global runSimulation, generation, generationLabel
    if runSimulation or forceIteration:
        newGrid = []
        for row in range(dimensions[0]):
            newGrid.append([])
            for col in range(dimensions[1]):
                if isAlive(row,col):
                    if countNeighbors(row,col) in (2,3): newGrid[row].append(True)
                    else: newGrid[row].append(False)
                else:
                    if countNeighbors(row,col) == 3: newGrid[row].append(True)
                    else: newGrid[row].append(False)
        oneAlive = False
        for row in range(dimensions[0]):
            for col in range(dimensions[1]):
                if newGrid[row][col]:
                    grid[row][col].configure(bg="green")
                    oneAlive = True
                else: grid[row][col].configure(bg="light gray")
        generation += 1
        generationLabel.configure(text="Generation: " + str(generation))
        if not oneAlive: changeStartButton()
    if runSimulation: win.after(simulationTime,iterate)

runSimulation = False

##### =-=-=-=-= CONTROL BAR =-=-=-=-=-= #####
### Start Button ###
def changeStartButton():
    global runSimulation
    if startButton.cget("text")in("Start Simulation","Resume Simulation"):
        startButton.config(text="Pause Simulation")
        runSimulation = True
        iterate()
    else:
        startButton.config(text="Resume Simulation")
        runSimulation = False

startButton = tk.Button(win,text="Start Simulation",width=15,command=changeStartButton)
startButton.pack(side=tk.LEFT,anchor="s")

### Iterate Button ###
iterateButton = tk.Button(win,text="Iterate One Generation",command=lambda:iterate(True))
iterateButton.pack(side=tk.LEFT,anchor="s")

### Iteration Frequency Dropdown ###
freqOptions = ["0.1s","0.25s","0.5s","1s","2s","5s"]
selectedFreq = tk.StringVar()
selectedFreq.set("1s")
iterationFreq = tk.OptionMenu(win,selectedFreq,*freqOptions)
iterationFreq.config(height=1)
iterationFreq.pack(side=tk.LEFT,anchor="s")
def parseIterationFreq(a,b,c):
    global simulationTime
    if selectedFreq.get() == "0.1s": simulationTime = 100
    elif selectedFreq.get() == "0.25s": simulationTime = 250
    elif selectedFreq.get() == "0.5s": simulationTime = 500
    elif selectedFreq.get() == "1s": simulationTime = 1000
    elif selectedFreq.get() == "2s": simulationTime = 2000
    else: simulationTime = 5000
selectedFreq.trace("w",parseIterationFreq)

### Generation Label ###
generation = 0
generationLabel = tk.Label(win, text="Generation: 0")
generationLabel.pack(side=tk.LEFT,anchor="s")

### Help Button ###
def popUp():
    top = tk.Toplevel(win)
    top.geometry("500x150")
    tk.Label(top,justify=tk.LEFT,text='''The rules of Conway's Game of Life are as follows:
Every round, the board updates its cells according to some rules.
1. Any live cell with fewer than two live neighbors dies, as if by underpopulation.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by overpopulation.
4. Any dead Cell with exactly three live neighbors becomes a live cell, as if by reproduction.''').place(x=0,y=0)
    tk.Button(top,text="Got it",command=top.destroy).pack(side=tk.BOTTOM,anchor="s")
helpButton = tk.Button(win, text="Help", command=popUp).pack(side=tk.RIGHT,anchor="s")

### Clear Board Button ###
def clearBoard():
    for r in range(dimensions[0]):
        for c in range(dimensions[1]):
            grid[r][c].configure(bg="light gray")
clearBoardButton = tk.Button(win, text="Clear Board",command=clearBoard)
clearBoardButton.pack(side=tk.RIGHT,anchor="s")

##### =-=-=-=-=-= MAIN LOOP =-=-=-=-=-= #####
win.mainloop()
