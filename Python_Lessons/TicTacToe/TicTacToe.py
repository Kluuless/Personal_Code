board = []

def resetBoard():
    global board
    board = [[' ',' ',' '],
             [' ',' ',' '],
             [' ',' ',' ']]

def printBoard():
    print("  | 1 | 2 | 3 |")
    print("--+---+---+---+")
    for i in range(3):
        print(str(i+1) + " |",end="")
        for j in range(3):
            print(" " + board[i][j]+" |",end="")
        print("\n--+---+---+---+")

#Create a function to modify the board
#turn is whose turn it is, either 'X' or 'O'
#returns True if turn was taken successfully
def takeTurn(turn, row, col):
    if board[row-1][col-1] == ' ':
        board[row-1][col-1] = turn
        return True
    else: return False

#Returns 'X', 'O', ' ', or 'C' which represents the winner
#'X' if X won, 'O' if O won,
#' ' if there are no winners (yet),
#'C' if it's a cat's game.
def winner():
    rowColDiag = [[board[0][0],board[0][1],board[0][2]],
                  [board[1][0],board[1][1],board[1][2]],
                  [board[2][0],board[2][1],board[2][2]],
                  [board[0][0],board[1][0],board[2][0]],
                  [board[0][1],board[1][1],board[2][1]],
                  [board[0][2],board[1][2],board[2][2]],
                  [board[0][0],board[1][1],board[2][2]],
                  [board[0][2],board[1][1],board[2][0]]]
    if ['X','X','X'] in rowColDiag: return 'X'
    elif ['O','O','O'] in rowColDiag: return 'O'
    elif not ' ' in board[0] and not ' ' in board[1] and not ' ' in board[2]:
        return 'C'
    else: return ' '

#runs the game
def startGame():
    resetBoard()
    current_turn = 'X'
    while winner() == ' ':
        printBoard()
        print("It's " + current_turn + "'s turn.")
        try:
            row = int(input("Enter a row number: "))
            col = int(input("Enter a column number: "))
            if row in range(1,4) and col in range(1,4):
                if takeTurn(current_turn,row,col):
                    current_turn = 'X' if current_turn == 'O' else 'O'
                else: print("Invalid move! Someone already went there!")
                print()
            else: print("Invalid number. Only enter in numbers 1 through 3.")
        except: print("Invalid number. Only enter in numbers 1 through 3.")
    if winner() in ['X','O']: print(winner() + " wins!")
    else: print("Cat's game!")
    printBoard()

startGame()
