package sopra.formation.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestWrite {

	private static final String EVAL_FILENAME = "evaluations.txt";
	
	public static void main(String[] args) throws IOException {
		FileWriter fileWriter = new FileWriter("evaluations.txt",true);
	    PrintWriter writer = new PrintWriter(fileWriter);
		String evaluation1 = "1;15;18;Très bon élément";

		writeBaptiste(evaluation1, writer);
		writer.close();
		
	}

	private static void writeBaptiste(String chaine,PrintWriter writer) {
		
	    writer.println(chaine);
	    
	}

}