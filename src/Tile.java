/**
 * Created by Robert Crossan.
 * Class used to describe the Tills found in the Pool in the Scrabble game.
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

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String toString() {
		return "Letter = " + letter + ", Value = " + value + ", Count = " + count;
	}
}