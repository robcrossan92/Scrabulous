import javax.swing.JOptionPane;

public class PlayerTest {

public static void main(String[] args){
		Pool pool = Player.getPlayerPool();
		
		String P1Name = JOptionPane.showInputDialog(null, "Enter Player 1 name:");
		Player Player1 = new Player(P1Name);
		
		System.out.println("Player 1: Name: \n" + Player1.getPlayerName() + "\n");
		System.out.println("Player 1: Score: \n" + Player1.getPlayerScore() + "\n");
		System.out.println("Player 1: Frame: \n" + Player1.getPlayerFrame() + "\n");
		Player1.getPlayerFrame().replaceTiles(4);
		System.out.println("Player 1: Changed Tile (4): \n" + Player1.getPlayerFrame() + "\n");
		System.out.println("Player 1: Tile 4 Value: \n" + Player1.getPlayerFrame().getTile(4).getValue() + "\n");
		Player1 = Player1.resetPlayer();
		System.out.println("Player 1: Reset Frame: " + Player1.getPlayerName() + "\n" + Player1.getPlayerFrame() + "\n");
		System.out.println("-----------------------------------------\n");

		String P2Name = JOptionPane.showInputDialog(null, "Enter Player 2 name:");
		Player Player2 = new Player(P2Name);

		System.out.println("Player 2: Name: \n" + Player2.getPlayerName() + "\n");
		System.out.println("Player 2: Score: \n" + Player2.getPlayerScore() + "\n");
		System.out.println("Player 2: Frame: \n" + Player2.getPlayerFrame() + "\n");
		Player2.getPlayerFrame().replaceTiles(3);
		System.out.println("Player 2: Changed Tile (3): \n" + Player2.getPlayerFrame() + "\n");
		System.out.println("Player 2: Tile 3 Value: \n" + Player2.getPlayerFrame().getTile(3).getValue() + "\n");
		Player2 = Player2.resetPlayer();
		System.out.println("Player 2: Reset Frame: " + Player2.getPlayerName() + "\n" + Player2.getPlayerFrame() + "\n");
		System.out.println("-----------------------------------------\n");
		System.out.println("Left in Pool: " + pool.LeftInPool());
		System.out.println("Is Pool Empty: " + pool.isEmptyPool());
		System.out.println("Player 2: Tile Value LookUp: Tile (3): " + pool.tileValueLookup(Player2.getPlayerFrame().getTile(3).getLetter()));
	}
}