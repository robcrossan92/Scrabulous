import java.util.Random;

/**
 * Created by Robert Crossan.
 * Class used to represent the Pool of Tiles used in the game of Scrabble.
 */
public class Pool {
	/**
	 * @POOLSIZE Total possible number of Tiles in the Pool
	 * @ALPHABET Total number of letters in the Alphabet
	 * @remainingTiles Number of Tiles left in the Pool
	 * @pool Store for the Tiles currently in Pool
	 * @alphabet Store for the Letters in the Alphabet
	 */
	Random generator = new Random(System.currentTimeMillis());
	private final int POOLSIZE = 100, ALPHABET = 27;
	private int remainingTiles = POOLSIZE;
	private Tile[] pool = new Tile[POOLSIZE];
	private Tile[] alphabet = new Tile[ALPHABET];

	/**
	 * Constructor: For loop initialises @pool with Tile Objects
	 */
	public Pool() {
		for(int i = 0; i < pool.length; i++) {
			pool[i] = new Tile();
		}
		storeTileValues();
		resetPool();
	}
	
	/**
	 * Stores the value of each tile as Objects of type Tile in the array of Tiles @alphabet
	 */
	public Tile[] storeTileValues() {
		char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','_'};
		int[] values = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10,0};
		int[] counts = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1,2};
		
		for(int i = 0; i < alphabet.length; i++) {
			alphabet[i] = new Tile(letters[i], values[i], counts[i]);
		}
		return alphabet;
	}
		
	/**
	 * Allows the pool to be reset.
	 * It fills the Pool with another 100 Tiles and randomises their order
	 * It also resets the value of @remainingTiles back to @POOLSIZE
	 * Nested for loops are used to run through each letter and make getCount() copies of the tiles
	 */
	public Tile[] resetPool() {
		remainingTiles = POOLSIZE;
		
		for(int i = 0, count = 0; i < alphabet.length; i++) {
			for(int j = 0; j < alphabet[i].getCount(); j++) {
				pool[count] = alphabet[i];
				count++;
			}
		}
		
		for(int i = 0; i < pool.length; i++) {
			int randomPosition = generator.nextInt(pool.length);
			Tile temp = pool[i];
			pool[i] = pool[randomPosition];
			pool[randomPosition] = temp;
		}
		return pool;	
	}

	/**
	 * Allows display of the number of tiles in the pool
	 */
	public int LeftInPool() {
		return remainingTiles;
	}
	
	/**
	 * Allows the pool to be checked to see if it is empty
	 */
	public boolean isEmptyPool() {
		return remainingTiles == 0;
	}
	
	/**
	 * Allows tiles to be drawn at random from the pool
	 * If the pool is empty a new Tile is returned with all zero values.
	 * If the pool is not empty a random tile is chosen from the pool and removed from the array
	 */
	public Tile drawTileFromPool() {
		Tile condition;
		
		if(isEmptyPool()) {
			System.out.println("There is " + LeftInPool() + " tiles left.");
			condition = new Tile();
		}
		
		else {	
			int randomPosition = generator.nextInt(remainingTiles);
			Tile draw = pool[randomPosition];
			
			for (int i = randomPosition; i < pool.length - 1; i++) {
				pool[i] = pool[i+1];
			}
			
			remainingTiles--;
			condition = draw;
		}
		return condition;
	}
	
	/**
	 * @param tile
	 * @return
	 */
	
	public Tile swapTileIntoPool(Tile tile) {
		Tile swapTile = new Tile();
		
		if(isEmptyPool()) {
			System.out.println("There is " + LeftInPool() + " tiles left.");
			swapTile = new Tile ();
		}
		
		else {	
			int randomPosition = generator.nextInt(remainingTiles);
			Tile draw = pool[randomPosition];
			
			for (int i = randomPosition; i < pool.length - 1; i++) {
				pool[i] = pool[i+1];
			}
			
			remainingTiles--;
			swapTile = draw;
		}
		
		pool[remainingTiles] = tile;
		return swapTile;
	}
		
	/**
	 * Allows the value of a tile to be queried
	 */
	public int tileValueLookup(char letter) {
		int value = 0;
		
		for(int i = 0; i < alphabet.length; i++) {
			if(letter == alphabet[i].getLetter()) {
				value = alphabet[i].getValue();
			}
		}
		return value;
	}
}