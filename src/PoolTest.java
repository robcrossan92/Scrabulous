public class PoolTest {

	public static void main(String[] args) {
		Pool test = new Pool();
		
		test.drawTileFromPool();
		for(int i = 0; i < 50; i++) {
			System.out.println(test.drawTileFromPool().toString());
		}
		System.out.println(test.isEmptyPool());
		for(int i = 0; i < 49; i++) {
			System.out.println(test.drawTileFromPool().toString());
		}
		System.out.println(test.isEmptyPool());
		test.resetPool();
	}
}