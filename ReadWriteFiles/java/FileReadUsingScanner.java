package fileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReadUsingScanner {

	public static void main(String[] args) {
		File f = new File("/Users/rahul.raviprasad/Desktop/input.txt");
		try {
			Scanner scan  = new Scanner(f);

			while(scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}


			/*
			 * If you don't want to use looping
			 * we just need to use \\Z as delimiter
			 * */

//		    scan.useDelimiter("\\Z");
//		    System.out.println(scan.next());

		    scan.close();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
