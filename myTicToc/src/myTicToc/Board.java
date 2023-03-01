package myTicToc;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class Board {
	
	 final int col=3;
	 final int row=3;
	 final int vaccantBoardValue=0;
	 final int player1Occupied=1;
	 final int player2Occupied=2;
	public int[][] board;
	public int eachSpot_height=300/row;
	public int eachSpot_width=300/col;
	
	
	
	public Board() {
	
	board=new int[row][col];
	
	for(int i = 0;i<board.length;i++) {
		for(int j=0;j<board[i].length;j++) {
			
			//System.out.print(i+""+j+"  ");
			//System.out.print(i+""+j);
			//if (j==2) System.out.print('\n');
			board[i][j]=vaccantBoardValue;
			
		}
		
	}
	
	
	
	

	}

	
	
	
	
	
	
	
	public void draw(Graphics2D g) {
		
		int x=0;
		int y=0;
		
		for( int i=0;i<board.length;i++) {
			
			for(int j=0;j<board[i].length;j++) {
			
				g.setColor(Color.GRAY);
				g.fillRect(j*eachSpot_width,i*eachSpot_height,eachSpot_width , eachSpot_height);
				
				g.setStroke( new BasicStroke(3));
				g.setColor(Color.BLUE);
				g.drawRect(j*eachSpot_width,i*eachSpot_height, eachSpot_width, eachSpot_height);
				
				//if(j==0) {x=1/2;}
				g.setColor(Color.GREEN);
				g.setFont(new Font("Serif",Font.BOLD,30));
				if(board[i][j]==1) {g.drawString("X", x*90+50, y*90+60);}
				if(board[i][j]==2) {g.drawString("Y", x*90+50, y*90+60);}
				
				
				
				x++;
			
			}
			
			x=0;
			
			y++;
			
		}
		
		
	}


	
}
