/**
 * Scrabulous
 * 
 * Created by:
 * Robert Crossan (10306563)
 * Niamh Kavanagh (12495522)
 * David McCann (12431298)
 * 
 * Class used to represent the Frame of Tiles used by each Player.
 */

class Frame {
	
	/**
	 * @FRAMESIZE Total number of Tiles in the Frame
	 * @tilePool Allows Pool to accessible by all methods in the Frame
	 * @frameArray Stores the Tiles currently in the Frame
	 */
	private final int FRAMESIZE = 7, total;
	private Pool tilePool;
	private Tile[] frameArray = new Tile[FRAMESIZE];
	
	
	/**
	 * Stores the letters that each player has in their frame
	 */
	public Frame(Pool pool) {
		total = 0;
		tilePool = pool;
		refillFrameFromPool();
	}
		

	/**
	 * Allows letters to be removed from a frame and replaced with another one
	 */
	public void replaceTilesInFrame(int tileNumber) {
		frameArray[tileNumber - 1] = tilePool.swapTileIntoPool(frameArray[tileNumber - 1]);
	}
	
	/**
	 * Allows a check to be made if letters are in the frame
	 */
	public boolean checkLetterInFrame(char letter) {
		boolean check = false;
		for (int i = 0; i < FRAMESIZE; i++)
		{
			if (frameArray[i].getLetter() == letter)
			{
				check = true;
			}
		}
		return check;
	}
	
	/**
	 * Allows a check to be made to see if the frame is empty
	 */
	public Boolean isEmptyFrame() {
		return total == 0;
	}
	
	/**
	 * Allows access to the letters in the frame
	 */
	public Tile getTileFromFrame(int tileNumber) {
		return frameArray[tileNumber - 1];
	}
	
	/**
	 * Allows a frame to be refilled from the pool
	 */
	public void refillFrameFromPool() {
		for (int i = 0; i < FRAMESIZE; i++)
		{
			frameArray[i] =  tilePool.drawTileFromPool();
		}
	}
	
	/**
	 * Allows a frame to be displayed
	 */
	public String toString() {
		String print = "";
		for (int i = 0; i < FRAMESIZE; i++)
		{
			print += "Tile " + (i + 1) + ": " + frameArray[i] + "\n";
		}
		return print;
	}
}