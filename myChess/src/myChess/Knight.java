package myChess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.ImmutableList;

import myChess.Move.AttackMove;
import myChess.Move.MajorMove;

public class Knight extends Piece {
	
	
	private final int[]  CANDIDATE_MOVE_COORDINATE= {-17,-15,-10,-6,6,10,15,17};

	Knight(final int piecePosition,final Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);
		
	}

	@Override
	public Collection<Move> calculateLegalMove(final Board board) {
		
		
	final List<Move> legalMoves=new ArrayList<>();
		for( final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATE ) {
		 int candidateDestinationCoordinate;
			candidateDestinationCoordinate=this.piecePosition + currentCandidateOffset;
			 
			if(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
	
				
				if(isFirstColumn(this.piecePosition,currentCandidateOffset)||
						isSecondColumn(this.piecePosition,currentCandidateOffset)||
						isSeventhColumn(this.piecePosition,currentCandidateOffset)||
						isEightColumn(this.piecePosition,currentCandidateOffset)) {
					
					continue;
				}
				
				
				final Tile candidateDestinationTile=board.getTile(candidateDestinationCoordinate);
				if(!candidateDestinationTile.isTileOccupied()) {
					
					legalMoves.add(new MajorMove(board,this,candidateDestinationCoordinate));
				}else {
					final Piece pieceAtDestination=candidateDestinationTile.getPiece();
					final Alliance pieceAlliance=pieceAtDestination.getPieceAlliance();
					if(this.pieceAlliance !=pieceAlliance) {
						legalMoves.add( new AttackMove(board,this,candidateDestinationCoordinate,pieceAtDestination));
					}
				}
			}
			
		}
		
		return ImmutableList.copyOf(legalMoves);
	}

	public static boolean isFirstColumn(final int currentPosition,final int candidateOffset) {
		
		return BoardUtils.FIRST_COLUMN[currentPosition] && ((candidateOffset == -17)|| (candidateOffset == -10) ||candidateOffset == 6 ||candidateOffset == 15);
		
		
	}
	
public static boolean isSecondColumn(final int currentPosition,final int candidateOffset) {
		
		return BoardUtils.SECOND_COLUMN[currentPosition] && ((candidateOffset == -10)|| (candidateOffset == 6));
		
		
	}

public static boolean isSeventhColumn(final int currentPosition,final int candidateOffset) {
	
	return BoardUtils.SEVENTH_COLUMN[currentPosition] && ((candidateOffset == -6)|| (candidateOffset == 10));
	
	
}

public static boolean isEightColumn(final int currentPosition,final int candidateOffset) {
	
	return BoardUtils.EIGHT_COLUMN[currentPosition] && ((candidateOffset == -15)|| (candidateOffset == -6) ||candidateOffset == 10 ||candidateOffset == 17);
	
	
}

}  
