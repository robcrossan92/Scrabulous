import java.util.Scanner;

import javax.swing.JOptionPane;

public class Player {
	
	//variables of type frame
	Frame playerFrame;
	
	private int playerScore;
	private String PlayerName;		

	//allow access to frame
	public void getPlayerFrame() {
		playerFrame.printTiles();
	}
	
	//allow access to frame
	public void setPlayerFrame(Frame playerFrame) {
		this.playerFrame = new Frame();
	}

	//allows access to player score
	public int getPlayerScore() {
		return playerScore;
	}


	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}


	public String getPlayerName() {
		return PlayerName;
	}

	//method to allow player name to be set
	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}

	//Constructor
	public Player(){
		this.PlayerName = "";
		this.playerScore = 0;
		this.playerFrame = new Frame();
	}
	
	//Constructor
	public Player(String name, int score, Frame frame){
		this.PlayerName = name;
		this.playerScore = score;
		this.playerFrame = frame;
	}
	
	public void setPlayer(){
		Player player = new Player();
		player.setPlayerFrame(playerFrame);
	}

	//method to allow player data to be reset
	public Player resetPlayer(Player p){
		p = new Player();
		return null;	
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
