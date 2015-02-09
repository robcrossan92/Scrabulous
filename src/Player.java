import javax.swing.JOptionPane;

public class Player {
	
	//variables of type frame
	private Frame playerFrame;
	private int playerScore;
	private String playerName;
	
	//Constructor
	public Player(String name) {
		this.playerName = name;
		this.playerScore = 0;
		this.playerFrame = new Frame();
	}

	public String getPlayerName() {
		return playerName;
	}

	//method to allow player name to be set
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	//allows access to player score
	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	
	public Frame getPlayerFrame() {
		return playerFrame;
	}

	public void setPlayerFrame(Frame playerFrame) {
		this.playerFrame = playerFrame;
	}

	//method to allow player data to be reset
	public Player resetPlayer(){
		String newPlayer = JOptionPane.showInputDialog(null, "Enter Reset Player name:");
		Player player = new Player(newPlayer);
		return player;	
	}
	
	//Adds points from users entered word to players score
	public void addScore(String word)
	{
		int addedScore = 0;
		
		addedScore = getPlayerScore();
		playerScore += addedScore;
		System.out.println("Score after move is: " +addedScore+ " points.");
  
	} 
}
