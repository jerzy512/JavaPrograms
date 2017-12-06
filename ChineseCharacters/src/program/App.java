package program;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		
		// reading characters data from char_data.txt
		
		try {
			
			Scanner sc = new Scanner(
					new InputStreamReader(
							new FileInputStream("char_data.txt"), 
							"UTF-8"
							)
					);
			
			char ch1 = sc.next().charAt(0);
			int int1 = sc.nextInt();
			String str1 = sc.next();
			String str2 = "sound\\" + sc.next() + ".mp3";
			String str3 = sc.next();
			//while (sc.next() == "\t") {}
			String str4 = sc.nextLine();
			//sc.nextLine();
			System.out.print("The character is: " + ch1 + " at position: " + int1);
			System.out.println(" with the pinyin: " + str1);
			System.out.println("The sound is in file: " + str2);
			System.out.println("The construction of the character is: " + str3);
			System.out.println("The meaning of the character is: " + str4);
			
			System.out.println();
			
			ch1 = sc.next().charAt(0);
			int1 = sc.nextInt();
			str1 = sc.next();
			str2 = "sound\\" + sc.next() + ".mp3";
			str3 = sc.next();
			str4 = sc.nextLine();
			sc.nextLine();
			System.out.print("The character is: " + ch1 + " at position: " + int1);
			System.out.println(" with the pinyin: " + str1);
			System.out.println("The sound is in file: " + str2);
			System.out.println("The construction of the character is: " + str3);
			System.out.println("The meaning of the character is: " + str4);
			
			
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
