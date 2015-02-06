import java.util.Scanner;

import javax.swing.JOptionPane;

public class Player {

	public int playerScore = 0;
	String PlayerName;		//
	
	public void setName(String n){		//Allows name of player to be set
		PlayerName = n;
	}
	
	public String getName() {			//Allows display of player name
		return PlayerName;
	}
	
	//Returns players current score
	public int getCurrentScore()
	{
		return playerScore;
	}

	
	
	//Adds points from users entered word to players score
	public void addScore(String word)
	{
		int addedScore = 0;
		
		addedScore = getNewScore();
		playerScore += addedScore;
		System.out.println("Score after move is: " +addedScore+ " points.");
  
	} 

	//Returns players current score
	public int getCurrentScore()
	{
		return playerScore;
	}

}
