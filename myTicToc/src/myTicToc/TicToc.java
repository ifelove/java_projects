package myTicToc;

import java.awt.Color;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicToc extends JPanel implements ActionListener,MouseListener,KeyListener {
	Board board;
	
	int pointXclicked;
	int pointYclicked;
	boolean playerX=true;
	boolean gameOn=true;
	
	public TicToc() {
		addKeyListener(this);
		
		
		board=new Board();
		
		addMouseListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		this.setOpaque(false);
		
		
	}

	
	
	
	public void paint(Graphics g) {
		
		
		 g.setColor(Color.white);
		 g.fillOval (120,200, 20, 20);
		 
		
	
		
		
		
		board.draw((Graphics2D)g);
		
		
		
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int row=-1;
		int col=-1;
		
		pointXclicked=e.getX();
		pointYclicked=e.getY();
		
		System.out.println (pointXclicked+"   "+pointYclicked);
		
		if(pointXclicked >=1  &&  pointXclicked <= 99) {col=0;}else
			if(pointXclicked >103  &&  pointXclicked < 200) {
				col=1;
			}else if(pointXclicked >200  &&  pointXclicked < 300) {
				col=2;
			}else {col=-1;}
		//System.out.print(row);
		
		if(pointYclicked >=1  &&  pointYclicked <= 99) {row=0;}else
			if(pointYclicked >103  &&  pointYclicked < 200) {
				row=1;
			}else if(pointYclicked >200  &&  pointYclicked < 300) {
				row=2;}else {row=-1;}
			if(board.board[row][col]==0 && gameOn) {
		System.out.print(row+""+col);
			if(playerX) {
		board.board[row][col]=1;
		playerX=false;}else {
			board.board[row][col]=2;
			playerX=true;
			
			
		}
			
			}
			
			
		//System.out.println("\n"+board.board[1][2]);
		
		//System.out.println("\n"+board.board[1][2]);
		repaint();
		checkPattern();
		
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	public void checkPattern() {

		/*
		//int a=i;
		
for( int i=0;i<3;i++){
	for(int j=0;j<2;j++) {
		
		int b=j+1;
		try {
		while(board.board[i][j]==board.board[i][j++] && board.board[i][j]!=0) 
		{
			System.out.print("Hello");
			
		}
		
		}catch(Exception e) {System.out.print("Out of bounds");
		}
		
	}
}
	*/
		
	if(board.board[0][0]==board.board[0][1] && board.board[0][0]==board.board[0][2]&&board.board[0][0]!=0) {
		
		System.out.print("Win1");
		gameOn=false;
		
	
		
	}	
		
	
	if(board.board[1][0]==board.board[1][1] && board.board[1][0]==board.board[1][2]&&board.board[1][0]!=0) {
		
		System.out.print("Win2");
		gameOn=false;
		
	}	
		
	

	if(board.board[2][0]==board.board[2][1] && board.board[2][0]==board.board[2][2]&&board.board[2][0]!=0) {
		
		System.out.print("Win3");
		gameOn=false;
	}	
		

	if(board.board[0][0]==board.board[1][0] && board.board[0][0]==board.board[2][0]&&board.board[0][0]!=0) {
		
		System.out.print("Win4");
		gameOn=false;
	}	
		
if(board.board[0][1]==board.board[1][1] && board.board[0][1]==board.board[2][1]&&board.board[0][1]!=0) {
		
		System.out.print("Win5");
		gameOn=false;
	}	
		
		
if(board.board[0][2]==board.board[1][2] && board.board[0][2]==board.board[2][2]&&board.board[0][2]!=0) {
	
	System.out.print("Win6");
	gameOn=false;
}	
	
if(board.board[0][0]==board.board[1][1] && board.board[0][0]==board.board[2][2]&&board.board[0][0]!=0) {
	
	System.out.print("Win7");
	gameOn=false;
}	
	
		
if(board.board[2][0]==board.board[1][1] && board.board[2][0]==board.board[0][2]&&board.board[2][0]!=0) {
	
	System.out.print("Win8");
	gameOn=false;
}	
			
		
		
		
		
	}
	

	
}
