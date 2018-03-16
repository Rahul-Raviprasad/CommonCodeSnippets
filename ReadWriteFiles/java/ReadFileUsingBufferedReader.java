package fileHandling;

import  java.io.*;

public class ReadFileUsingBufferedReader {

	public static void main(String[] args) throws Exception {
		/*
		 *
		 * */

		File file = new File("/Users/rahul.raviprasad/Desktop/input.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		while((st = br.readLine()) != null) {
			System.out.println(st);
		}

		br.close();
	}
}
