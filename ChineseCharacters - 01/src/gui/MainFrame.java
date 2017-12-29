package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MainFrame extends JFrame{
	
	private JMenuBar menuBar;
	
	///////////////////// Contructor ///////////////////////////////////
	
	public MainFrame() {
		super("Learn Chinese Characters");
		
		//setLayout(new BorderLayout());
		
		setJMenuBar(createMenuBar());
		
		setSize(1000,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	///////////////// Creating menu bar ///////////////////////////////////////
	
	private JMenuBar createMenuBar() {
		menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu windowMenu = new JMenu("Window");
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(windowMenu);
		
		return menuBar;
	}
}
