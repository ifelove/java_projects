package chessGame;

import java.util.LinkedList;
import java.util.function.Consumer;

public class Piece{
	int xPoint;// the piece y axis location
	int yPoint;// the piece y axis location
	boolean isWhite;//to know which player owns the particular piece
	LinkedList<Piece> piecesCollection;
	String pieceName;
	int x;
	int y;
public Piece(int xPoint,int yPoint,boolean isWhite,String pieceName,LinkedList<Piece> piecesCollection) {
	
	this.xPoint=xPoint;
	this.yPoint=yPoint;
	this.isWhite=isWhite;
	this.pieceName=pieceName;
	x=xPoint*64;
	y=yPoint*64;
	this.piecesCollection=piecesCollection;
	piecesCollection.add(this);
}


public void move(int xPoint,int ypoint){
	
	if(Chessgame.getPiece(xPoint*64, ypoint*64)!=null) {
		
		if(Chessgame.getPiece(xPoint*64, ypoint*64).isWhite!=isWhite) {
			Chessgame.getPiece(xPoint*64, ypoint*64).kill();
		}else {
			x=this.xPoint*64;
			y=this.yPoint*64;
			return;
		}
		
		
	}
		
		this.xPoint=xPoint;
		this.yPoint=yPoint;
	//	x=this.xPoint*64;
	//	y=this.yPoint*64;
	
		
	}
	
	
	
	
	///for( Piece piece : piecesCollection) {
		
		//if(piece.xPoint==xPoint && piece.yPoint==yPoint) 
	///	{
	///		piecesCollection.stream().filter((p)->(p.yPoint==yPoint && p.xPoint==xPoint)).forEachOrdered((p)->{p.kill();});
			//piece.kill();
			
	///	}
	///}
	


public void kill(){
	
	piecesCollection.remove(this);
}


}
