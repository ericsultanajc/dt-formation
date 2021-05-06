package sopra.formation.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestRead {

	private static final String EVAL_FILENAME = "evaluations.txt";

	public static void main(String[] args) throws IOException {

		for(String line : read()) {
			System.out.println(line);
		}
		
	}

	private static List<String> read() throws IOException {
		List<String> lines = new ArrayList<String>();
		
		try (FileInputStream inputStream  = new FileInputStream(new File(EVAL_FILENAME))) {
			Scanner scanner = new Scanner(inputStream);
			while(scanner.hasNextLine())
            {
                lines.add(scanner.nextLine());
			
            }
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		return lines;
		
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
	}
}
