import javax.swing.JOptionPane;

/**
 * Scrabulous
 * 
 * Created by:
 * Robert Crossan (10306563)
 * Niamh Kavanagh (12495522)
 * David McCann (12431298)
 * 
 * Class used to represent the Players of The game and store their data.
 */

public class Player {
	
	/**
	 * @playerPool Stores of tiles used in game
	 * @playerFrame Stores player's Frame of Tiles
	 * @playerScore Stores player's Score
	 * @playerName Store player's Name
	 */
	private static Pool playerPool = new Pool();
	private Frame playerFrame;
	private int playerScore;
	private String playerName;
	
	/**
	 * Constructor
	 */
	public Player(String name) {
		this.playerName = name;
		this.playerScore = 0;
		this.playerFrame = new Frame(playerPool);
	}
	
	/**
	 * Allows display of a players name
	 */
	public String getPlayerName() {
		return playerName;
	}
	
	public String enterWord(String word){
		//String word = JOptionPane.showInputDialog(null, "Enter word:");
		return word;
	}
	/**
	 * Allows the name of the player to be set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * Allows access to their score
	 */
	public int getPlayerScore() {
		return playerScore;
	}

	/**
	 * Allows the player's score to be set
	 */
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	
	/**
	 * Allows access to a player’s frame (tiles)
	 */
	public Frame getPlayerFrame() {
		return playerFrame;
	}

	/**
	 * Allows the player's Frame to be set
	 */
	public void setPlayerFrame(Frame playerFrame) {
		this.playerFrame = playerFrame;
	}

	/**
	 * get and set Methods for the Pool in use in the game
	 */
	public static Pool getPlayerPool() {
		return playerPool;
	}
	
	public void setPlayerPool(Pool pool) {
		Player.playerPool = pool;
	}
	
	/**
	 * Allows the player data to be reset
	 * @return new Object of Type Player
	 */
	public Player resetPlayer() {
		String newPlayer = JOptionPane.showInputDialog(null, "Enter Reset Player name:");
		Player player = new Player(newPlayer);
		return player;	
	}
	
	/**
	 * Allows a player’s score to be increased
	 * @param scoreForRound to be added to player's current total points
	 */
	public void increasePlayerScore(int scoreForRound) {		
		scoreForRound += getPlayerScore();
		setPlayerScore(scoreForRound);
	}
}