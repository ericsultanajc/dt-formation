package sopra.formation.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestRead {

	private static final String EVAL_FILENAME = "evaluations.txt";

	public static void main(String[] args) {

		for (String line : readWithBufferedReader()) {
			System.out.println(line);
		}

		System.out.println("##############################");

		for (String line : readWithScanner()) {
			System.out.println(line);
		}

		System.out.println("##############################");

		for (String line : readWithNIO()) {
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
		} catch (IOException e) {
//		for(String line : readWithBufferedReader()) {
//			System.out.println(line);
//		}
		
		try {
			whenReadLargeFileJava7_thenCorrect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lines;
	}

	private static List<String> readWithScanner() {
		List<String> lines = new ArrayList<String>();

		try (FileInputStream fis = new FileInputStream(EVAL_FILENAME); Scanner scanner = new Scanner(fis)) {
			while (scanner.hasNextLine()) {
				lines.add(scanner.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lines;
	}

	private static List<String> readWithNIO() {
		Path path = Paths.get(EVAL_FILENAME);

		List<String> lines = new ArrayList<String>();
		
		try {
			lines = Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lines;
	}

//	private static List<String> readWithBufferedReader() {
//		List<String> lines = new ArrayList<String>();
//		
//		try (BufferedReader br = new BufferedReader(new FileReader(EVAL_FILENAME))) {
//			String line = null;
//			while ((line = br.readLine()) != null) {
//				lines.add(line);
//			}
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//		return lines;
//	}
	
	
	public static void whenReadLargeFileJava7_thenCorrect() throws IOException {
			    

			    Path path = Paths.get(EVAL_FILENAME);

			    BufferedReader reader = Files.newBufferedReader(path);
			    String line = reader.readLine();
			    do {
			    	System.out.println(line);
			    } while ((line = reader.readLine())!=null);
			    		
			    }
			    
			
	
	
}
