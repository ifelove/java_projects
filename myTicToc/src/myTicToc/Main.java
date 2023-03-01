package myTicToc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main{

	public static void main(String[] args) {
		TicToc newGame=new TicToc();
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(300, 300);
		frame.setBounds(10,10,318,340);
	
		//frame.getContentPane().setBackground(Color.BLACK);
		frame.setLocationRelativeTo(null);
		
	
		frame.setVisible(true);
		frame.add(newGame);
	
	
	
	
	
	}
	
	
	
}
