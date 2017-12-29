package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class TheMenuBar extends JMenuBar {
	
	////////////////////// Constructor //////////////////////////
	
	public TheMenuBar() {
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu windowMenu = new JMenu("Window");
		
		add(fileMenu);
		add(editMenu);
		add(windowMenu);
	}
}
