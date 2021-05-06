package sopra.formation.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestWrite {

	private static final String EVAL_FILENAME = "evaluations.txt";

	public static void main(String[] args) {
		String evaluation1 = "1;15;18;Très bon élément";

//		writeWithBuffered(evaluation1);
		writeWithPrintWriter(evaluation1);
		
	}

	private static void writeWithBuffered(String chaine) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(EVAL_FILENAME, true))) {
			writer.write(chaine);
			writer.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private static void writeWithPrintWriter(String chaine) {
		try (FileWriter fileWriter = new FileWriter(EVAL_FILENAME)){
			PrintWriter printWriter = new PrintWriter(fileWriter);
		    printWriter.print(chaine);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}

}
