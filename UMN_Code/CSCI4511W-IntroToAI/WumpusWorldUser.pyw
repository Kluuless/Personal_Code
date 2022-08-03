import WumpusWorld as ww
import WumpusWorldBoard as wwb

board = [[" "," "," "," "],
         [" "," "," "," "],
         [" "," "," "," "],
         ["U"," "," "," "]]

direction = "N"
ds = {"N":"North","E":"East","S":"South","W":"West"}
coords = (3,0)
shot = False
turns = 1

def printCode():
    print("The code:")
    print("'U': where the user is.")
    print("' ': unexplored cell.")
    print("'E': empty cell.")
    print("'B': there's a breeze here.")
    print("'S': there's a stench here.")
    print("'G': there's a glitter here.")
    print("'P': where the user is (carrying gold)")
    print()

def printActions():
    if shot: print("You may move ('m'), turn left ('l'), turn right('r'), " + \
                   "shoot your arrow ('s'), or try to pick up gold ('p').")
    else: print("You may move ('m'), turn left ('l'), turn right('r'), " + \
                "or try to pick up gold ('p').")

def userMove():
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

def user(senses):
    global board, direction, coords, turns
    print("Turn " + str(turns) + ":")
    turns += 1
    printCode()
    for sense in senses:
        if board[coords[0]][coords[1]] == " ": board[coords[0]][coords[1]] = ""
        if sense == "Breeze" and "B" not in board[coords[0]][coords[1]]:
            print("You sense a breeze here.")
            board[coords[0]][coords[1]] += "B"
        elif sense == "Stench" and "S" not in board[coords[0]][coords[1]]:
            print("You smell a stench here.")
            board[coords[0]][coords[1]] += "S"
        elif sense == "Glitter" and "G" not in board[coords[0]][coords[1]]:
            print("You hear a glitter.")
            board[coords[0]][coords[1]] += "G"
        elif sense == "Bump": print("You've hit a wall.")
        elif sense == "Scream":
            print("You hear a scream. You've killed the wumpus!")
            for r in range(len(board)):
                for c in range(len(board[r])):
                    board[r][c].replace("S","")
        else: print("You don't sense anything new.")
    if len(senses) > 0: print()
    else: print("You don't sense anything.\n")
    
    print("Here's the board:")
    wwb.printBoard(board)
    print("You are facing ",ds[direction].lower(),".",sep="")

    printActions()
    action = input("What would you like to do? ").lower()
    if action in ["move","m"]:
        print("Moving.\n")
        userMove()
        return "move"
    elif action in ["turn left","tl","l","left"]:
        print("Turning left.\n")
        direction = wwb.turn(direction,"L")
        wwb.turn(direction,"L")
        return "turn left"
    elif action in ["turn right","right","tr","r"]:
        print("Turning right.\n")
        direction = wwb.turn(direction,"R")
        wwb.turn(direction,"R")
        return "turn right"
    elif not shot and action in ["shoot my arrow","shoot","s"]:
        print("Shooting arrow.\n")
        shot = True
        return "shoot"
    elif action in ["pick up gold","pick up","pickup","p"]:
        if board[coords[0]][coords[1]] == 'P':
            print("Already carrying gold!\n")
            return "pick up gold"
        elif "Glitter" in senses:
            print("Picking up gold.\n")
            board[coords[0]][coords[1]] = "P"
            return "pick up gold"
        else:
            print("There's no gold here!\n")
            return "pick up gold"
    return "" if shot and action == shoot else action
        

ww.play(user,True,False,False,False)
