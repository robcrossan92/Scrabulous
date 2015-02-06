import java.util.Random;
class Frame{
	
	// Variables initialised
	Random random = new Random();
	final int BIG = 100, frameNumber = 7;
	Pool pool = new Pool();
	Tile[] tileArray = new Tile[BIG];
	private char tile;
	int total;
	
	// Constructs the frame with 7 tiles.
	public Frame(){
		total = 0;
		for (int i = 0; i < frameNumber; i++) {
			tileArray[i] = pool.drawTileFromPool();
			total++;
		}
	}
	
	// Method to get the value of the tile generated
	public Object getValue(int tilePosition){
		return tileArray[tilePosition];
	}
	
	// Method to print all tiles in the frame. 
	public void printTiles(){
		for (int i = 0; i < frameNumber; i++) {
			System.out.println(tileArray[i] + " ");
		}
		System.out.print("\n");
	}
	
	// Gets the size of the frame
	public int size(){
		return total;
	}
	
	//  Replaces any tiles that have been removed
	public void replaceTiles(){
		for (int i = 0; i < frameNumber; i++) {
			if (tileArray[i].getLetter() == '_') {
				tileArray[i] = pool.drawTileFromPool();
			}
		}
	}
	
	// Completely refill frame.
	public void reFill(){
		total = 0;
		for (int i = 0; i < frameNumber; i++) {
			tileArray[i] =  pool.drawTileFromPool();
			total++;
		}
	}
	
	// Removes a chosen tile from the Frame
	public void removeTile(char letter){
		for (int i = 0; i < frameNumber; i++) {
			if (tileArray[i].getLetter() == letter) {
				tileArray[i].setLetter('_');
			}
		}
	}
	
	// Checks whether a chosen letter is in the frame
	public void letterCheck(char letter){
		int checker = 0;
		for (int i = 0; i < frameNumber; i++) {
			if (tileArray[i].getLetter() == letter) {
				checker++;
			}
		}
		if (checker > 0) {
			System.out.println("Letter " + letter + " is in the frame.");
		}
		else {
			System.out.println("Letter " + letter + " is not in the frame.");
		}
	}
	
	// Checks whether the frame is empty or not
	public Boolean isEmpty(){
		if (total == -1) {
			return true;
		}
		else {
			return false;
		}
	}
}