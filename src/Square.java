/**
 * Scrabulous
 * 
 * Created by:
 * Robert Crossan (10306563)
 * Niamh Kavanagh (12495522)
 * David McCann (12431298)
 * 
 * Class used to represent the Squares that make up the Board.
 */

public class Square {
	
	/**
	 * @placedTile Stores the Tile once it is placed on a Square
	 * @letterMultiply Amount a Square can multiply a Letter
	 * @wordMultiply Amount a Square can multiply a Word
	 */
	Tile placedTile;
	int letterMultiply, wordMultiply;
	
	/**
	 * Constructor
	 * @placedTile has a null Tile constructed onto it to make printing the Board easier
	 * @letterMutliply & @wordMultiply are set to 1 as most positions don't have a multiplier
	 */
	Square() {
		placedTile = new Tile();
		letterMultiply = 1;
		wordMultiply = 1;
	}

	/**
	 * get and set Methods for the Square's Tile Placement
	 */
	public Tile getPlacedTile() {
		return placedTile;
	}

	public void setPlacedTile(Tile placedTile) {
		this.placedTile = placedTile;
	}

	/**
	 * get and set Methods for the Square's Letter Multiply
	 */
	public int getLetterMultiply() {
		return letterMultiply;
	}

	public void setLetterMultiply(int letterMultiply) {
		this.letterMultiply = letterMultiply;
	}

	/**
	 * get and set Methods for the Square's Word Multiply
	 */
	public int getWordMultiply() {
		return wordMultiply;
	}

	public void setWordMultiply(int wordMultiply) {
		this.wordMultiply = wordMultiply;
	}
	
	/**
	 * Override toString
	 */
	public String toString() { 
		return "  ---  \n" +
			   " | " + getWordMultiply() + " | \n" +
			   "  ---  ";
	}
}