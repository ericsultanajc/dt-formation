package sopra.formation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TestRead {

	private static final String EVAL_FILENAME = "evaluations.txt";
	
	public static void main(String[] args) {
		
		try {
			whenReadWithScanner_thenCorrect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*File file = new File("evaluations.txt");
		InputStream inputStream = null;
		try {
			try {
				inputStream = new FileInputStream(file);
				try {
					System.out.println(readFromInputStream(inputStream));
				} catch (IOException e) {
					e.printStackTrace();
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}*/

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
	
	private static String readFromInputStream(InputStream inputStream) throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}
	
	public static void whenReadWithScanner_thenCorrect()
			  throws IOException {
			    String file = "evaluations.txt";
			    Scanner scanner = new Scanner(new File(file));
			    scanner.useDelimiter(" ");

			    assertTrue(scanner.hasNext());

			    scanner.close();
			    
			}
}
