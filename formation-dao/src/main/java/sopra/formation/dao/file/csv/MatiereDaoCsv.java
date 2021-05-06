package sopra.formation.dao.file.csv;

import java.util.List;

import sopra.formation.dao.IMatiereDao;
import sopra.formation.model.Matiere;

public class MatiereDaoCsv implements IMatiereDao {
	private final String fileName;
	private final String separator = ";";

	public MatiereDaoCsv(String fileName) {
		super();
		this.fileName = fileName;
	}

	public List<Matiere> findAll() {
		return null;
	}

	public Matiere findById(Long id) {
		
		return null;
	}

	public void create(Matiere obj) {
	}

	public void update(Matiere obj) {
	}

	public void delete(Matiere obj) {
		deleteById(obj.getId());
	}
	
	public void deleteById(Long id) {
	}
}
