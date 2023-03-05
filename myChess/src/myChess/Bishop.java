package myChess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import myChess.Move.AttackMove;
import myChess.Move.MajorMove;

public class Bishop extends Piece {
	
	private final int[]  CANDIDATE_MOVE_COORDINATE= {-7,-9,7,9};

	Bishop(int piecePosition, Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<Move> calculateLegalMove(Board board) {
		// TODO Auto-generated method stub
		final List<Move> legalMoves=new ArrayList<>();
		for(final int candidateCoordinateOffset: CANDIDATE_MOVE_COORDINATE) {
			
			int candidateDestinationCoordinate=this.piecePosition;
			
			while(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
			if(isFirstColumnExclusion(candidateDestinationCoordinate, candidateCoordinateOffset)||
					isFirstColumnExclusion(candidateDestinationCoordinate, candidateCoordinateOffset)) {
			break;	
			
			}
				
				candidateDestinationCoordinate+=candidateCoordinateOffset;
				if(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
					
					final Tile candidateDestinationTile=board.getTile(candidateDestinationCoordinate);
					if(!candidateDestinationTile.isTileOccupied()) {
						
						legalMoves.add(new MajorMove(board,this,candidateDestinationCoordinate));
					}else {
						final Piece pieceAtDestination=candidateDestinationTile.getPiece();
						final Alliance pieceAlliance=pieceAtDestination.getPieceAlliance();
						if(this.pieceAlliance !=pieceAlliance) {
							legalMoves.add( new AttackMove(board,this,candidateDestinationCoordinate,pieceAtDestination));
						}
						break;
					}
				
					
				}
			}
		}
		
		return ImmutableList.copyOf(legalMoves);
	}
	
	public static boolean isFirstColumnExclusion(final int currentPosition,final int candidateOffset){
		return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset ==-9||candidateOffset==7 );
			
	}
	public static boolean isEightColumnExclusion(final int currentPosition,final int candidateOffset){
		return BoardUtils.EIGHT_COLUMN[currentPosition] && (candidateOffset ==-7||candidateOffset==9 );
			
	}
}
