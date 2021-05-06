package sopra.formation.test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class TestWrite {

	private static final String EVAL_FILENAME = "evaluations.txt";

	public static void main(String[] args) {
		String evaluation1 = "1;15;18;Très bon élément";

		solennwrite(evaluation1);
		
	}

	private static void solennwrite(String chaine) {
		try (FileOutputStream outputStream = new FileOutputStream(EVAL_FILENAME,true)) {
	    byte[] strToBytes = chaine.getBytes();
	    outputStream.write(strToBytes);
	    outputStream.write('\n');
		outputStream.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
//		try (BufferedWriter writer = new BufferedWriter(new FileWriter(EVAL_FILENAME, true))) {
//			writer.write(chaine);
//			writer.newLine();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		}
	}


