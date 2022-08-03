import java.util.Scanner;

public class TicTacToe2 {
	//the member attributes of the tic tac toe game
	private char[] board; //the board of length 9
	private char turn; //whose turn it is
	
	//initializes the member attributes of a tic tac toe game
	public TicTacToe2() {
		this.board = new char[9]; //initialize the board
		for (int i = 0; i < 9; i++) { this.board[i] = ' '; } //set all elements to a space
		this.turn = 'X'; //initialize the turn to x
	}
	
	//determines the winner of the board
	//returns 'X', 'O' if either won. Returns 'C' if cat's game. Returns ' ' if no winner yet.
	public char winner() {
		boolean catsGame = true;
		for (int i = 0; i < 3; i++) {
			boolean xRowWins = true; //if x wins on this row
			boolean oRowWins = true; //if o wins on this row
			boolean xColWins = true; //if x wins on this column
			boolean oColWins = true; //if o wins on this column
			for (int j = 0; j < 3; j++) { //scan through row of value i and column of value i
				//i*3+j follows the following order: 0 1 2 3 4 5 6 7 8 (traces an 'E' on the board)
				if (this.board[i*3+j] == 'X') { oRowWins = false; }
				else if (this.board[i*3+j] == 'O') { xRowWins = false; }
				else {
					xRowWins = false;
					oRowWins = false;
					catsGame = false;
				}
				//i*3+j follows the following order: 0 3 6 1 4 7 2 5 8 (traces an 'M' on the board)
				if (this.board[j*3+i] == 'X') { oColWins = false; }
				else if (this.board[j*3+i] == 'O') { xColWins = false; }
				else {
					xColWins = false;
					oColWins = false;
					catsGame = false;
				}
			}
			if (xRowWins || xColWins) { return 'X'; } //if X has won on the row or column
			if (oRowWins || oColWins) { return 'O'; } //if O has won on the row or column
		}
		if (catsGame) { return 'C'; } //cat's game
		else if (this.board[0] == this.board[4] && this.board[4] == this.board[8]) { return this.board[0]; } // '\' diagonal
		else if (this.board[2] == this.board[4] && this.board[4] == this.board[6]) { return this.board[2]; } // '/' diagonal
		else { return ' '; } //no one won
	}
	
	//takes a turn, returns true if valid move (if no one has gone there before), false otherwise
	public boolean takeTurn(int row, int col) {
		if (this.board[(row-1)*3+(col-1)] == ' ') {
			this.board[(row-1)*3+(col-1)] = this.turn;
			if (this.turn == 'X') { this.turn = 'O'; }
			else { this.turn = 'X'; }
			return true;
		} else {
			return false;
		}
	}
	
	//returns the board in string form
	public String toString() {
		String result = "   1   2   3";
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0) { result += "\n" + (i/3+1); }
			result += " [" + this.board[i] + "]";
		}
		return result;
	}
	
	//returns the current turn
	public char currentTurn() { return this.turn; }
	
	//polls the user for an answer of 1, 2, or 3. Does not end until a valid answer is given.
	public static int pollUser(Scanner scanner, String question) {
		int answer; //declare the answer
		while (true) {
			System.out.println(question);
			System.out.println("Your valid answers are 1, 2, or 3.");
			try { answer = Integer.parseInt(scanner.next()); } //attempt to turn the answer (a String) to an integer
			catch (NumberFormatException e) { answer = -1; } //if attempt fails
			if (answer < 1 || answer > 3) { System.out.println("Invalid Answer.\n"); } //if invalid answer
			else { return answer; } //if valid answer (ends the method)
		}
	}
	
	//main game method
	public static void main(String[] args) {
		//initialize Scanner object
		Scanner scanner = new Scanner(System.in);
		
		//set up the game
		TicTacToe2 game = new TicTacToe2();
		
		//game loop
		while (game.winner() == ' ') {
			System.out.println("The board:");
			System.out.println(game.toString());
			System.out.println("It is " + game.currentTurn() + "'s turn.");
			int row = pollUser(scanner,"Which row do you want to go on?");
			int col = pollUser(scanner,"Which column do you want to go on?");
			if (!game.takeTurn(row,col)) { System.out.println("Someone already went there! Try again."); }
		}
		
		if (game.winner() == 'C') {
			System.out.println("Cat's game!");
		} else if (game.winner() == 'X') {
			System.out.println("X won!");
		} else {
			System.out.println("O won!");
		}
		System.out.println("Final board:");
		System.out.println(game.toString());
	}
}