package sopra.formation.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestRead {

	private static final String EVAL_FILENAME = "evaluations.txt";

	public static void main(String[] args) throws IOException {
System.out.println("version d'Éric :");
		for(String line : readWithBufferedReader()) {
			System.out.println(line);
		}
		System.out.println("Ma version :");
		for(String line : readWithScanner()) {
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
	
	private static List<String> readWithScanner(){
		List<String> lines = new ArrayList<String>();
		try
	    {
	      FileInputStream file = new FileInputStream(EVAL_FILENAME);   
	      Scanner scanner = new Scanner(file);  
	      while(scanner.hasNextLine())
	      {
	    	  lines.add(scanner.nextLine());
	      }
	      scanner.close();    
	    }
	    catch(IOException e)
	    {
	      e.printStackTrace();
	    }
		return lines;
	}	
}
