package chessGame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Chessgame {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame=new JFrame();
		frame.setBounds(10,10,530,550);
		JPanel panel=new JPanel() {
			@Override
			public void paint(Graphics g) {
				
				boolean white=true;
				for (int i=0;i<8;i++) {
					for(int j=0;j<8;j++){
						
						if(white) {
							g.setColor(Color.WHITE);
						}else {
							g.setColor(Color.GREEN.darker());
						}
						
						g.fillRect(i*64, j*64,64,64);
						white=!white;
						
					}
					
					white=!white;
				}
				
				
			}
		};
		
		
		
		
		frame.add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}

}
