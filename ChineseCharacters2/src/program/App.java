package program;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class App {
	public static void main(String[] args) {
		
		// reading characters data from char_data.txt
		
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("char_data.txt"), "UTF-8"
							)
					);
			
			String str;
			
			str = br.readLine();
			System.out.println(str);
			
			str = br.readLine();
			System.out.println(str);
			
			System.out.println("是");
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		// creating backups of files

		File file1 = new File("char_data.txt");
		File file2 = new File("char_data.bak");

		if (file1.exists()) {
			if (file2.exists()) {
				System.out.println("deleting file: " + file2);
				file2.delete();
			}
			System.out.println("renaming file: " + file1 + " to: " + file2);
			file1.renameTo(file2);
		}

		System.out.println("creating new file: " + file1);
		try {
			file1.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		
		File progFile = new File("prog_data.txt");
		File progFile1 = new File("prog_data.bk1");
		File progFile2 = new File("prog_data.bk2");

		if (progFile.exists()) {
			if (progFile1.exists()) {
				if (progFile2.exists()) {
					System.out.println("deleting file: " + progFile2);
					progFile2.delete();
				}
				System.out.println("renaming file: " + progFile1 + " to: " + progFile2);
				progFile1.renameTo(progFile2);
			}
			System.out.println("renaming file: " + progFile + " to: " + progFile1);
			progFile.renameTo(progFile1);
		}

		System.out.println("creating new file: " + progFile);
		try {
			progFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
}
