package sopra.formation.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestWrite {

	private static final String EVAL_FILENAME = "evaluations.txt";

	public static void main(String[] args) {
		String evaluation1 = "1;15;18;Très bon élément";

		writeWithBuffered(evaluation1);
		
//		try  {
//			givenWritingStringToFile_whenUsingPrintWriter_thenCorrect(evaluation1);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}

	private static void writeWithBuffered(String chaine) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(EVAL_FILENAME, true))) {
			writer.write(chaine);
			writer.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
//	public static void givenWritingStringToFile_whenUsingPrintWriter_thenCorrect(String chaine) throws IOException {
//			    FileWriter fileWriter = new FileWriter(EVAL_FILENAME);
//			    PrintWriter printWriter = new PrintWriter(fileWriter);
//			    printWriter.print(chaine + "\n");
//			    printWriter.close();
//			}

}
