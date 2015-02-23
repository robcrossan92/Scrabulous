import javax.swing.JOptionPane;

/**
 * Scrabulous
 * 
 * Created by:
 * Robert Crossan (10306563)
 * Niamh Kavanagh (11495511)
 * David McCann (11431198)
 * 
 * Class used to test the Classes & Methods Attached to Board.
 */

public class BoardTest {

	public static void main(String[] args) {
		//Stores the current Tile positions, stores the Square values
		Board board = new Board();
		int row1 = 8, row2 = 8, row3 = 10, row4 = 15;
		int col1 = 8, col2 = 7, col3 = 9, col4 = 6;
		char dir1 = 'd', dir2 = 'r', dir3 = 'd', dir4 = 'r';
		String word = " ";
		
		Player player = new Player("Player 1");
		
		//Displays the current Board using ASCII characters on the console
		System.out.println(board);
		
		//Turn 1
		System.out.println(player + ":\n" + player.getPlayerFrame());
		word = JOptionPane.showInputDialog(null, "Enter word: ");
		//Allows a word to be placed on the Board
		//Checks if a Player’s frame of Tiles has the necessary letters
		//Checks if the word connects with words already on the Board either by crossing or being parallel
		board.playWord(row1, col1, word, player, dir1);
		//Checks if the placement is within the bounds of the Board
		System.out.println("Is word within bounds: " + board.isWordWithinBounds(row1, col1, word));
		//Checks if the word conflicts with any existing letters
		System.out.println("is word conflicting with other words: " + board.isWordConflicted(row1, col1, word, player, dir1));
		//Checks if the word uses at least one letter from the frame
		System.out.println("Is at least one letter used: " + board.isLetterPlayed(word));
		//Checks if it is the first word and whether it is in the centre of the Board
		System.out.println("Is first word on centre: " + board.isFirstWordOnCentre(word));
		System.out.println();

		//Turn 2
		System.out.println(board);
		System.out.println(player + ":\n" + player.getPlayerFrame());
		word = JOptionPane.showInputDialog(null, "Enter word:");
		board.playWord(row2, col2, word, player, dir2);
		System.out.println("Is word within bounds: " + board.isWordWithinBounds(row2, col2, word));
		System.out.println("is word conflicting with other words: " + board.isWordConflicted(row2, col2, word, player, dir2));
		System.out.println("Is at least one letter used: " + board.isLetterPlayed(word));
		System.out.println("Is first word on centre: " + board.isFirstWordOnCentre(word));
		System.out.println();
		
		//Turn 3
		System.out.println(board);
		System.out.println(player + ":\n" + player.getPlayerFrame());
		word = JOptionPane.showInputDialog(null, "Enter word:");
		board.playWord(row3, col3, word, player, dir3);
		System.out.println("Is word within bounds: " + board.isWordWithinBounds(row3, col3, word));
		System.out.println("is word conflicting with other words: " + board.isWordConflicted(row3, col3, word, player, dir3));
		System.out.println("Is at least one letter used: " + board.isLetterPlayed(word));
		System.out.println("Is first word on centre: " + board.isFirstWordOnCentre(word));
		System.out.println();

		//Turn 4
		System.out.println(board);
		System.out.println(player + ":\n" + player.getPlayerFrame());
		word = JOptionPane.showInputDialog(null, "Enter word:");
		board.playWord(row4, col4, word, player, dir4);
		System.out.println("Is word within bounds: " + board.isWordWithinBounds(row4, col4, word));
		System.out.println("is word conflicting with other words: " + board.isWordConflicted(row4, col4, word, player, dir4));
		System.out.println("Is at least one letter used: " + board.isLetterPlayed(word));
		System.out.println("Is first word on centre: " + board.isFirstWordOnCentre(word));
		System.out.println();
		
		//Allows the Board to be reset
		System.out.println(board);
		board.resetBoard();
		System.out.println("\nReset Board:\n" + board);		
	}
}