package recursion;
import java.util.*;
public class NQueen { 
	public int board[][];
	public int dimensionOfBoard;
	
	public NQueen(int size){
		if(size<=0){
			throw new IllegalStateException("Board dimension should be a positive number");
		}
		board = new int[size][size];
		dimensionOfBoard = size;
		for(int i=0; i<dimensionOfBoard; i++)
			for(int j=0; j<dimensionOfBoard; j++)
				this.board[i][j] = 0;
	}
	/**
	 * Function to print the board
	 * @param board Two dimensional array which contains the position of queens represented by 1
	 */
	void printBoard() 
	{ 
		for (int i = 0; i < this.dimensionOfBoard; i++) { 
			for (int j = 0; j < this.dimensionOfBoard; j++) 
				System.out.print(" " + this.board[i][j] + " "); 
			System.out.println(); 
		} 
	} 

	/**
	 * To check if a queen can be inserted at a particular place([Row, Column])
	 * @param board Two Dimensional array in which position of a queen is represented by 1
	 * @param row Row value
	 * @param col Column Value
	 * @return true if a queen can be inserted at the given place without violating any condition otherwise false
	 */
	boolean isKill(int row, int col) 
	{ 
		int i, j; 

		// to check the left side of the column
		for (i = 0; i < col; i++) 
			if (this.board[row][i] == 1) 
				return false; 

		// to check the upper diagonal of the board
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
			if (this.board[i][j] == 1) 
				return false; 

		// to check the lower diagonal of the board
		for (i = row, j = col; j >= 0 && i < this.dimensionOfBoard; i++, j--) 
			if (this.board[i][j] == 1) 
				return false; 
		//If none of the above mentioned conditions is true then return true
		return true; 
	} 

	/**
	 * Function to check if a board of particular dimension is possible which satisfy all constraint
	 * Board is filled column wise
	 * During the process of board filling if current combination of row and column does'nt satisfy the constraint then the code backtracks.
	 * @param board Two dimensional array which is going to be checked
	 * @param column 
	 * @return
	 */
	boolean nQueen(int column) 
	{ 
		// If column reaches to dimension of the board then there is a possible board.
		if (column >= this.dimensionOfBoard) 
			return true; 

		//Consider the given column and try all the rows of this column
		for (int i = 0; i < this.dimensionOfBoard; i++) { 
			// Check for all the constraints
			if (this.isKill(i, column)) { 
				// Insert the queen at [i,column] position
				board[i][column] = 1; 

				// recursive call to check other columns
				if (nQueen(column + 1) == true) 
					return true; 

				/* If placing queen in board[i][col] 
				doesn't lead to a solution then 
				remove queen from board[i][col]. Now Backtrack*/
				board[i][column] = 0; 
			} 
		} 

		// if there is no possibility then return false
		return false; 
	} 

	

	// driver program to test above function 
	public static void main(String args[]) 
	{ 	
		int dimension;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the board");
		dimension = sc.nextInt();
		NQueen queen = new NQueen(dimension); 
		if(queen.nQueen(0)){
			System.out.println("Solution Exist");
			queen.printBoard();
		}
		else{
			System.out.println("Solution does'nt exist");
		}
		sc.close();
	} 
} 
