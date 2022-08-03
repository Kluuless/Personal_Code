import java.util.Scanner;

public class TicTacToe{
	//Class Attributes
	private char[][] board; //The board. Is a 3x3 array.
	private int turnNumber; //The turn number. Odds is X's turn, evens are O's turn.
	
	//Default (and only) constructor.
	public TicTacToe() {
		this.board = new char[3][3];
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				this.board[row][col] = ' ';
			}
		}
		this.turnNumber = 1;
	}
	
	//Determines the winner of the game.
	//Returns 'X' or 'O' if they won. Returns 'C' if cat's game or ' ' if no winner yet.
	public char winner() {
		boolean cats = true;
		for (int i = 0; i < 3; i++) {
			boolean xWinsRow = true;
			boolean oWinsRow = true;
			boolean xWinsCol = true;
			boolean oWinsCol = true;
			for (int j = 0; j < 3; j++) {
				switch (this.board[i][j]) {
					case 'X': oWinsRow = false; break;
					case 'O': xWinsRow = false; break;
					default: oWinsRow = false; xWinsRow = false; cats = false;
				}
				switch (this.board[j][i]) {
					case 'X': oWinsCol = false; break;
					case 'O': xWinsCol = false; break;
					default: oWinsCol = false; xWinsCol = false; cats = false;
				}
			}
			if (xWinsRow || xWinsCol) { return 'X'; }
			else if (oWinsRow || oWinsCol) { return 'O'; }
		}
		if (this.board[0][0] == board[1][1] && board[1][1] == board[2][2]) { return board[0][0]; }
		else if (this.board[2][0] == board[1][1] && board[1][1] == board[0][2]) { return board[2][0]; }
		else if (cats) { return 'C'; }
		else { return ' '; }
	}
	
	//Take a turn. Give row number and column number. Automatically determines if X's or O's turn.
	//Returns false if board cell is already taken. Returns true if valid move.
	public boolean makeMove(int row, int col) {
		if (board[row-1][col-1] != ' ') { return false; }
		else if (this.turnNumber % 2 == 0) { this.board[row-1][col-1] = 'O'; }
		else { this.board[row-1][col-1] = 'X'; }
		this.turnNumber++;
		return true;
	}
	
	//Resets everything back to the way it was before turn 1.
	public void reset() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				this.board[row][col] = ' ';
			}
		}
		this.turnNumber = 1;
	}
	
	//Returns the current player's turn. 'X' if odd turn number, 'O' if even turn number.
	public char getCurrentTurn() {
		if (this.turnNumber % 2 == 0) { return 'O'; }
		else { return 'X'; }
	}
	
	//Returns the turn number.
	public int getTurnNumber() { return this.turnNumber; }
	
	//Returns a string representation of the board.
	public String toString() {
		String result = "   1   2   3\n";
		for (int row = 0; row < 3; row++) {
			result += row+1;
			for (int col = 0; col < 3; col++) {
				result += " [" + this.board[row][col] + "]";
			}
			result += '\n';
		}
		return result.substring(0,result.length()-1);
	}
	
	public static void main(String[] args) {
		//set up Scanner, for reading user input
		Scanner in = new Scanner(System.in);
		
		//set up game
		TicTacToe game = new TicTacToe();
		
		//main game loop
		while (game.winner() == ' ') {
			System.out.println("Turn " + game.getTurnNumber() + '.');
			System.out.println(game.getCurrentTurn() + "'s turn.");
			System.out.println();
			System.out.println(game.toString());
			System.out.println();
			System.out.print("Which row to go on (1-3)? ");
			int row = -1;
			while (row < 1 || row > 3) {
				try {
					row = Integer.parseInt(in.nextLine());
					if (row < 1 || row > 3) {
						System.out.println("Invalid input. Only numbers 1 to 3 are allowed.");
						System.out.print("Which row to go on (1-3)? ");
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Only numbers 1 to 3 are allowed.");
					System.out.print("Which row to go on (1-3)? ");
					row = -1;
				}
			}
			System.out.print("Which column to go on (1-3)? ");
			int col = -1;
			while (col < 1 || col > 3) {
				try {
					col = Integer.parseInt(in.nextLine());
					if (col < 1 || col > 3) {
						System.out.println("Invalid input. Only numbers 1 to 3 are allowed.");
						System.out.print("Which column to go on (1-3)? ");
					}
				} catch (NumberFormatException e){
					System.out.println("Invalid input. Only numbers 1 to 3 are allowed.");
					System.out.print("Which column to go on (1-3)? ");
					col = -1;
				}
			}
			game.makeMove(row,col);
		}
		
		//print game results
		System.out.println();
		switch (game.winner()) {
			case 'X': System.out.println("X wins!"); break;
			case 'O': System.out.println("O wins!"); break;
			default: System.out.println("Cat's game!");
		}
		System.out.println("Final board:");
		System.out.println(game.toString());
	}
}