package program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

class CharData {

	// reading characters data from the file to the map
	
	static void read(String fileName, HashMap<String,ChinChar> map) {

		try {
			File file = new File(fileName);
			Scanner sc = new Scanner(file, "UTF-8");
			sc.useDelimiter("\t+|\\r\\n");
			
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
}
