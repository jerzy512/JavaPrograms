package program;

import java.util.HashMap;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		// The unchanging data for the characters will be stored in dataMap.
		
		HashMap<String,ChinChar> dataMap = new HashMap<>();
		
		// Reading characters data from a file to dataMap.
		
		CharData.read("char_data.txt", dataMap);
		
		/*
		for (String str : dataMap.keySet()) {
			ChinChar ch = dataMap.get(str);
			System.out.println("The character: " + ch.getSymbol() + " with pinyin: " + ch.getPinyin() + " means: " + ch.getMeaning());
			CharData.playSound("sound/" + ch.getSound() + ".mp3");
		}
		*/
		//CharData.playSound("sound/shi4.mp3");
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();								
			}
		});
	}
}
