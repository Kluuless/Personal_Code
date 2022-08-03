import java.util.Scanner;
/**
 * Plays a game of tic tac toe.
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class TicTacToe
{
    public static void printBoard(char[][] board)
    {
        String toPrint = "";
        for (int r = 0; r < board.length; r++)
        {
            toPrint += " ";
            for (int c = 0; c < board[r].length; c++)
            {
                toPrint += board[r][c];
                toPrint += " | ";
            }
            toPrint = toPrint.substring(0,toPrint.length() - 3);
            toPrint += "\n---+---+---\n";
        }
        toPrint = toPrint.substring(0,toPrint.length()-13);
        System.out.println(toPrint);
    }

    public static void testBoard()
    {
        char[] ex1 = {'X',' ','O'};
        char[] ex2 = {'X','O',' '};
        char[] ex3 = {' ','X',' '};
        char[][] exBoard = {ex1,ex2,ex3};
        printBoard(exBoard);
    }

    public static String gameEnded(char[][] board)
    {
        String result = "";
        boolean allCellsFilled = true;
        for (int r = 0; r < 3; r++)
        {
            boolean colWin = true;
            char colCell = board[r][0];
            boolean rowWin = true;
            char rowCell = board[0][r];
            for (int c = 0; c < 3; c++)
            {
                if (board[r][c] != colCell || board[r][c] == ' ')
                {
                    colWin = false;
                }
                if (board[c][r] != rowCell || board[r][c] == ' ')
                {
                    rowWin = false;
                }
                if (board[r][c] == ' ')
                {
                    allCellsFilled = false;
                }
            }
            if (colWin)
            {
                result = board[r][0] + " wins!";
            }
            if (rowWin)
            {
                result = board[0][r] + " wins!";
            }
        }
        if (board[1][1] != ' ')
        { 
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
            {
                result = board[0][0] + " wins!";
            }
            if (board[0][2] == board[1][1] && board[2][0] == board[1][1])
            {
                result = board[1][1] + " wins!";
            }
        }
        if (board[0][1] != ' ')
        {
            if (board[1][1] == board[0][1] && board[2][1] == board[0][1])
            {
                result = board[0][1] + " wins!";
            }
        }
        if (board[0][0] != ' ')
        {
            if (board[0][0] == board[2][0] && board[2][0] == board[1][0])
            {
                result = board[0][0] + " wins!";
            }
        }
        if (board[0][2] != ' ')
        {
            if (board[0][2] == board[1][2] && board[1][2] == board[2][2])
            {
                result = board[2][2] + " wins!";
            }
        }
        if (allCellsFilled && result.equals(""))
        {
            result = "Cat's game (it's a tie)!";
        }
        return result;
    }

    public static void game()
    {
        char[][] board = new char[3][3];

        for (int r = 0; r < 3; r++)
        {
            for (int c = 0; c < 3; c++)
            {
                board[r][c] = ' ';
            }
        }

        Scanner in = new Scanner(System.in);

        boolean isFinished = false;
        int turn = 1;

        System.out.println("For future reference, the top left cell is (1,1)");
        System.out.println("Convention is (row,column).");
        System.out.println("So, the bottom right cell is (3,3).");
        System.out.println("\nLet's begin!\n");

        while (!isFinished)
        {
            printBoard(board);
            if (gameEnded(board).equals(""))
            {
                if (turn % 2 == 1)
                {
                    System.out.println("It's X's turn.");
                    System.out.print("What row do you want to go in? ");
                    int xRow = in.nextInt() - 1;
                    if (xRow < 0 || xRow > 2)
                    {
                        System.out.println("Please try again with an integer between 1 and 3.");
                    }
                    else
                    {
                        System.out.print("What column do you want to go in? ");
                        int xCol = in.nextInt() - 1;
                        if (xCol < 0 || xRow > 2)
                        {
                            System.out.println("Please try again with an integer between 1 and 3.");
                        }
                        else if (board[xRow][xCol] != ' ')
                        {
                            System.out.println("|" + board[xRow][xCol] + "|");
                            System.out.println("That cell already has a value. Please try a different cell.");
                        }
                        else
                        {
                            board[xRow][xCol] = 'X';
                            System.out.println("Action completed.");
                            turn++;
                        }
                    }
                }
                else
                {
                    System.out.println("It's O's turn.");
                    System.out.print("What row do you want to go in? ");
                    int oRow = in.nextInt() - 1;
                    if (oRow < 0 || oRow > 2)
                    {
                        System.out.println("Please try again with an integer between 1 and 3.");
                    }
                    else
                    {
                        System.out.print("What column do you want to go in? ");
                        int oCol = in.nextInt() - 1;
                        if (oCol < 0 || oRow > 2)
                        {
                            System.out.println("Please try again with an integer between 1 and 3.");
                        }
                        else if (board[oRow][oCol] != ' ')
                        {
                            System.out.println("|" + board[oRow][oCol] + "|");
                            System.out.println("That cell already has a value. Please try a different cell.");
                        }
                        else
                        {
                            board[oRow][oCol] = 'O';
                            System.out.println("Action completed.");
                            turn++;
                        }
                    }
                }
                System.out.println();
            }
            else
            {
                isFinished = true;
            }
        }
        System.out.println(gameEnded(board));
    }
}
