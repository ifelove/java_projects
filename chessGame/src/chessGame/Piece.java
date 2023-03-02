package chessGame;

import java.util.LinkedList;
import java.util.function.Consumer;

public class Piece{
	int xPoint;// the piece y axis location
	int yPoint;// the piece y axis location
	boolean isWhite;//to know which player owns the particular piece
	LinkedList<Piece> piecesCollection;
	String pieceName;
public Piece(int xPoint,int yPoint,boolean isWhite,String pieceName,LinkedList<Piece> piecesCollection) {
	
	this.xPoint=xPoint;
	this.yPoint=yPoint;
	this.isWhite=isWhite;
	this.pieceName=pieceName;
	this.piecesCollection=piecesCollection;
	piecesCollection.add(this);
}


public void move(int xPoint,int ypoint){
	for( Piece piece : piecesCollection) {
		
		//if(piece.xPoint==xPoint && piece.yPoint==yPoint) 
		{
			piecesCollection.stream().filter((p)->(p.yPoint==yPoint && p.xPoint==xPoint)).forEachOrdered((p)->{p.kill();});
			//piece.kill();
			
		}
	}
	this.xPoint=xPoint;
	this.yPoint=yPoint;
	
	
}


public void kill(){
	
	piecesCollection.remove(this);
}


}
