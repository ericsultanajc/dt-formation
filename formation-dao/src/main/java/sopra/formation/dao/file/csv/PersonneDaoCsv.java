package sopra.formation.dao.file.csv;

public class PersonneDaoCsv {
	
	private final String fileName;
	private final String separator = ";";

	public PersonneDaoCsv(String fileName) {
		super();
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public String getSeparator() {
		return separator;
	}

}