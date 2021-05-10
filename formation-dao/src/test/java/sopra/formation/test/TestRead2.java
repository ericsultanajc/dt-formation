package sopra.formation.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestRead2 {
	
	private static final String EVAL_FILENAME = "evaluation2.txt";
	
	public static void main(String[] args) {
		
		brReader(EVAL_FILENAME);
		
	}
	
	public static List<String> brReader(String file) {
		
		List<String> ligne = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(EVAL_FILENAME))){
			String line=null;
			while ((line=br.readLine())!=null) {
				
				ligne.add(line);
				System.out.println(br.readLine());
				
			}
		}catch (IOException e) {}
		return ligne;
	}
	
	
	

}
