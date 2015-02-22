import javax.swing.JOptionPane;

/**
 * Scrabulous
 * 
 * Created by:
 * Robert Crossan (10306563)
 * Niamh Kavanagh (12495522)
 * David McCann (12431298)
 * 
 * Class used to test the Classes & Methods Attached to Board.
 */

public class BoardTest {

	public static void main(String[] args) {
		//Stores the current tile positions, stores the square values (e.g. triple word score)
		Board board = new Board();
		int row1 = 8, row2 = 8;
		int col1 = 8, col2 = 7;
		char dir1 = 'd', dir2 = 'R';
		
		Player player1 = new Player("P1Name");
		Player player2 = new Player("P2Name");
		
		//Displays the current board using ASCII characters on the console
		System.out.println(board);
		
		//Player 1 - Turn 1
		System.out.println("Player 1:\n" + player1.getPlayerFrame());
		String word1 = JOptionPane.showInputDialog(null, "Enter word:");
		board.playWord(row1, col1, word1, player1, dir1);
		System.out.println("Is first word on centre: " + board.isFirstWordOnCentre(word1));							//Expected true
		System.out.println("Is word within bounds: " + board.isWordWithinBounds(row1, col1, word1));				//Expected true
		System.out.println("Is word conflicted: " + board.isWordConflicted(row1, col1, word1, player1, dir1));	//Expected false
		System.out.println("Is word connected: " + board.isWordConnected(row1, col1, word1, player1, dir1));	//Expected false
		System.out.println(board);
		
		//Player 2 - Turn 2
		System.out.println("Player 2:\n" + player2.getPlayerFrame());
		String word2 = JOptionPane.showInputDialog(null, "Enter word:");
		board.playWord(row2, col2, word2, player2, dir2);
		System.out.println("Is first word on centre: " + board.isFirstWordOnCentre(word2));							//Expected false
		System.out.println("Is word within bounds: " + board.isWordWithinBounds(row2, col2, word2));				//Expected false
		System.out.println("Is word conflicted: " + board.isWordConflicted(row2, col2, word2, player2, dir2));	//Expected false
		System.out.println("Is word connected: " + board.isWordConnected(row2, col2, word2, player2, dir2));	//Expected false
		System.out.println(board);
		
		//Player 1 - Turn 2
//		System.out.println("Player 1:\n" + player1.getPlayerFrame());
//		word1 = JOptionPane.showInputDialog(null, "Enter word:");
//		board.playWord(row1, col1, word1, player1, dir1);
//		System.out.println("Is first word on centre: " + board.isFirstWordOnCentre(word1));							//Expected true
//		System.out.println("Is word within bounds: " + board.isWordWithinBounds(row1, col1, word1));				//Expected true
//		System.out.println("Is word conflicted: " + board.isWordConflicted(row1, col1, word1, player1, dir1) + "\n");	//Expected false
//		System.out.println("Is word connected: " + board.isWordConnected(row1, col1, word1, player1, dir1) + "\n");	//Expected false
//		System.out.println(board);

		//Reset board
		board.resetBoard();
		System.out.println(board);		
	}
}