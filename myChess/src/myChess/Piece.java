package myChess;

import java.util.Collection;
import java.util.List;

public abstract class Piece {

	protected final int piecePosition;
	protected final boolean isFirstMove;
	protected final Alliance pieceAlliance;
	
	Piece( final int piecePosition,final Alliance pieceAlliance){
		
		this.piecePosition=piecePosition;
		this.pieceAlliance=pieceAlliance;
		this.isFirstMove=false;
		
	}
	
 
	public  boolean isFirstMove() {
		return this.isFirstMove;
	}

	public abstract Collection<Move> calculateLegalMove(final Board board);
	
	
	protected Alliance getPieceAlliance() {
		return this.pieceAlliance;
	}

}
