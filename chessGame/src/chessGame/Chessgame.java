package chessGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Chessgame {
	
	static Image imgs[]=new Image[12];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Piece> pieceCollection=new LinkedList<Piece>();
	//	File img=new File("C:\\Users\\UZIBEN NIG. LTD\\Downloads\\chess.png");
		
	//	try {
	//	BufferedImage allImage=ImageIO.read(new File("C:\\Users\\UZIBEN NIG. LTD\\Downloads\\chess.png"));
		//	Image[] imgs=new Image[12];
	//		int id=0;
	//	System.out.print(imgs[0]);
	//		for (int i=0;i<400;i+=200) {
		//		for(int j=0;j<1200;j+=200) {
		//		//imgs[id]=allImage.getSubimage(i, j, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH)	;
				//id++;
			
		//}
		//	}	
		//	File sample=new File("C:\\Users\\UZIBEN NIG. LTD\\Downloads\\twitter.png");
		//BufferedImage image=new BufferedImage(200,200,BufferedImage.TYPE_INT_ARGB);
		
		//	image=ImageIO.read(sample);
			
			
			
		//	System.out.println("images are shoeing now"+ image);
			
	//	} catch (IOException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
		//BufferedImage image1=new BufferedImage(200, 200,BufferedImage.TYPE_INT_ARGB);
	//	File output=new File("C:\\Users\\UZIBEN NIG. LTD\\Downloads\\Test4.png");
	//	try {
	//		ImageIO.write(image1, "png", output);
	//		System.out.println("done");
	//	} catch (IOException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}
		//pieceCollection.add(new Piece(1,0,true,"King",pieceCollection));
		Piece bKing=new Piece(4,0,false,"King",pieceCollection);
		Piece bQueen=new Piece(3,0,false,"Queen",pieceCollection);
		Piece b1Rock=new Piece(0,0,false,"Rock",pieceCollection);
		Piece b2Rock=new Piece(7,0,false,"Rock",pieceCollection);
		Piece b1Bishop=new Piece(2,0,false,"Bishop",pieceCollection);
		Piece b2Bishop=new Piece(5,0,false,"Bishop",pieceCollection);
		Piece b1Knight=new Piece(1,0,false,"Knight",pieceCollection);
		Piece b2Knight=new Piece(6,0,false,"Knight",pieceCollection);
		Piece b1Pawn=new Piece(0,1,false,"Pawn",pieceCollection);
		Piece b2Pawn=new Piece(1,1,false,"Pawn",pieceCollection);
		Piece b3Pawn=new Piece(2,1,false,"Pawn",pieceCollection);
		Piece b4Pawn=new Piece(3,1,false,"Pawn",pieceCollection);
		Piece b5Pawn=new Piece(4,1,false,"Pawn",pieceCollection);
		Piece b6Pawn=new Piece(5,1,false,"Pawn",pieceCollection);
		Piece b7Pawn=new Piece(6,1,false,"Pawn",pieceCollection);
		Piece b8Pawn=new Piece(7,1,false,"Pawn",pieceCollection);
		//placing white Pieces
		
	
		
		JFrame frame=new JFrame();
		frame.setBounds(10,10,530,550);
		JPanel panel=new JPanel() {
			@Override
			public void paint(Graphics g) {
				
				File img=new File("C:\\Users\\UZIBEN NIG. LTD\\Downloads\\chess.png");
				
				try {
					BufferedImage image=ImageIO.read(img);
					int id=0;
					while(id<12) {
					for(int y=0;y<2;y++) {
						for(int x=0;x<6;x++) {
							imgs[id] =image.getSubimage(x*200, y*200, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
						//	g.drawImage(imgs[id], x*50,y*50,this);
						
							id++;
						}//end of the inner loop
						
						
					}//end of the outer loop
					//g.drawImage(imgs[6], 300,300,this);
					}
					
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
			
			
				
				
				
				
				
				
				
				
				
				boolean white=true;
				for (int i=0;i<8;i++) {
					for(int j=0;j<8;j++){
						
						if(white) {
							g.setColor(Color.WHITE);
						}else {
							g.setColor(new Color(119,148,85));
						}
						
						g.fillRect(i*64, j*64,64,64);
						white=!white;
						
					}
					
					white=!white;
				}
				
				for (Piece piece : pieceCollection) {
					int id=0;
					
					if(piece.pieceName.equalsIgnoreCase("King")) {
						id=0;
					}
					if(piece.pieceName.equalsIgnoreCase("Queen")) {
						id=1;
					}
					if(piece.pieceName.equalsIgnoreCase("Bishop")) {
						id=2;
					}
					if(piece.pieceName.equalsIgnoreCase("Knight")) {
						id=3;
					}
					if(piece.pieceName.equalsIgnoreCase("Rock")) {
						id=4;
					}
					
					if(piece.pieceName.equalsIgnoreCase("Pawn")) {
						id=5;
					} 
					
					if(!piece.isWhite) {
						id=id+6;
					}
					 
					
					g.drawImage(imgs[id],piece.xPoint*64 ,piece.yPoint*64, this);
					//System.out.print(wKing);
					//g.drawImage(imgs[0], 300,300,this);
				}
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		};
		
		
		
		
		frame.add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}

}
