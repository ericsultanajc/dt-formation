package sopra.formation.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestRead {

	private static final String EVAL_FILENAME = "evaluations.txt";

	public static void main(String[] args) {

//		for(String line : readWithBufferedReader()) {
//			System.out.println(line);
//		}
		for(String line : readWithNIO()) {
			System.out.println(line);
		}
		
	}

	private static List<String> readWithBufferedReader() {
		List<String> lines = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(EVAL_FILENAME))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return lines;
	}
	
	private static List<String> readWithNIO() {
	    Path path = Paths.get(EVAL_FILENAME);
	    List<String> read = null;
	    try {
			read = Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return read;
	}
	
}
