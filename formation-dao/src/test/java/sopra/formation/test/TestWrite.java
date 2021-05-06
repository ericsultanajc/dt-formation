package sopra.formation.test;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestWrite {

	private static final String EVAL_FILENAME = "evaluations.txt";

	public static void main(String[] args) {
		String evaluation1 = "1;15;18;Très bon élément";

		solennwrite(evaluation1);
		
		writeWithBuffered(evaluation1);
		writeWithFileOutputStream(evaluation1);
		writeWithNIO(evaluation1);

	}

	private static void solennwrite(String chaine) {
		try (FileOutputStream outputStream = new FileOutputStream(EVAL_FILENAME,true)) {
	    byte[] strToBytes = chaine.getBytes();
	    outputStream.write(strToBytes);
	    outputStream.write('\n');
		outputStream.close();
	private static void writeWithBuffered(String chaine) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(EVAL_FILENAME, true))) {
			writer.write(chaine);
			writer.newLine();

		} catch (IOException e) {
		e.printStackTrace();
		}
	}

	private static void writeWithFileOutputStream(String chaine) {
		FileOutputStream outputStream = null;
		
		try {
			outputStream = new FileOutputStream(EVAL_FILENAME, true);
			byte[] strToBytes = chaine.getBytes();
			outputStream.write(strToBytes);
			outputStream.write('\n');

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
	}

	private static void writeWithNIO(String chaine) {
		Path path = Paths.get(EVAL_FILENAME);

		try {
			Files.writeString(path, chaine+"\n", StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

