/**
 * Scrabulous
 * 
 * Created by:
 * Robert Crossan (10306563)
 * Niamh Kavanagh (12495522)
 * David McCann (12431298)
 * 
 * Class used to represent the Tiles used to make words.
 */

public class Tile {
	/**
	 * @letter Letter of Tile
	 * @value Point Value of Tile
	 * @count Number of Tiles in full Pool
	 * There is an empty constructor, fully parameterised constructor, getter and setter
	 * methods for each of the variables and an overridden toString method.
	 */
	private char letter;
	private int value, count;
	
	public Tile() {
		this.letter = '0';
		this.value = 0;
		this.count = 0;
	}

	public Tile(char letter, int value, int count) {
		this.letter = letter;
		this.value = value;
		this.count = count;
	}

	/**
	 * get and set Methods for the Tile's Letter
	 */
	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	/**
	 * get and set Methods for the Tile's Value
	 */
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * get and set Methods for the Tile's Count
	 */
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * Override toString
	 */
	public String toString() {
		return "Letter = " + letter + ", Value = " + value;
	}
}