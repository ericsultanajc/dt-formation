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
	private static final String EVAL_FILENAME2 = "evaluations2.txt";

	public static void main(String[] args) throws IOException {
		String evaluation1 = "1;15;18;Très bon élément";

		writeWithBuffered(evaluation1);
		
		System.out.println("##############################");
		
		writeWithFileOutputStream(evaluation1);
		
		System.out.println("##############################");
		
		writeWithNIO(evaluation1);

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
	
	private static void writeWithPrinteWriter(String chaine) throws IOException {
		FileWriter fileWriter= new FileWriter(EVAL_FILENAME2);
		PrintWriter printWriter= new PrintWriter(fileWriter);
		printWriter.print(chaine+"\n");
		printWriter.close();
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
