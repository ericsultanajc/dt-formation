package sopra.formation.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestWrite {

	private static final String EVAL_FILENAME = "evaluations.txt";

	public static void main(String[] args) {
		String evaluation1 = "1;15;18;Très bon élément";

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
		try (FileWriter writer = new FileWriter(EVAL_FILENAME)) {
		writer.write(chaine);
		}
		 catch (IOException e) {
				e.printStackTrace();
			}
	}

}
