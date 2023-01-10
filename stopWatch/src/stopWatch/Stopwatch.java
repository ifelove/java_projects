package stopWatch;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Stopwatch implements ActionListener {
	
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JButton startBtn=new JButton("START");
	JButton resetBtn=new JButton("RESET");
	JLabel timeLabel = new JLabel();
	int elapsedTime=0;
	int seconds=0;
	int minutes = 0;
	int hours = 0;
	boolean started=false;
	String seconds_string=String.format("%02d", seconds);
	String minutes_string=String.format("%02d", minutes);
	String hours_string=String.format("%02d", hours);
	Timer timer = new Timer(1000, new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			elapsedTime=elapsedTime + 1000;
			hours=(elapsedTime/3600000);
			minutes=(elapsedTime/60000)%60;
			seconds=(elapsedTime/1000)%60;
			 seconds_string=String.format("%02d", seconds);
			 minutes_string=String.format("%02d", minutes);
			 hours_string=String.format("%02d", hours);
				timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
			
			
		}
	});
	 

	Stopwatch(){
		// timeLabel set up
	timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
	timeLabel.setBounds(100,100, 200,100);
	timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
	timeLabel.setBorder(BorderFactory.createLineBorder(Color.black));//box with ordinary border line
	timeLabel.setBorder(BorderFactory.createBevelBorder(1));//border with box-shadow
	timeLabel.setOpaque(true);
	timeLabel.setHorizontalAlignment(JTextField.CENTER);
	
	
	//Buttons setup
	//start button
	startBtn.setBounds(100,200,100,50);
	startBtn.setFont(new Font("Ink Free",Font.PLAIN,20));
	startBtn.setFocusable(false);
	startBtn.addActionListener(this);
	
	//start button
		resetBtn.setBounds(200,200,100,50);
		resetBtn.setFont(new Font("Ink Free",Font.PLAIN,20));
		resetBtn.setFocusable(false);
		resetBtn.addActionListener(this);
		
	
	
	
	
	
	
	frame.add(startBtn);
	frame.add(resetBtn);
	frame.add(timeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == startBtn) {
		if(!started) {
			started=true;
			startBtn.setText("STOP"); 
			start();
		}else
		{
			started=false;
			startBtn.setText("PLAY"); 
			stop();
		}
		
		}
		if(e.getSource() == resetBtn) {
			started=false;
			startBtn.setText("START"); 
			reset();}
	
	}
	void start() {
		timer.start();
	}
	
	void stop() {
		timer.stop();
	}
	void reset() {
		timer.stop();
		elapsedTime=0;
		hours=0;
		minutes=0;
		seconds=0;
		
		// we need to convert the value to string
		 seconds_string=String.format("%02d", seconds);
		 minutes_string=String.format("%02d", minutes);
		 hours_string=String.format("%02d", hours);
			timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
		
					
		
		}
	}


