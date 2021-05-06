package sopra.formation.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestRead {

	private static final String EVAL_FILENAME = "evaluations.txt";

	public static void main(String[] args) {

		for(String line : readWithBufferedReader()) {
			System.out.println(line);
		}
		
		for(String line : readwithLineNumberReader()) {
			System.out.println(line);
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

	private List<String> readwithLineNumberReader() {
		
		List<String> lines = new ArrayList<String>();
		
		try (LineNumberReader lnr = new LineNumberReader(new FileReader(EVAL_FILENAME))) {
			String line=null;
			while ((lnr.getLineNumber() != 0)) {
				lines.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lines;
		
	}

}
