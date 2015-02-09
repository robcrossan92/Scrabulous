import javax.swing.JOptionPane;

/**
 * Scrabulous
 * 
 * Created by:
 * Robert Crossan (10306563)
 * Niamh Kavanagh (12495522)
 * David McCann (12431298)
 * 
 * Class used to test all other classes and methods.
 */

public class PlayerTest {

public static void main(String[] args) {
		Pool pool = Player.getPlayerPool();
		
		//Asks user to input player name and stores it in Player Object
		String P1Name = JOptionPane.showInputDialog(null, "Enter Player 1 name:");
		Player Player1 = new Player(P1Name);
		
		//Tests methods for getting Player Details
		System.out.println("Player 1: Name: \n" + Player1.getPlayerName() + "\n");
		System.out.println("Player 1: Score: \n" + Player1.getPlayerScore() + "\n");
		System.out.println("Player 1: Frame: \n" + Player1.getPlayerFrame() + "\n");
		
		//Removes and replaces chosen Tile from Frame
		Player1.getPlayerFrame().replaceTilesInFrame(4);
		System.out.println("Player 1: Changed Tile (4): \n" + Player1.getPlayerFrame() + "\n");
		
		//Gets Value of chosen Tile
		System.out.println("Player 1: Tile 4 Value: \n" + Player1.getPlayerFrame().getTileFromFrame(4).getValue() + "\n");
		
		//Asks user to reset player name and in doing so resets Player Object
		Player1 = Player1.resetPlayer();
		System.out.println("Player 1: Reset Frame: " + Player1.getPlayerName() + "\n" + Player1.getPlayerFrame() + "\n");
		System.out.println("-----------------------------------------\n");

		String P2Name = JOptionPane.showInputDialog(null, "Enter Player 2 name:");
		Player Player2 = new Player(P2Name);

		System.out.println("Player 2: Name: \n" + Player2.getPlayerName() + "\n");
		System.out.println("Player 2: Score: \n" + Player2.getPlayerScore() + "\n");
		System.out.println("Player 2: Frame: \n" + Player2.getPlayerFrame() + "\n");
		Player2.getPlayerFrame().replaceTilesInFrame(3);
		System.out.println("Player 2: Changed Tile (3): \n" + Player2.getPlayerFrame() + "\n");
		System.out.println("Player 2: Tile 3 Value: \n" + Player2.getPlayerFrame().getTileFromFrame(3).getValue() + "\n");
		Player2 = Player2.resetPlayer();
		System.out.println("Player 2: Reset Frame: " + Player2.getPlayerName() + "\n" + Player2.getPlayerFrame() + "\n");
		System.out.println("-----------------------------------------\n");
		
		//Test methods for the Pool Class
		System.out.println("Left in Pool: " + pool.leftInPool());
		System.out.println("Is Pool Empty: " + pool.isEmptyPool());
		System.out.println("Player 2: Tile Value LookUp: Tile (3): " + pool.tileValueLookup(Player2.getPlayerFrame().getTileFromFrame(3).getLetter()));
	}
}