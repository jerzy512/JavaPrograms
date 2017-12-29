package gui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class App {
	
	/////////////////// Main method ////////////////////////
	
	public static void main(String[] args) {
		
		////////////////////////// Set windows look and feel /////////////////////
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Can't set system look and feel.");
		}
		
		//////////////////// Create main frame window //////////////////////////////
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
			}
		});
	}
}
