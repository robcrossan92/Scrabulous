/**
 * Scrabulous
 * 
 * Created by:
 * Robert Crossan (10306563)
 * Niamh Kavanagh (12495522)
 * David McCann (12431298)
 * 
 * Class used to represent the playing Board where the Tiles are placed.
 */

public class Board {
	/**
	 * @DIMENSION Total dimension of the Board
	 * @board Stores the current Tile positions
	 */
	private final int DIMENSION = 15;
	private Square[][] board = new Square[DIMENSION][DIMENSION];
	
	/**
	 * Constructor
	 * Resets the Board to Reset the game and then sets the Squares Multipliers
	 */
	Board () {
		resetBoard();
		setMultipliers();
	}
	
	/**
	 * Allows the board to be reset
	 */
	public void resetBoard() {
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				board[i][j] = new Square();
			}
		}
	}
	
	/**
	 * Sets which squares in the Board Array have multipliers 
	 */
	public void setMultipliers() {
		int[][] doubleLetter = {{0,3}, {0,11}, {2,6}, {2,8}, {3,0}, {3,7}, {3,14}, {6,2}, 
								{6,6}, {6,8}, {6,12}, {7,3}, {7,11}, {8,2}, {8,6}, {8,8}, 
								{8,12}, {11,0}, {11,7}, {11,14},{12,6}, {12,8}, {14,3}, {14,11}};
		int[][] tripleLetter = {{1,5}, {1,9}, {5,1}, {5,5}, {5,9}, {5,13}, 
								{9,1}, {9,5}, {9,9}, {9,13}, {13,5}, {13,9}};
		int[][] doubleWord = {{1,1}, {2,2}, {3,3}, {4,4}, {10,10}, {11,11}, {12,12}, {13,13}, {1,13}, 
							  {2,12}, {3,11}, {4,10}, {10,4}, {11,3}, {12,2}, {13,1}, {7,7}};
		int[][] tripleWord = {{0,0}, {0,14}, {14,0}, {14,14}, {7,0}, {7,14}, {0,7}, {14,7}};

		for(int i = 0, j = 0; i < doubleLetter.length; i++) {board[doubleLetter[i][j]][doubleLetter[i][j+1]].setLetterMultiply(2);}
		for(int i = 0, j = 0; i < tripleLetter.length; i++) {board[tripleLetter[i][j]][tripleLetter[i][j+1]].setLetterMultiply(3);}
		for(int i = 0, j = 0; i < doubleWord.length; i++) {board[doubleWord[i][j]][doubleWord[i][j+1]].setWordMultiply(2);}
		for(int i = 0, j = 0; i < tripleWord.length; i++) {board[tripleWord[i][j]][tripleWord[i][j+1]].setWordMultiply(3);}
	}
}