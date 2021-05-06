package sopra.formation.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestWrite {

	private static final String EVAL_FILENAME = "evaluations.txt";

	public static void main(String[] args) throws IOException {
		String evaluation1 = "1;15;18;Très bon élément";
		FileWriter fileWriter = new FileWriter("evaluations.txt", true);
		PrintWriter writer = new PrintWriter(fileWriter);

		//writeWithBuffered(evaluation1);		
		writeWithPrintWrite(evaluation1, writer);
		writer.close();
		
	}

	private static void writeWithBuffered(String chaine) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(EVAL_FILENAME, true))) {
			writer.write(chaine);
			writer.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void writeWithPrintWrite(String chaine, PrintWriter writer) {
			    
				writer.println(chaine);
			}

}
