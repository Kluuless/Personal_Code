import WumpusWorld as ww
import WumpusWorldBoard as wwb
import random

board = [[" "," "," "," "],\
         [" "," "," "," "],\
         [" "," "," "," "],\
         ["U"," "," "," "]]

direction = "N"
ds = {"N":"North","E":"East","S":"South","W":"West"}
coords = (3,0)
shot = False
noWumpus = []
arrows = 1
order = [(3,0),(2,0),(2,1),(3,1),(3,2),(2,2),(1,2),(1,1),\
         (1,0),(0,0),(0,1),(0,2),(0,3),(1,3),(2,3),(3,3)]
futureMoves = []
replaced = False

def reset():
    global board, direction, coords, shot, noWumpus, arrows, order, futureMoves, replaced
    board = [[" "," "," "," "],\
             [" "," "," "," "],\
             [" "," "," "," "],\
             ["U"," "," "," "]]
    direction = "N"
    ds = {"N":"North","E":"East","S":"South","W":"West"}
    coords = (3,0)
    shot = False
    noWumpus = []
    arrows = 1
    order = [(3,0),(2,0),(2,1),(3,1),(3,2),(2,2),(1,2),(1,1),\
             (1,0),(0,0),(0,1),(0,2),(0,3),(1,3),(2,3),(3,3)]
    futureMoves = []
    replaced = False

def StrInStr(s1,s2):
    for c in s1:
        if c in s2: return True
    return False

def findPits():
    probs = [[0.0,0.0,0.0,0.0],
             [0.0,0.0,0.0,0.0],
             [0.0,0.0,0.0,0.0],
             [0.0,0.0,0.0,0.0]]
    for r in range(len(board)):
        for c in range(len(board[r])):
            if "B" in board[r][c]:
                unknownCells = []
                if r > 0 and not StrInStr("PUE",board[r-1][c]):
                    unknownCells.append((r-1,c))
                if r < 3 and not StrInStr("PUE",board[r+1][c]):
                    unknownCells.append((r+1,c))
                if c < 3 and not StrInStr("PUE",board[r][c+1]):
                    unknownCells.append((r,c+1))
                if c > 0 and not StrInStr("PUE",board[r][c-1]):
                    unknownCells.append((r,c-1))
                for (x,y) in unknownCells:
                    probs[x][y] += 1/len(unknownCells)
    return probs

def findWumpus():
    global shot, noWumpus
    probs = [[0.0,0.0,0.0,0.0],
             [0.0,0.0,0.0,0.0],
             [0.0,0.0,0.0,0.0],
             [0.0,0.0,0.0,0.0]]
    if shot: return None
    for r in range(len(board)):
        for c in range(len(board[r])):
            if "S" in board[r][c]:
                unknownCells = []
                if r > 0 and not (StrInStr("PUE",board[r-1][c]) or (r-1,c) in noWumpus):
                    unknownCells.append((r-1,c))
                if r < 3 and not (StrInStr("PUE",board[r+1][c]) or (r+1,c) in noWumpus):
                    unknownCells.append((r+1,c))
                if c < 3 and not (StrInStr("PUE",board[r][c+1]) or (r,c+1) in noWumpus):
                    unknownCells.append((r,c+1))
                if c > 0 and not (StrInStr("PUE",board[r][c-1]) or (r,c-1) in noWumpus):
                    unknownCells.append((r,c-1))
                for (x,y) in unknownCells:
                    probs[x][y] += 1/len(unknownCells)
    return probs

def peek():
    global coords, direction
    if direction == "N" and coords[0] > 0: return (coords[0]-1,coords[1])
    elif direction == "E" and coords[1] < 3: return (coords[0],coords[1]+1)
    elif direction == "S" and coords[0] < 3: return (coords[0]+1,coords[1])
    elif direction == "W" and coords[1] > 0: return (coords[0],coords[1]-1)
    else: return coords

def directionsToTarget(goal):
    global coords, direction, futureMoves,order
    if futureMoves == None: futureMoves = []
    pits = findPits()
    wumpus = findWumpus()
    if wumpus == None:
        wumpus = [[0.0,0.0,0.0,0.0],[0.0,0.0,0.0,0.0],[0.0,0.0,0.0,0.0],[0.0,0.0,0.0,0.0]]
    if goal == coords: return ""
    elif pits[goal[0]][goal[1]] > 1:
        if direction == "N":
            if order[0][1] < coords[1]: futureMoves = ["turn left","move","turn right","move"]
            elif order[0][1] > coords[1]: futureMoves = ["turn right","move","turn left","move"]
            elif coords[1] == 0: futureMoves = ["turn right","move","turn left","move"]
            elif coords[1] == 3: futureMoves = ["turn left","move","turn right","move"]
            elif random.random() < 0.5: futureMoves = ["turn right","move","turn left","move"]
            else: futureMoves = ["turn left","move","turn right","move"]
        elif direction == "E":
            if order[0][0] < coords[0]: futureMoves = ["turn left","move","turn right","move"]
            elif order[0][0] > coords[0]: futureMoves = ["turn right","move","turn left","move"]
            elif coords[0] == 0: futureMoves = ["turn right","move","turn left","move"]
            elif coords[0] == 3: futureMoves = ["turn left","move","turn right","move"]
            elif random.random() < 0.5: futureMoves = ["turn right","move","turn left","move"]
            else: futureMoves = ["turn left","move","turn right","move"]
        elif direction == "S":
            if order[0][1] > coords[1]: futureMoves = ["turn left","move","turn right","move"]
            elif order[0][1] < coords[1]: futureMoves = ["turn right","move","turn left","move"]
            elif coords[1] == 3: futureMoves = ["turn right","move","turn left","move"]
            elif coords[1] == 0: futureMoves = ["turn left","move","turn right","move"]
            elif random.random() < 0.5: futureMoves = ["turn right","move","turn left","move"]
            else: futureMoves = ["turn left","move","turn right","move"]
        else:
            if order[0][0] > coords[0]: futureMoves = ["turn left","move","turn right","move"]
            elif order[0][0] < coords[0]: futureMoves = ["turn right","move","turn left","move"]
            elif coords[0] == 3: futureMoves = ["turn right","move","turn left","move"]
            elif coords[0] == 0: futureMoves = ["turn left","move","turn right","move"]
            elif random.random() < 0.5: futureMoves = ["turn right","move","turn left","move"]
            else: futureMoves = ["turn left","move","turn right","move"]
        return futureMoves.pop(0)
    elif len(futureMoves) > 0:
        action = futureMoves.pop(0)
        #print(goal,coords,direction,action,futureMoves)
        if action == "move":
            if peek() == coords:
                futureMoves = futureMoves.insert(0,"move")
                return "turn right" if random.random() < 0.5 else "turn left"
            if direction == "N" and (pits[coords[0]-1][coords[1]] > 1 or \
                                     wumpus[coords[0]-1][coords[1]] > 0):
                if coords[1] == 0:
                    futureMoves = ["move","turn right","move"] + futureMoves
                    return "turn left"
                elif coords[1] == 3:
                    futureMoves = ["move","turn left","move"] + futureMoves
                    return "turn right"
                elif random.random() < 0.5:
                    futureMoves = ["move","turn right","move"] + futureMoves
                    return "turn left"
                else:
                    futureMoves = ["move","turn left","move"] + futureMoves
                    return "turn right"
            elif direction == "E" and (pits[coords[0]][coords[1]+1] > 1 or \
                                       wumpus[coords[0]][coords[1]+1] > 0):
                if coords[0] == 3:
                    futureMoves = ["move","turn left","move"] + futureMoves
                    return "turn right"
                elif coords[0] == 0:
                    futureMoves = ["move","turn right","move"] + futureMoves
                    return "turn left"
                elif random.random() < 0.5:
                    futureMoves = ["move","turn right","move"] + futureMoves
                    return "turn left"
                else:
                    futureMoves = ["move","turn left","move"] + futureMoves
                    return "turn right"
            elif direction == "S" and (pits[coords[0]+1][coords[1]] > 1 or \
                                       wumpus[coords[0]+1][coords[1]] > 0):
                if coords[1] == 3:
                    futureMoves = ["move","turn left","move"] + futureMoves
                    return "turn right"
                elif coords[1] == 0:
                    futureMoves = ["move","turn right","move"] + futureMoves
                    return "turn left"
                elif random.random() < 0.5:
                    futureMoves = ["move","turn right","move"] + futureMoves
                    return "turn left"
                else:
                    futureMoves = ["move","turn left","move"] + futureMoves
                    return "turn right"
            elif direction == "W" and (pits[coords[0]][coords[1]-1] > 1 or \
                                       wumpus[coords[0]][coords[1]-1] > 0):
                if coords[0] == 0:
                    futureMoves = ["move","turn right","move"] + futureMoves
                    return "turn left"
                elif coords[0] == 3:
                    futureMoves = ["move","turn left","move"] + futureMoves
                    return "turn right"
                elif random.random() < 0.5:
                    futureMoves = ["move","turn right","move"] + futureMoves
                    return "turn left"
                else:
                    futureMoves = ["move","turn left","move"] + futureMoves
                    return "turn right"
            else:
                return "move"
        return action
    else:
        if direction == "S" and goal[0] > coords[0]:
            futureMoves.insert(0,"move")
            return directionsToTarget(goal)
        elif direction == "E" and goal[1] > coords[1]:
            futureMoves.insert(0,"move")
            return directionsToTarget(goal)
        elif direction == "N" and goal[0] < coords[0]:
            futureMoves.insert(0,"move")
            return directionsToTarget(goal)
        elif direction == "W" and goal[1] < coords[1]:
            futureMoves.insert(0,"move")
            return directionsToTarget(goal)
        else:
            if direction == "N":
                if goal[1] <= coords[1]: return "turn left"
                else: return "turn right"
            elif direction == "E":
                if goal[0] <= coords[0]: return "turn left"
                else: return "turn right"
            elif direction == "S":
                if goal[1] > coords[1]: return "turn left"
                else: return "turn right"
            else:
                if goal[0] > coords[0]: return "turn left"
                else: return "turn right"

def bfMove():
    global direction,coords
    nc = (0,0)
    status = "P" if "P" in board[coords[0]][coords[1]] else "U"
    if direction == "N" and coords[0] > 0: nc = (coords[0]-1,coords[1])
    elif direction == "E" and coords[1] < 3: nc = (coords[0],coords[1]+1)
    elif direction == "S" and coords[0] < 3: nc = (coords[0]+1,coords[1])
    elif direction == "W" and coords[1] > 0: nc = (coords[0],coords[1]-1)
    else: return
    if board[nc[0]][nc[1]] == " ": board[nc[0]][nc[1]] = status
    else: board[nc[0]][nc[1]] += status
    board[coords[0]][coords[1]] = board[coords[0]][coords[1]].replace(status,"")
    if board[coords[0]][coords[1]] == "": board[coords[0]][coords[1]] = "E"
    coords = nc

def lookingAt(cell):
    global coords, direction
    if direction == "N":
        for i in range(coords[0]-1,-1,-1):
            if (i,coords[1]) == cell: return True
    elif direction == "E":
        for i in range(coords[1]+1,4):
            if (coords[0],i) == cell: return True
    elif direction == "S":
        for i in range(coords[0]+1,4):
            if (i,coords[1]) == cell: return True
    elif direction == "W":
        for i in range(coords[1]-1,-1,-1):
            if (coords[0],i) == cell: return True
    return False

def bfPlay(senses):
    global board, direction, coords, shot, arrows, futureMoves, order, replaced
    for sense in senses:
        if board[coords[0]][coords[1]] == " ": board[coords[0]][coords[1]] = ""
        if sense == "Breeze" and "B" not in board[coords[0]][coords[1]]:
            board[coords[0]][coords[1]] += "B"
        elif sense == "Stench" and "S" not in board[coords[0]][coords[1]] and not replaced:
            board[coords[0]][coords[1]] += "S"
        elif sense == "Glitter" and "G" not in board[coords[0]][coords[1]]:
            board[coords[0]][coords[1]] += "G"
        elif sense == "Scream":
            for r in range(len(board)):
                for c in range(len(board[r])):
                    board[r][c].replace("S","")
            shot = True

    action = ""

    wump = findWumpus()
    found = None
    if wump != None:
        for r in range(len(wump)):
            for c in range(len(wump[r])):
                if wump[r][c] >= 1:
                    found = (r,c)
    if "Glitter" in senses: action = "pick up gold"
    elif coords == (3,0) and "Stench" in senses and arrows > 0: action = "shoot"
    elif found != None and lookingAt(found) and arrows > 0: action = "shoot"
    elif found != None and lookingAt(found):
        for r in range(len(board)):
            for c in range(len(board[r])):
                board[r][c] = board[r][c].replace("S","B")
                replaced = True
        if coords == order[0]: order.pop(0)
        action = directionsToTarget(order[0])
    elif wump != None and wump[peek()[0]][peek()[1]] >= 0.5 and arrows > 0: action = "shoot"
    else:
        if coords == order[0]: order.pop(0)
        action = directionsToTarget(order[0])

    if action == "move":
        bfMove()
        return "move"
    elif action == "turn left":
        direction = wwb.turn(direction,"L")
        wwb.turn(direction,"L")
        return "turn left"
    elif action == "turn right":
        direction = wwb.turn(direction,"R")
        wwb.turn(direction,"R")
        return "turn right"
    elif action == "shoot" and arrows > 0:
        if direction == "N":
            for i in range(coords[0]-1,-1,-1): noWumpus.append((i,coords[1]))
        elif direction == "E":
            for i in range(coords[1]+1,4): noWumpus.append((coords[0],i))
        elif direction == "S":
            for i in range(coords[0]+1,4): noWumpus.append((i,coords[1]))
        elif direction == "W":
            for i in range(coords[1]-1,-1,-1): noWumpus.append((coords[0],i))
        arrows -= 1
        return "shoot"
    elif action == "pick up gold":
        board[coords[0]][coords[1]] = "P"
        order = [(3,0)]
        futureMoves = []
        return "pick up gold"
    if action == "pit":
        futureMoves = []
        return bfPlay(senses)
    else: return "" if arrows == 0 and action == "shoot" else action
        

def play(printScore=True,printBoard=True,stop=True,printStart=False):
    return ww.play(bfPlay,printScore,printBoard,stop,printStart)

def playCB(board,printScore=True,printBoard=True,stop=True,printStart=False):
    return ww.playCB(bfPlay,board,printScore,printBoard,stop,printStart)
