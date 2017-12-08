package program;

import java.util.HashMap;

public class App {
	public static void main(String[] args) {
		
		// The unchanging data for the characters will be stored in dataMap.
		
		HashMap<String,ChinChar> dataMap = new HashMap<>();
		
		// Reading characters data from a file to dataMap.
		
		CharData.read("char_data.txt", dataMap);
		
		for (String str : dataMap.keySet()) {
			ChinChar ch = dataMap.get(str);
			System.out.println("The character: " + ch.getSymbol() + " with pinyin: " + ch.getPinyin() + " means: " + ch.getMeaning());
		}
		
	}
}
