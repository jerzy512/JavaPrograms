package program;

import java.util.HashMap;

public class App {
	public static void main(String[] args) {
		
		// The unchanging data for the characters.
		
		HashMap<String,ChinChar> dataMap = new HashMap<>();
		
		// Reading characters data from a file.
		
		CharData.read("char_data.txt");
		
	}
}
