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
import java.io.PrintWriter;

public class TestWrite {

	private static final String EVAL_FILENAME = "evaluations.txt";

	public static void main(String[] args) {
		String evaluation1 = "1;15;18;Très bon élément";

		writeWithBuffered(evaluation1);
		writeWithFileOutputStream(evaluation1);
		writeWithNIO(evaluation1);
		
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
	
	private static void writeWithFileOutputStream2(String chaine) throws IOException {
		try (FileOutputStream writer = new FileOutputStream(EVAL_FILENAME, true)) {
			chaine += "\n";
			byte[] strToBytes = (chaine+"\n").getBytes();
			writer.write(strToBytes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void writeWithPrintWriter(String chaine) {
		try (FileWriter writer = new FileWriter(EVAL_FILENAME, true)) {
			PrintWriter printWriter = new PrintWriter(writer);
			printWriter.print(chaine+"\n");
		} catch (IOException e) {
			e.printStackTrace();
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
