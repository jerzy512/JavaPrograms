package program;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

class CharData {

	// reading characters data from the file to the map
	
	static void read(String fileName, HashMap<String,ChinChar> map) {

		try {
			File file = new File(fileName);
			Scanner sc = new Scanner(file, "UTF-8");
			sc.useDelimiter("\t+|\\n|\\r\\n");
			
			while (sc.hasNextLine()) {
				
				String label = sc.next();
				String symbol = sc.next();
				String pinyin = sc.next();
				String sound = sc.next();
				String meaning = sc.next();
				
				map.put(symbol, new ChinChar(label, symbol, pinyin, sound, meaning));
			}
				sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void playSound(String fileName) {
		File file = new File(fileName);
		try {
			Player player = new Player(new FileInputStream(file));
			player.play();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
