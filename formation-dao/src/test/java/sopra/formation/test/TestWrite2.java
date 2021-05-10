package sopra.formation.test;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestWrite2 {

	public static final String EVAL_FILENAME = "evaluation2.txt";
	
	
	public static void main(String[] args) {
		String evaluation = "1;12;14;Convenable";
		
		writer1(evaluation);
		
		System.out.println("###################");
		
		//writer2(evaluation);
		
		

	}
	
	public static void writer1 (String chaine) {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(EVAL_FILENAME, true))){
			bw.write(chaine);
			bw.newLine();
			
		} catch (IOException e) {e.printStackTrace();}	
	}
	
	public static void writer2 (String chaine) {
		
	    FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(EVAL_FILENAME);
			byte[] strToBytes = chaine.getBytes();
			outputStream.write(strToBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	   

	    
	}
}


