import tkinter as tk
import os

##### =-=-=-=-=-= CREATE THE ROOT WINDOW =-=-=-=-=-= #####
win = tk.Tk()
win.geometry("300x300")
win.title("Nonogram")

##### =-=-=-=-=-= LOAD FILE =-=-=-=-=-= #####
files = os.listdir("puzzles/")
fileNameLabel = tk.Label(win,text="Load File:")
fileNameLabel.place(x=5,y=5)

sVar = tk.StringVar(win)
sVar.set(files[0])
fileNameMenu = tk.OptionMenu(win, sVar, *files)
fileNameMenu.place(x=60,y=2)

def loadFile(a, b, c):
    global greenMode, checkGrid, grid, hints, completeWidget
    for widget in win.winfo_children():
        if widget != fileNameLabel and widget != fileNameMenu:
            widget.destroy()
    
    solution_file = open('puzzles/' + sVar.get(),'r')
    solution = solution_file.read()
    solution_file.close()
    solution = solution.split('\n')
    for line in range(len(solution)):
        lineArray = []
        for char in solution[line]:
            lineArray.append(char)
        solution[line] = lineArray

    #Add spaces after each incomplete line
    longest_line = 0
    for line in solution:
        if len(line) > longest_line: longest_line = len(line)
    for line in solution:
        for i in range(longest_line-len(line)): line.append(' ')

    ##### =-=-=-=-=-= PARSE HINTS =-=-=-=-=-= #####
    hints = [[],[]]

    #Row Hints
    for row in solution:
        rowHints = []
        currentState = ' '
        for char in row:
            if char == currentState and currentState == 'X':
                rowHints[-1] += 1
            elif char != currentState and currentState == 'X':
                currentState = ' '
                rowHints[-1] += 1
            elif char != currentState and currentState == ' ':
                currentState = 'X'
                rowHints.append(0)
        if row[-1] == 'X': rowHints[-1] += 1
        while 0 in rowHints: rowHints.remove(0)
        hints[0].append(rowHints)

    #Column Hints
    for col in range(len(solution[0])):
        colHints = []
        currentState = ' '
        for row in range(len(solution)):
            if solution[row][col] == currentState and currentState == 'X':
                colHints[-1] += 1
            elif solution[row][col] != currentState and currentState == 'X':
                currentState = ' '
                colHints[-1] += 1
            elif solution[row][col] != currentState and currentState == ' ':
                currentState = 'X'
                colHints.append(0)
        if solution[-1][col] == 'X': colHints[-1] += 1
        while 0 in colHints: colHints.remove(0)
        hints[1].append(colHints)

    ##### =-=-=-=-=-= Configure Window Size =-=-=-=-=-= #####
    longestRowHint = 0
    for rowHint in hints[0]:
        if len(rowHint) > longestRowHint: longestRowHint = len(rowHint)
    longestColHint = 0
    for colHint in hints[1]:
        if len(colHint) > longestColHint: longestColHint = len(colHint)
    win.geometry(str((longestRowHint + len(solution[0])) * 22+10) + 'x' + \
                 str((longestColHint + len(solution)) * 22 + 70))

    ##### =-=-=-=-=-= Create Grid =-=-=-=-=-= #####
    completeWidget = tk.Label(win,fg="red",text="incomplete",\
                              width=3*len(solution[0]),anchor="center")
    completeWidget.place(x=longestRowHint*22,\
                         y=(longestColHint+len(solution))*22+45)
    greenMode = True
    def modeSwitch(e):
        global greenMode
        if e.widget.cget("bg") == "green":
            e.widget.config(bg="white")
            greenMode = False
        else:
            e.widget.config(bg="green")
            greenMode = True
    modeText = tk.Label(win,text="Mode:")
    modeText.place(x=5,y=(longestColHint+len(solution))*22+45)
    modeLabel = tk.Label(win,bg="green",width=2,height=1)
    modeLabel.place(x=45,y=(longestColHint+len(solution))*22+45)
    modeLabel.bind("<Button>",modeSwitch)

    grid = []

    def checkGrid():
        global grid, hints
        gridHints = [[],[]]
        for row in grid:
            rowHints = []
            currentState = ['white','light gray']
            for cell in row:
                cellState = cell.configure("bg")[4]
                if cellState in currentState and currentState == ['green']:
                    rowHints[-1] += 1
                elif cellState not in currentState and currentState == ['green']:
                    currentState = ['white','light gray']
                    rowHints[-1] += 1
                elif cellState not in currentState and currentState != ['green']:
                    currentState = ['green']
                    rowHints.append(0)
            if row[-1].configure("bg")[4] == 'green': rowHints[-1] += 1
            while 0 in rowHints: rowHints.remove(0)
            gridHints[0].append(rowHints)
        for col in range(len(grid[0])):
            colHints = []
            currentState = ['white','light gray']
            for row in range(len(grid)):
                cellState = grid[row][col].configure("bg")[4]
                if cellState in currentState and currentState == ['green']:
                    colHints[-1] += 1
                elif cellState not in currentState and currentState == ['green']:
                    currentState = ['white','light gray']
                    colHints[-1] += 1
                elif cellState not in currentState and currentState != ['green']:
                    currentState = ['green']
                    colHints.append(0)
            if grid[-1][col].configure('bg')[4] == 'green': colHints[-1] += 1
            while 0 in colHints: colHints.remove(0)
            gridHints[1].append(colHints)
        return gridHints == hints

    def cellClick(e):
        global greenMode, checkGrid, completeWidget
        if e.widget.cget("bg") == "light gray":
            e.widget.config(bg="green") if greenMode else e.widget.config(bg="white")
        elif e.widget.cget("bg") == "white" and not greenMode:
            e.widget.config(bg="light gray")
        elif e.widget.cget("bg") == "green" and greenMode:
            e.widget.config(bg="light gray")
        if checkGrid():
            completeWidget.configure(fg="green",text="Complete!")
        else:
            completeWidget.configure(fg="red",text="Incomplete")

    for row in range(len(solution)):
        grid.append([])
        for col in range(len(solution[0])):
            grid[row].append(tk.Label(win,bg="light gray",width=2,height=1))
            grid[row][col].place(x=col*22+longestRowHint*22,\
                                 y=row*22+longestColHint*22+40)
            grid[row][col].bind("<Button>",cellClick)
        
    #####=-=-=-=-=-= Place Hints =-=-=-=-=-= #####
    hintWidgets = [[],[]]

    for rowHint in range(len(hints[0])):
        rowHintWidgets = []
        for num in hints[0][rowHint][::-1]:
            rowHintWidgets.append(tk.Label(win,width=2,height=1,text=str(num)))
            rowHintWidgets[-1].place(x=(longestRowHint-len(rowHintWidgets))*22,\
                                     y=(longestColHint+rowHint)*22+40)
        hintWidgets[0].append(rowHintWidgets[::-1])

    for colHint in range(len(hints[1])):
        colHintWidgets = []
        for num in hints[1][colHint][::-1]:
            colHintWidgets.append(tk.Label(win,width=2,height=1,text=str(num)))
            colHintWidgets[-1].place(x=(longestRowHint+colHint)*22,\
                                     y=(longestColHint-len(colHintWidgets))*22+40)
        hintWidgets[1].append(colHintWidgets[::-1])

sVar.trace_add("write",loadFile)



##### =-=-=-=-=-= MAIN LOOP =-=-=-=-=-= #####
win.mainloop()
