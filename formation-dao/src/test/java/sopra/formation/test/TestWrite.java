package sopra.formation.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestWrite {

	private static final String EVAL_FILENAME = "evaluations.txt";
	private static final String EVAL_FILENAME2 = "evaluations2.txt";

	public static void main(String[] args) throws IOException {
		String evaluation1 = "1;15;18;Très bon élément";

		writeWithBuffered(evaluation1);
		writeWithPrinteWriter(evaluation1);
		
	}

	private static void writeWithBuffered(String chaine) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(EVAL_FILENAME, true))) {
			writer.write(chaine);
			writer.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private static void writeWithPrinteWriter(String chaine) throws IOException {
		FileWriter fileWriter= new FileWriter(EVAL_FILENAME2);
		PrintWriter printWriter= new PrintWriter(fileWriter);
		printWriter.print(chaine+"\n");
		printWriter.close();
	}
		

}
