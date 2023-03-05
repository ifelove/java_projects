package myChess;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public abstract class Tile {
	
	private final Map<Integer,EmptyTile> EMPTY_TILES_CACHE=createAllPossibleEmptyTiles();
	
	private static Map<Integer,EmptyTile> createAllPossibleEmptyTiles(){
		
		final Map<Integer,EmptyTile> emptyTileMap=new HashMap<>();
		
		for(int i=0;i<BoardUtils.NUM_TILE;i++) {
			
			emptyTileMap.put(i, new EmptyTile(i));
		}
		
		//Collection.unmodifiableMap(emptyMap);
		return ImmutableMap.copyOf(emptyTileMap);
	}
	
	
	public Tile createTile(final int tileCoordinate,Piece piece) {
		return piece != null ? new OccupiedTile(tileCoordinate,piece):EMPTY_TILES_CACHE.get(tileCoordinate);
	}

	protected final int tileCoordinate;
	private Tile(final int tileCordinate) {
		
		this.tileCoordinate=tileCordinate;
	}
	
	public abstract boolean isTileOccupied();
	
	public abstract  Piece getPiece();
	
	
	public static final class EmptyTile extends Tile{
		
		EmptyTile(final int coordinate){
			
			super(coordinate);
		} 
		@Override
		public  boolean isTileOccupied() {
			
			return false;
		}
		@Override
		public  Piece getPiece() {
			
			return null;
		}
	}
	//
	
public static final class OccupiedTile extends Tile{
		
	private final Piece pieceOnTile;
		OccupiedTile( int tileCoordinate, Piece pieceOnTile){
			
			super(tileCoordinate);
			this.pieceOnTile=pieceOnTile;
		} 
		@Override
		public  boolean isTileOccupied() {
			
			return true;
		}
		@Override
		public  Piece getPiece() {
			
			return pieceOnTile;
		}
	}
	
}
