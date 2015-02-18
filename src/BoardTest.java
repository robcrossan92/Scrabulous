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
		//int CENTRE = 7;
		Board board = new Board();
		Player Player1 = new Player("P1Name");
		//Player Player2 = new Player("P2Name");
		System.out.println(board);
		System.out.println(Player1.getPlayerFrame());
		String word = JOptionPane.showInputDialog(null, "Enter word:");
		board.placeDown(7, 7, word, Player1);
		System.out.println(board);
		System.out.println(board.checkFirstWordOnCentre(word));
		//System.out.println(board.checkFrameForWord(board.getPlayer1(), board.getPlayer1().enterWord(word)));
		System.out.println(Player1.getPlayerFrame());
		word = JOptionPane.showInputDialog(null, "Enter word:");
		board.placeRight(8, 7, word, Player1);
		//board.placeRight(2, 3, word, board.getPlayer1());
		System.out.println(board);
		System.out.println(Player1.getPlayerFrame());
		
		
		
	}
}