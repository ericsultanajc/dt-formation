package sopra.formation.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestRead {

	private static final String EVAL_FILENAME = "evaluations.txt";

	public static void main(String[] args) throws FileNotFoundException {

//		for(String line : readWithBufferedReader()) {
//			System.out.println(line);
//		}
		readWithScanner();
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
	
	

	private static void readWithScanner() throws FileNotFoundException {
		
		    File file = new File(EVAL_FILENAME);

		    try {
		    	
		        Scanner sc = new Scanner(file);

		        while (sc.hasNextLine()) {
		        	
		            String i = sc.nextLine();
		            System.out.println(i);
		            
		        }
		        
		        sc.close();
		    } 
		    
		    catch (FileNotFoundException e) {
		        e.printStackTrace();
		    }
		 }
		
}
