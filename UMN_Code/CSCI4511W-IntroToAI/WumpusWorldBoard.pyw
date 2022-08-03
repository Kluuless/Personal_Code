import random

configs = {"board size":(4,4),"num wumpuses":1,"freq pits":0.2,"start loc":(3,0)}

def solvable(a,b): pass

def board_init():
    while True:
        board = []
        for x in range(configs["board size"][0]):
            row = []
            for y in range(configs["board size"][1]):
                row.append(" ")
            board.append(row)

        board[configs["start loc"][0]][configs["start loc"][1]] = "U"

        for x in range(configs["board size"][0]):
            for y in range(configs["board size"][1]):
                sl = configs["start loc"]
                if (x,y) not in ((sl[0],sl[1]),(sl[0]+1,sl[1]),(sl[0]-1,sl[1]),(sl[0],sl[1]+1),(sl[0],sl[1]-1)):
                    if random.random() < configs["freq pits"]:
                        board[x][y] = "P"

        for i in range(configs["num wumpuses"]):
            containsWumpus = False
            while not containsWumpus:
                rc = (random.randint(0,3),random.randint(0,3))
                if board[rc[0]][rc[1]] == " ":
                    board[rc[0]][rc[1]] = "W"
                    containsWumpus = True

        containsGold = False
        while not containsGold:
            rc = (random.randint(0,3),random.randint(0,3))
            if board[rc[0]][rc[1]] == " ":
                board[rc[0]][rc[1]] = "G"
                containsGold = True
        if solvable(board): return board

def findPlayer(board):
    for r in range(configs["board size"][0]):
        for c in range(configs["board size"][1]):
            if "U" in board[r][c]: return (r,c)
    return None
            

def solvable(board,prevCoords=[]):
    coords = findPlayer(board)
    if coords == None or coords in prevCoords: return False
    
    newCoords = [] #copy of prevLocs
    for c in prevCoords:
        newCoords.append(c)
    newCoords.append(coords) #add current coordinates

    directions = []
    if coords[0] > 0:
        directions.append("N")
    if coords[1] < 3:
        directions.append("E")
    if coords[0] < 3:
        directions.append("S")
    if coords[1] > 0:
        directions.append("W")

    states = [] #copy board len(direction) times into states
    for i in range(len(directions)):
        newBoard = []
        for x in range(configs["board size"][0]):
            row = []
            for y in range(configs["board size"][1]):
                row.append(board[x][y])
            newBoard.append(row)
        states.append(newBoard)

    for i in range(len(directions)): #move 'U' appropriate direction in board
        if directions[i] == "N": #Wumpuses aren't part of this bc they can be killed
            if states[i][coords[0]-1][coords[1]] == "G": return True #if 'G' can be found, 'U' can escape with it
            elif states[i][coords[0]-1][coords[1]] == "P":
                states[i][coords[0]-1][coords[1]] = "X" #'U' becomes 'X' if 'U' moves to a 'P'
            else: states[i][coords[0]-1][coords[1]] = "U"
        elif directions[i] == "E":
            if states[i][coords[0]][coords[1]+1] == "G": return True
            elif states[i][coords[0]][coords[1]+1] == "P":
                states[i][coords[0]][coords[1]+1] = "X"
            else: states[i][coords[0]][coords[1]+1] = "U"
        elif directions[i] == "S":
            if states[i][coords[0]+1][coords[1]] == "G": return True
            elif states[i][coords[0]+1][coords[1]] == "P":
                states[i][coords[0]+1][coords[1]] = "X"
            else: states[i][coords[0]+1][coords[1]] = "U"
        else:
            if states[i][coords[0]][coords[1]-1] == "G": return True
            elif states[i][coords[0]][coords[1]-1] == "P":
                states[i][coords[0]][coords[1]-1] = "X"
            else: states[i][coords[0]][coords[1]-1] = "U"
        states[i][coords[0]][coords[1]] = " "

    solved = False
    for s in states:
        if solvable(s,newCoords): solved = True
    return solved

def sense(board,holdingGold):
    c = findPlayer(board)
    senses = []
    if (c[0] > 0 and board[c[0]-1][c[1]] == "P") or \
       (c[0] < 3 and board[c[0]+1][c[1]] == "P") or \
       (c[1] > 0 and board[c[0]][c[1]-1] == "P") or \
       (c[1] < 3 and board[c[0]][c[1]+1] == "P"):
        senses.append("Breeze")
    if (c[0] > 0 and board[c[0]-1][c[1]] == "W") or \
       (c[0] < 3 and board[c[0]+1][c[1]] == "W") or \
       (c[1] > 0 and board[c[0]][c[1]-1] == "W") or \
       (c[1] < 3 and board[c[0]][c[1]+1] == "W"):
        senses.append("Stench")
    if "G" in board[c[0]][c[1]] and not holdingGold: senses.append("Glitter")
    return senses

def shoot(board,look):
    c = findPlayer(board)
    if look == "N":
        for i in range(c[0]-1,-1,-1):
            if board[i][c[1]] == "W":
                board[i][c[1]] = " "
                return True
    elif look == "E":
        for i in range(c[1]+1,4):
            if board[c[0]][i] == "W":
                board[c[0]][i] = " "
                return True
    elif look == "S":
        for i in range(c[0]+1,4):
            if board[i][c[1]] == "W":
                board[i][c[1]] = " "
                return True
    elif look == "W":
        for i in range(c[1]-1,-1,-1):
            if board[c[0]][i] == "W":
                board[c[0]][i] = " "
                return True
    return False

def turn(look,direction):
    ds = ("N","E","S","W")
    if direction == "R": return ds[(ds.index(look)+1)%4]
    elif direction == "L": return ds[(ds.index(look)+7)%4]
    else: return look

def move(board,look,holdingGold=False):
    c = findPlayer(board)
    if "W" in board[c[0]][c[1]] or "P" in board[c[0]][c[1]]: return False
    nc = (0,0)
    if look == "N" and c[0] > 0: nc = (c[0]-1,c[1])
    elif look == "E" and c[1] < 3: nc = (c[0],c[1]+1)
    elif look == "S" and c[0] < 3: nc = (c[0]+1,c[1])
    elif look == "W" and c[1] > 0: nc = (c[0],c[1]-1)
    else: return False
    if board[nc[0]][nc[1]] == " ": board[nc[0]][nc[1]] = "U"
    else: board[nc[0]][nc[1]] += "U"
    if holdingGold: board[nc[0]][nc[1]] += "G"
    
    board[c[0]][c[1]] = board[c[0]][c[1]].replace("U","")
    if holdingGold: board[c[0]][c[1]] = board[c[0]][c[1]].replace("G","")
    if board[c[0]][c[1]] == "": board[c[0]][c[1]] = " "
    return True

def pickUpGold(board):
    c = findPlayer(board)
    if "G" in board[c[0]][c[1]]: return True
    else: return False

def won(board):
    sl = configs["start loc"]
    return "U" in board[sl[0]][sl[1]]and "G" in board[sl[0]][sl[1]]

def lost(board):
    c = findPlayer(board)
    if "W" in board[c[0]][c[1]] or "P" in board[c[0]][c[1]]: return True
    else: return False

def printBoard(board):
    maxSize = 0
    for r in board:
        for rc in r:
            if len(str(rc)) > maxSize: maxSize = len(str(rc))
    adjust = ""
    for i in range(maxSize-1): adjust += " "
    for r in board:
        for rc in r:
            print("["+str(rc)+adjust[len(str(rc))-1:]+"]",end="")
        print()
