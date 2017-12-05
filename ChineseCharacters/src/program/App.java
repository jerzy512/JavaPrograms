package program;

import java.io.File;
import java.io.IOException;

public class App {
	public static void main(String[] args) {
		
		// creating backups of files
		
		File file1 = new File("char_data.txt");
		File file2 = new File("char_data.bak");
		
		if (file1.exists()) {
			if (file2.exists()) {
			System.out.println("deleting file " + file2);
			file2.delete();
			}
			System.out.println("renaming " + file1 + " to " + file2);
			file1.renameTo(file2);
			System.out.println("creating file: " + file1);
			try {
				file1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
