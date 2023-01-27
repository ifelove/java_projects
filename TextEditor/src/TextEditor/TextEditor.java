package TextEditor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextEditor extends JFrame implements ActionListener {
	
	
	JTextArea textArea=new JTextArea();
	JScrollPane scrollPane;
	JSpinner fontSizeSpinner= new JSpinner();
	JButton fontColorBtn=new JButton("Color");
	JComboBox fontSelectBox;
	
	JMenuBar menuBar=new JMenuBar();
	JMenu fileMenu=new JMenu("File");
	JMenuItem openItem=new JMenuItem("Open");
	JMenuItem saveItem=new JMenuItem("Save");
	JMenuItem exitItem=new JMenuItem("Exit");
	
	TextEditor(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Text Editor");
		this.setSize(500,500);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);//center the frame
		
		textArea.setPreferredSize(new Dimension(450,450));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Arial",Font.PLAIN,20));
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(450,450));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//font spinner
		fontSizeSpinner.setPreferredSize(new Dimension(50,25));
		fontSizeSpinner.setValue(20);
		fontSizeSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int)fontSizeSpinner.getValue()));
				
			}});
		
		//font color chooser
		fontColorBtn.addActionListener( this);
		
		
		String[] fonts= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		JLabel fontLabel=new JLabel("Font: ");
		fontSelectBox  =new JComboBox(fonts) ;
		fontSelectBox.addActionListener(this);
		fontSelectBox.setSelectedItem("Arial");
		//------------MenuBar------------
		
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		
		
		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		
		
		
		//----------MenuBar---------------
		
		
		
		
		
		this.setJMenuBar(menuBar);
		this.add(fontLabel);
		this.add(fontSizeSpinner);
		this.add(fontColorBtn);
		this.add(fontSelectBox);
	
		this.add(scrollPane);
		this.setVisible(true); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource()==fontColorBtn) {
			
			JColorChooser  colorChooser=new JColorChooser(); //calling color chooser
			
			Color color =colorChooser.showDialog(null, "Choose a color",Color.black);
			textArea.setForeground(color);
		}
		if(e.getSource()==fontSelectBox) {
			textArea.setFont(new Font((String)fontSelectBox.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
		}
		if(e.getSource()==openItem) {
			JFileChooser fileChooser=new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
	
			FileNameExtensionFilter filter=new FileNameExtensionFilter("Text File", "txt");//opening text file with txt extention
		fileChooser.setFileFilter(filter);
		int response=fileChooser.showOpenDialog(null); 
		if (response == JFileChooser.APPROVE_OPTION) {}
			File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
			Scanner fileContent=null;
			
			try {
			fileContent=new Scanner(file);
				if(file.isFile()){//checking if it a file
				while(fileContent.hasNextLine()) { //reading the content
					String line=fileContent.nextLine()+"\n"; //assigning the content
					textArea.append(line);
					
				}
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				fileContent.close();
			}
			
		}
		if(e.getSource()==saveItem) {
			JFileChooser fileChooser=new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			int response=fileChooser.showSaveDialog(null); 
			if (response == JFileChooser.APPROVE_OPTION) {
				File file;
				PrintWriter fileOut = null;
				
				file =new File(fileChooser.getSelectedFile().getAbsolutePath());
				try {				
					fileOut=new PrintWriter(file);
					fileOut.println(textArea.getText());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					fileOut.close();
				}
			}
		}
		if(e.getSource()==exitItem) {
			System.exit(ABORT);
		}
	}

	
}
