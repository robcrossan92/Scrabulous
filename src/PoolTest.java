import java.util.Scanner;
import javax.swing.JOptionPane;

public class PoolTest {

public static void main(String[] args){
		Scanner myScanner = new Scanner(System.in);
		Player Player1 = new Player();
		Player Player2 = new Player();
	
		System.out.println("Player 1, please enter your name: ");
		String P1Name = JOptionPane.showInputDialog(null, "Enter Player 1 name:");
		Player1.setPlayerName(P1Name);
		String P2Name = JOptionPane.showInputDialog(null, "Enter Player 2 name:");
		Player2.setPlayerName(P2Name);
		System.out.println(Player1.getPlayerFrame());
		System.out.println(Player2.getPlayerFrame());
		Player2.resetPlayer(Player2);
		}
	
}