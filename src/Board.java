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

/**
 * To Do:
 * check if word overlaps (i.e. strict with -ly appended to strictly) - Rob
 * check if word is parallel (i.e. c a t
 * 								     t o m a t o) - Rob
 * numbering on side of board (change toString())- Rob
 * giving blank tiles a value (possibly setBlankTile() method?)- Rob
 *
 */

public class Board {
	/**
	 * @DIMENSION Total dimension of the Board
	 * @board Stores the current Tile positions
	 * @turnCount Counter for player turns
	 * @pool Gives the board access to Pool
	 */
	private final int DIMENSION = 15;
	private Square[][] board = new Square[DIMENSION][DIMENSION];
	private int turnCount = 0;
	Pool pool = Player.getPlayerPool();
	
	/**
	 * Constructor
	 * Resets the Board to Reset the game and then sets the Squares Multipliers
	 */
	Board() {
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
	
	/** 
	 * Checks the player's frame for the necessary tiles to make up a word.
	 */
	public boolean isWordInFrame(int row, int col, String word, Player player, char direction) {
		boolean check = true;
		int count = 0;
		
		for(int i = 0; i < word.length(); i++) {
			char checkLetter = word.charAt(i);
			if((direction == 'r') || (direction == 'R')) {
				for(int j = 0; j < player.getPlayerFrame().size(); j++) {
					if(checkLetter == player.getPlayerFrame().getTileFromFrame(j+1).getLetter()) {
						count++;
						break;
					}
					else if(checkLetter == board[row][col+j].getPlacedTile().getLetter()){
						count++;
						break;
					}
				}
			}
			if((direction == 'd') || (direction == 'D')) {
				for(int j = 0; j < player.getPlayerFrame().size(); j++) {
					if(checkLetter == player.getPlayerFrame().getTileFromFrame(j+1).getLetter()) {
						count++;
						break;
					}
					else if(checkLetter == board[row+j][col].getPlacedTile().getLetter()){
						count++;
						break;
					}
				}
			}
		}
		if(count == word.length()) {
			check = true;
		}
		return check;
	}
	
	/**
	 * Checks whether placement is within bounds of board
	 */
	public boolean isWordWithinBounds(int row, int col, String word) {
		boolean check = false;
		
		if(((word.length()-1) + row <= 15) || ((word.length()-1) + col <= 15)) {
			check = true;
		} 
		return check;
	}
	
	/**
	 * Checks if word conflicts with words on the board (i.e. a word meets a none blank tile)
	 */
	public boolean isWordConflicted(int row, int col, String word, Player player, char direction) {
		boolean check = false;

		for(int i = 0; i < word.length(); i++) {
			char checkLetter = word.charAt(i);
			
			if((direction == 'r') || (direction == 'R')) {
				for (int j = col; j < (word.length()-1) + col; j++) {
					if(checkLetter != board[row][j].getPlacedTile().getLetter()) {
						check = true;
					}	
				}
			}
			if((direction == 'd') || (direction == 'D')) {
				for (int j = row; j < (word.length()-1) + row; j++) {
					if(checkLetter != board[j][col].getPlacedTile().getLetter()) {
						check = true;
					}
				}
			}
		}
		return check;
	}
	
	/**
	 * Check whether at least one letter from the rack is used
	 */
	public boolean isLetterPlayed(String word) {
		boolean check = false;
		
		if(word.length() > 0) {
			check = true;
		}
		return check;
	}
	
	/** 
	 * Check whether the first word is placed on center square.
	 */
	public boolean isFirstWordOnCentre(String word) {
		boolean check = false;
		int count = 0;

		if(turnCount == 1) {
			for(int i = 0; i < word.length(); i++) {
				char checkLetter = word.charAt(i);
				if(checkLetter == board[7][7].getPlacedTile().getLetter()) {
					count++;
				}
			}
			
			if(count > 0) {
				check = true;
			}
		}
		return check;
	}
		
	/**
	 * Checks if word connected with existing words
	 */
	public boolean isWordCrossing(int row, int col, String word, Player player, char direction) {
		boolean check = false;
		
		for(int i = 0; i < word.length(); i++) {
			char checkLetter = word.charAt(i);
			
			if((direction == 'r') || (direction == 'R')) {
				for (int j = col; j < (word.length()-1) + col; j++) {
					if(checkLetter == board[row][j].getPlacedTile().getLetter()) {
						check = true;
					}	
				}
			}
			if((direction == 'd') || (direction == 'D')) {
				for (int j = row; j < (word.length()-1) + row; j++) {
					if(checkLetter == board[j][col].getPlacedTile().getLetter()) {
						check = true;
					}
				}
			}
		}
		return check;
	}
		
	/** 
	 * Method which plays a users move. Takes in player, word, position and direction user wants to play.
	 */
	public void playWord(int row, int col, String word, Player player, char direction) {
		//if(isWordInFrame(player, word) == true) {
			//System.out.println("Is word in frame: " + isWordInFrame(player, word));
			
			if((direction == 'r') || (direction == 'R')) {
				for(int i = 0; i < word.length(); i++) {
					char checkLetter = word.charAt(i);
					
					for(int j = 0; j < 7; j++) {
						if(checkLetter == player.getPlayerFrame().getTileFromFrame(j+1).getLetter()) {
							if(' ' == board[row-1][col-1].getPlacedTile().getLetter()) {
								board[row-1][col-1].setPlacedTile(player.getPlayerFrame().getTileFromFrame(j+1));
								player.getPlayerFrame().replaceTilesInFrame(j+1);
								col++;
								break;
							}
							else if(checkLetter==board[row-1][col-1].getPlacedTile().getLetter()){
								board[row-1][col-1].setPlacedTile(player.getPlayerFrame().getTileFromFrame(j+1));
								col++;
								break;
							}
						}
						else if(checkLetter == board[row-1][col-1].getPlacedTile().getLetter()){
							col++;
							break;
						}
					}
				}
			}
			if(direction == 'd' || direction == 'D') {
				for(int i = 0; i < word.length(); i++) {
					char checkLetter = word.charAt(i);
					
					for(int j = 0; j < 7; j++) {
						if(checkLetter == player.getPlayerFrame().getTileFromFrame(j+1).getLetter()) {
							if(' ' == board[row-1][col-1].getPlacedTile().getLetter()) {
								board[row-1][col-1].setPlacedTile(player.getPlayerFrame().getTileFromFrame(j+1));
								player.getPlayerFrame().replaceTilesInFrame(j+1);
								row++;
								break;
							}
							else if(checkLetter==board[row-1][col-1].getPlacedTile().getLetter()){
								board[row-1][col-1].setPlacedTile(player.getPlayerFrame().getTileFromFrame(i+1));
								row++;
								break;
							}
						}
						else if(checkLetter== board[row-1][col-1].getPlacedTile().getLetter()){
							row++;
							break;
						}
					}
				}
			}
			turnCount++;
		}
	//}
	
	/** 
	 * Displays the current board using ASCII characters on the console
	 * Override toString method
	 */
	public String toString() {
		String display = "";
		
		for(int i = 0; i < DIMENSION; i++) {
			display = display + "------------------------------------------------------------------------------------------- \n";
			for(int j = 0; j < DIMENSION; j++) {
				display = display + board[i][j] + " ";
			}
			display = display + "|\n";
		}
		display = display + "------------------------------------------------------------------------------------------- \n";
		return display;
	}
}