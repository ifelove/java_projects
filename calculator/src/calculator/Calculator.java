
package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 public class Calculator implements ActionListener {
	 // the design using the javax.swing.*
	 JFrame frame;
	 JTextField textField;
	 JButton[] numberButtons = new JButton[10];
	 JButton[] functionButtons = new JButton[9];
	 JButton addBtn,minusBtn,mulBtn,divBtn;
	 JButton decBtn, equBtn,delBtn,clrBtn,negBtn;
	 JPanel panel;
	 
	 // the look color,font using java.awt
	 
	 Font myFont = new Font("Ink Free", Font.BOLD, 30);
	 
	 double num1=0;
	 double num2=0;
	 double result=0;
	 char operator;
			 
	 
	 
	 
	 Calculator(){
		 
		 System.out.print("hi");
		 // frame,the main calculator container
		 frame= new JFrame("Java Calculator");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setSize(420,550);
		 frame.setLayout(null);
		 // textField,the screen(the input)
		 textField = new  JTextField();
		 textField.setBounds(50, 25, 300, 50);
		
		 
		 textField.setFont(myFont);
		 textField.setEditable(false);
		 
		 
		 addBtn=new JButton("+");
		 minusBtn=new JButton("-");
		 mulBtn=new JButton("*");
		 divBtn=new JButton("/");
		 decBtn=new JButton(".");
		 equBtn=new JButton("=");
		 delBtn=new JButton("DEL");
		 clrBtn=new JButton("CE");
		 negBtn=new JButton("-/+");
		
		 
		 functionButtons[0]= addBtn;
		 functionButtons[1]= minusBtn;
		 functionButtons[2]= mulBtn;
		 functionButtons[3]= divBtn;
		 functionButtons[4]= decBtn;
		 functionButtons[5]= equBtn;
		 functionButtons[6]= delBtn;
		 functionButtons[7]= clrBtn;
		 functionButtons[8]=negBtn;
	
		for(int i = 0;i<functionButtons.length;i++){
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
			
		}
		 
		
		for(int i = 0;i<numberButtons.length;i++){
			numberButtons[i]=new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			
		}
		negBtn.setBounds(50, 430, 100, 50);	 
	delBtn.setBounds(150, 430, 100, 50);
	clrBtn.setBounds(250, 430, 100, 50);
	
	
	panel = new JPanel();
	panel.setBounds(50, 100, 300, 300);
	panel.setLayout(new GridLayout(4,4,10,10));
	panel.setBackground(Color.GRAY);
	
	panel.add(numberButtons[1]);
	panel.add(numberButtons[2]);
	panel.add(numberButtons[3]);
	panel.add(addBtn);
	panel.add(numberButtons[4]);
	panel.add(numberButtons[5]);
	panel.add(numberButtons[6]);
	panel.add(minusBtn);
	panel.add(numberButtons[7]);
	panel.add(numberButtons[8]);
	panel.add(numberButtons[9]);
	panel.add(mulBtn);
	panel.add(decBtn);
	panel.add(numberButtons[0]);
	panel.add(equBtn);
	panel.add(divBtn);
	
	
	frame.add(panel);
		frame.add(delBtn);
		frame.add(clrBtn);
		frame.add(negBtn);
		 frame.add(textField);  
		 frame.setVisible(true);
		 
		
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator newcal = new Calculator();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for(int i=0;i< numberButtons.length;i++) {
			if(e.getSource()== numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
			
		}
		if (e.getSource()==decBtn) {
			textField.setText(textField.getText().concat(". "));
		}
		if (e.getSource()==addBtn) {
			num1=Double.parseDouble(textField.getText());
			operator='+';
			
			textField.setText("");
		}
		if (e.getSource()==minusBtn) {
			num1=Double.parseDouble(textField.getText());
			operator='-';
			
			textField.setText("");
		}
		if (e.getSource()==mulBtn) {
			num1=Double.parseDouble(textField.getText());
			operator='*';
			
			textField.setText("");
		}
		if (e.getSource()==divBtn) {
			num1=Double.parseDouble(textField.getText());
			operator='/';
			
			textField.setText("");
		}
		
		
		if (e.getSource()==equBtn) {
			num2=Double.parseDouble(textField.getText());
			
			switch(operator) {
			
			case '+':
				result = num1+num2;
				break;
			case '-':
				result = num1-num2;
				break;
			case '*':
				result = num1*num2;
				break;
			case '/':
				result = num1/num2;
				break;
				
				
				
			}
			
			
			textField.setText(String.valueOf(result));
			num1=result;
		}	
		 
		if(e.getSource()==clrBtn) {
			textField.setText("");
			
		};
		
		if(e.getSource()==delBtn) {
			String screen =textField.getText().toString();
			//for(int  i=0;i<screen.length()-1 ;i++) {
				//textField.setText(textField.getText()+screen.charAt(i));
				screen=screen.substring(0,screen.length()-1);
				textField.setText(screen);
			//};
		};
		
		if(e.getSource()==negBtn) {
			double value =Double.parseDouble(textField.getText());
			
			value=value * -1;
			
		textField.setText(String.valueOf(value));
			
			
			
			
		//	String value="-"+textField.getText();
		//	textField.setText(String.valueOf(value));
			
			
		};
		
		
		
		
	}

	

}
