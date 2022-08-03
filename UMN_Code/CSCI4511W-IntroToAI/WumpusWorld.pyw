import WumpusWorldBoard as wwb

def play(func,printScore=False,printBoard=True,stop=False,printStart=False):
    board = wwb.board_init()
    return playCB(func,board,printScore,printBoard,stop,printStart)

def playCB(func,board,printScore=False,printBoard=True,stop=False,printStart=False):
    score = 0
    shot = False
    arrows = 1
    moved = (False,False)
    direction = "N"
    holdingGold = False
    turn = 1
    if printStart:
        print("Here's the board at the start:")
        wwb.printBoard(board)
        print()
    while not wwb.won(board) and not wwb.lost(board):
        if turn >= 1000: break
        if printBoard:
            wwb.printBoard(board)
            print()
        if stop: input()
        senses = wwb.sense(board,holdingGold)
        if shot: senses.append("Scream"); shot = False
        if moved[0] and not moved[1]: score += 1
        if moved[0] and not moved[1]: senses.append("Bump")
        moved = (False,False)
        action = func(senses)
        if action == "move":
            moved = (True,wwb.move(board,direction,holdingGold))
        elif action == "turn right":
            direction = wwb.turn(direction,"R")
        elif action == "turn left":
            direction = wwb.turn(direction,"L")
        elif action == "shoot":
            shot = wwb.shoot(board,direction)
            score -= 9
        elif action == "pick up gold" and not holdingGold:
            holdingGold = wwb.pickUpGold(board)
        elif action == "pick up gold": pass
        else: print("Invalid action: " + action)
        score -= 1
        turn += 1
    
    if wwb.won(board): score += 1000
    if printScore:
        if wwb.won(board):
            print("Victory! Score:",score)
            print("Won in",turn,"turns.\n")
        else:
            print("Failure! Score:",score)
            print("Lost in",turn,"turns.\n")
        print("Here's the board:")
        wwb.printBoard(board)
    return (wwb.won(board),score)
