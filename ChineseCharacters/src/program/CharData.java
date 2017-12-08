package program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class CharData {

	// reading characters data from the file
	
	static void read(String fileName) {

		try {
			File file = new File(fileName);
			Scanner sc = new Scanner(file, "UTF-8");
			sc.useDelimiter("\t+|\\r\\n");
			
			//System.out.println(sc.next());
			
			//while (sc.hasNextLine()) {
				ChinChar ch1 = new ChinChar(sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
				ChinChar ch2 = new ChinChar(sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
				//System.out.println(sc.next());
			//}
				System.out.println(ch1.getLabel() + " " + ch1.getSymbol() + " " + ch1.getPinyin() + " " + ch1.getSound() + " " + ch1.getMeaning());
				System.out.println(ch2.getLabel() + " " + ch2.getSymbol() + " " + ch2.getPinyin() + " " + ch2.getSound() + " " + ch2.getMeaning());
				sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
