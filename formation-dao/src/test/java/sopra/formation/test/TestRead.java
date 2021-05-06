package sopra.formation.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestRead {

	private static final String EVAL_FILENAME = "evaluations.txt";

	public static void main(String[] args) {

		for(String line : readWithBufferedReader()) {
			System.out.println(line);
		}
		
		System.out.println("----------------------------");
		
		try {
			System.out.println(readWithDataInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static List<String> readWithBufferedReader() {
		List<String> lines = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(EVAL_FILENAME))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return lines;
	}
	
	private static String readWithDataInputStream() throws IOException{
		String result = null;
		
		try (DataInputStream reader = new DataInputStream(new FileInputStream(EVAL_FILENAME))){
			int toRead = reader.available();
			if(toRead>0) {
				byte[] bytes = new byte[toRead];
				reader.read(bytes);
				result = new String(bytes);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
		
	}
}
