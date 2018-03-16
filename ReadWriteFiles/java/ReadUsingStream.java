package fileHandling;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadUsingStream {
	/*
	 * This is using java 8 features
	 *
	 * */

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();


		try {
			Stream<String> stream = Files.lines(Paths.get("/Users/rahul.raviprasad/Desktop/input.txt"));

			list = stream.filter(line -> !line.startsWith("hi"))
					.map(String::toUpperCase)
					.collect(Collectors.toList());

			stream.close();

		} catch(Exception e) {
			e.printStackTrace();
		}

		list.forEach(System.out::println);
	}
}
