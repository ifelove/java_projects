package myChess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.ImmutableList;

import myChess.Move.MajorMove;

public class Pawn extends Piece {
	
	private final int[]  CANDIDATE_MOVE_COORDINATE= {8,16};

	Pawn(int piecePosition, Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<Move> calculateLegalMove(Board board) {
		
		final List<Move> legalMoves=new ArrayList<>();
		// TODO Auto-generated method stub
		
		for(final int currentCandidateOffset:CANDIDATE_MOVE_COORDINATE) {
			
		final	int candidateDestinationCoordinate=this.piecePosition+(this.pieceAlliance.getDirection()*currentCandidateOffset);
			
			if(!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
				
				continue;
			}
			
			if(currentCandidateOffset==8 && !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
				//todo more work here
				legalMoves.add(new MajorMove(board,this,candidateDestinationCoordinate));
			}else if(currentCandidateOffset==16 && this.isFirstMove() && (BoardUtils.SECOND_ROW[this.piecePosition] &&
					this.getPieceAlliance().isBlack())||(BoardUtils.SECOND_ROW[this.piecePosition] &&
							this.getPieceAlliance().isWhite())) {
				
				final int behindCandidateDestinationCoordinate=this.piecePosition+(this.pieceAlliance.getDirection()*8);
				if(!board.getTile(behindCandidateDestinationCoordinate).isTileOccupied()&&
						!board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
					legalMoves.add(new MajorMove(board,this,candidateDestinationCoordinate));
				}
			}
		}
		
		
		return ImmutableList.copyOf(legalMoves);
	}

}
