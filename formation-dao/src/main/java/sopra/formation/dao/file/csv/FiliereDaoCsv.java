package sopra.formation.dao.file.csv;

import java.util.List;

import sopra.formation.dao.IFiliereDao;
import sopra.formation.model.Filiere;

public class FiliereDaoCsv implements IFiliereDao {

	private final String fileName;
	private final String separator = ";";

	public FiliereDaoCsv(String fileName) {
		super();
		this.fileName = fileName;
	}
	@Override
	public List<Filiere> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filiere findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Filiere obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Filiere obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Filiere obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
