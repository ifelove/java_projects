package myChess;

public  class BoardUtils {
	
	public static final boolean[] FIRST_COLUMN = initColumn(0);
	
	public static final boolean[] SECOND_COLUMN = initColumn(1);
	public static final boolean[] SEVENTH_COLUMN =  initColumn(6);
	public static final boolean[] EIGHT_COLUMN = initColumn(7);
	
	
	
	public static final boolean[] SECOND_ROW = {true,false};
	public static final boolean[] SEVENTH_ROW = {true,false};
	
	

public static int NUM_TILE=64;
public static int NUM_TILE_PER_ROW=8;

	private BoardUtils() {
		
		throw new  RuntimeException("You can not instianate");
	}
	
	
	public static boolean isValidTileCoordinate(int coordinate) {
		
		return coordinate >=0 &&  coordinate <NUM_TILE;
	}

	
private static boolean[] initColumn(int column_number) {
		
		final boolean[] column =new boolean[NUM_TILE];
		
		do {
			column[column_number]=true;
			column_number+=NUM_TILE_PER_ROW;
			
			
		}
		while(column_number<NUM_TILE);
		return column;
	}

}
